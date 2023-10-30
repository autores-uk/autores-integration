package uk.autores.integration.mavencp.test.generated;

import org.junit.jupiter.api.Test;
import uk.autores.GenerateByteArraysFromFiles;
import uk.autores.GenerateStringsFromText;
import uk.autores.ResourceFiles;
import uk.autores.cfg.Strategy;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static uk.autores.cfg.Strategy.STRATEGY;

@ResourceFiles(
        value = {
                "BinaryInlineSingleByte65534.txt",
                "BinaryInlineSingleByte65535.txt",
                "BinaryInlineSingleByte65536.txt",
        },
        handler = GenerateByteArraysFromFiles.class,
        config = @ResourceFiles.Cfg(key = STRATEGY, value = Strategy.INLINE)
)
@ResourceFiles(
        value = {
                "BinaryEncodedSingleByte65534.txt",
                "BinaryEncodedSingleByte65535.txt",
                "BinaryEncodedSingleByte65536.txt",
        },
        handler = GenerateByteArraysFromFiles.class,
        config = @ResourceFiles.Cfg(key = STRATEGY, value = Strategy.ENCODE)
)
class ByteArrayTest {

    @Test
    void isExpectedLengthAndContent() throws IOException {
        verify("BinaryInlineSingleByte65534.txt", BinaryInlineSingleByte65534.bytes());
        verify("BinaryInlineSingleByte65535.txt", BinaryInlineSingleByte65535.bytes());
        verify("BinaryInlineSingleByte65536.txt", BinaryInlineSingleByte65536.bytes());
        verify("BinaryEncodedSingleByte65534.txt", BinaryEncodedSingleByte65534.bytes());
        verify("BinaryEncodedSingleByte65535.txt", BinaryEncodedSingleByte65535.bytes());
        verify("BinaryEncodedSingleByte65536.txt", BinaryEncodedSingleByte65536.bytes());
    }

    private void verify(String resource, byte[] barr) throws IOException {
        try (InputStream in = StringsTest.class.getResourceAsStream(resource);
             Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8)) {
            for (byte actual : barr) {
                int expected = reader.read();
                assertFalse(expected < 0);
                assertEquals((byte) expected, actual);
            }
            assertTrue(reader.read() < 0, "exhausted");
        }
    }
}
