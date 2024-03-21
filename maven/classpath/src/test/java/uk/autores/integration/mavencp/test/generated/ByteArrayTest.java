package uk.autores.integration.mavencp.test.generated;

import org.junit.jupiter.api.Test;
import uk.autores.ByteArrayResources;
import uk.autores.Strategy;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ByteArrayResources(
        value = {
                "BinaryInlineSingleByte65534.txt",
                "BinaryInlineSingleByte65535.txt",
                "BinaryInlineSingleByte65536.txt",
                "BinaryInlineAll16BitSequences.bin",
                "BinaryInlineMegabytes.bin",
        },
        strategy = Strategy.INLINE
)
@ByteArrayResources(
        value = {
                "BinaryEncodedSingleByte65534.txt",
                "BinaryEncodedSingleByte65535.txt",
                "BinaryEncodedSingleByte65536.txt",
                "BinaryEncodedAll16BitSequences.bin",
                "BinaryEncodedMegabytes.bin",
        },
        strategy = Strategy.CONST
)
@ByteArrayResources(
        value = {
                "BinaryLazyMegabytes.bin",
        },
        strategy = Strategy.LAZY
)
class ByteArrayTest {

    @Test
    void isExpectedLengthAndContent() throws IOException {
        verify("BinaryInlineSingleByte65534.txt", BinaryInlineSingleByte65534.bytes());
        verify("BinaryInlineSingleByte65535.txt", BinaryInlineSingleByte65535.bytes());
        verify("BinaryInlineSingleByte65536.txt", BinaryInlineSingleByte65536.bytes());
        verify("BinaryInlineAll16BitSequences.bin", BinaryInlineAll16BitSequences.bytes());
        verify("BinaryInlineMegabytes.bin", BinaryInlineMegabytes.bytes());

        verify("BinaryEncodedSingleByte65534.txt", BinaryEncodedSingleByte65534.bytes());
        verify("BinaryEncodedSingleByte65535.txt", BinaryEncodedSingleByte65535.bytes());
        verify("BinaryEncodedSingleByte65536.txt", BinaryEncodedSingleByte65536.bytes());
        verify("BinaryEncodedAll16BitSequences.bin", BinaryEncodedAll16BitSequences.bytes());
        verify("BinaryEncodedMegabytes.bin", BinaryEncodedMegabytes.bytes());

        verify("BinaryLazyMegabytes.bin", BinaryLazyMegabytes.bytes());
    }

    private void verify(String resource, byte[] barr) throws IOException {
        try (InputStream in = StringsTest.class.getResourceAsStream(resource);
             InputStream buf = new BufferedInputStream(in)) {
            for (byte actual : barr) {
                int expected = buf.read();
                assertTrue(expected >= 0);
                assertEquals((byte) expected, actual);
            }
            assertTrue(buf.read() < 0, "exhausted");
        }
    }
}
