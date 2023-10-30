package uk.autores.integration.filegen;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.io.Writer;
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
            IntStream.rangeClosed(Character.MIN_CODE_POINT, Character.MAX_CODE_POINT)
                    .filter(Character::isDefined)
                    .filter(n -> n < Character.MIN_SURROGATE || n > Character.MAX_SURROGATE)
                    .mapToObj(Character::toChars)
                    .forEach(arr -> write(writer, arr));
        }
    }

    private static void write(Writer writer, char[] arr) {
        try {
            writer.write(arr);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
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
