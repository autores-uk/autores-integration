package uk.autores.integration.filegen;

import java.io.*;
import java.nio.file.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class Main {
    public static void main(String[] args) throws IOException {
        // text
        generateOneByteUtf8Texts("Inline");
        Path resdir = locateResourceDir();
        generateAllCodePoints(resdir.resolve("InlineAllCodePoints.txt"));
        // bytes
        generateOneByteUtf8Texts("BinaryInline");
        generateOneByteUtf8Texts("BinaryEncoded");
        generateAll16bitSequences(resdir.resolve("BinaryInlineAll16BitSequences.bin"));
        generateAll16bitSequences(resdir.resolve("BinaryEncodedAll16BitSequences.bin"));
        int megs = 1024 * 1024 * 2;
        generateOneByteUtf8Text(resdir.resolve("BinaryInlineMegabytes.bin"), megs);
        generateOneByteUtf8Text(resdir.resolve("BinaryEncodedMegabytes.bin"), megs);
        generateOneByteUtf8Text(resdir.resolve("BinaryLazyMegabytes.bin"), megs);
    }

    private static void generateOneByteUtf8Texts(String strategy) throws IOException {
        Path resdir = locateResourceDir();
        int[] cases = {0xFFFF, 0xFFFF - 1, 0xFFFF + 1};
        for (int c : cases) {
            Path file = resdir.resolve(strategy + "SingleByte" + c + ".txt");
            generateOneByteUtf8Text(file, c);
        }
    }

    private static void generateOneByteUtf8Text(Path path, int size) throws IOException {
        String s = IntStream.rangeClosed('a', 'z')
                .mapToObj(i -> String.valueOf((char) i))
                .collect(joining()) + '\n';
        try (Writer writer = Files.newBufferedWriter(path)) {
            for (int i = 0; i < size; i++) {
                writer.append(s.charAt(i % s.length()));
            }
        }
    }

    private static void generateAllCodePoints(Path path) throws IOException {
        // https://www.unicode.org/Public/UCD/latest/ucd/UnicodeData.txt
        try (Writer writer = Files.newBufferedWriter(path)) {
            for (int cp = Character.MIN_CODE_POINT; cp <= Character.MAX_CODE_POINT; cp++) {
                if (!Character.isDefined(cp) || (cp >= Character.MIN_SURROGATE && cp <= Character.MAX_SURROGATE)) {
                    continue;
                }
                writer.write(Character.toChars(cp));
            }
        }
    }

    private static void generateAll16bitSequences(Path path) throws IOException {
        try (OutputStream out = Files.newOutputStream(path);
             DataOutputStream dos = new DataOutputStream(out)) {
            for (int i = 0; i <= 0xFFFF; i++) {
                short s = (short) i;
                dos.writeShort(s);
            }
        }
    }

    private static Path locateResourceDir() {
        Path resdir = Path.of("classpath/src/test/resources/uk/autores/integration/mavencp/test/generated");
        Path here = Path.of("").toAbsolutePath();
        Path wanted = here.getParent().resolve(resdir);
        if (!Files.isDirectory(wanted)) {
            throw new AssertionError(wanted.toString());
        }
        return wanted;
    }
}
