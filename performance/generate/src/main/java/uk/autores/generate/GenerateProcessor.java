package uk.autores.generate;

import uk.autores.ByteArrays;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Name;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.FileObject;
import javax.tools.JavaFileObject;
import javax.tools.StandardLocation;
import java.io.*;
import java.util.*;

public final class GenerateProcessor extends AbstractProcessor {

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return processingEnv.getSourceVersion();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton(Generate.class.getName());
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        try {
            return proc(annotations, roundEnv);
        } catch (Exception e) {
            this.processingEnv.getMessager()
                    .printMessage(Diagnostic.Kind.ERROR, e.toString());
        }
        return false;
    }

    private boolean proc(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) throws IOException {
        boolean consumed = false;
        for (TypeElement te : annotations) {
            consumed = true;
            Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(Generate.class);
            for (Element e : elements) {
                Generate g = e.getAnnotation(Generate.class);
                generate((PackageElement) e, g, roundEnv);
            }
        }
        return consumed;
    }

    private void generate(PackageElement annotated, Generate g, RoundEnvironment roundEnv) throws IOException {
        Name pkg = processingEnv.getElementUtils()
                .getPackageOf(annotated)
                .getQualifiedName();

        List<Res> texts = new ArrayList<>();
        for (Res res : g.value()) {
            if (res.text()) {
                texts.add(res);
            } else {
                writeBin(pkg, res);
            }
        }
    }

    private void writeBin(Name pkg, Res res) throws IOException {
        Random r = new Random(0);
        FileObject file = processingEnv.getFiler()
                .createResource(StandardLocation.CLASS_OUTPUT, pkg, res.name());
        try (OutputStream out = file.openOutputStream()) {
            long remaining = res.size();
            byte[] buf = new byte[64 * 1024];
            while (remaining > 0) {
                r.nextBytes(buf);
                int len = remaining > buf.length ? buf.length : (int) remaining;
                out.write(buf, 0, len);
                remaining -= len;
            }
        }
    }

    private void writeText(Name pkg, Res res) throws IOException {
        UnicodeFunction uf = new UnicodeFunction();
        FileObject file = processingEnv.getFiler()
                .createResource(StandardLocation.CLASS_OUTPUT, pkg, res.name());
        try (Writer out = file.openWriter()) {
            long remaining = res.size();
            char[] buf = new char[64 * 1024];
            while (remaining > 0) {
                int n = uf.fill(buf);
                int len = remaining > n ? n : (int) remaining;
                out.write(buf, 0, len);
                remaining -= len;
            }
        }
    }
}
