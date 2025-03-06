package uk.autores.integration.mavencp.test.generated;

import org.junit.jupiter.api.Test;
import uk.autores.ByteArrays;
import uk.autores.Strategy;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ByteArrays(
        name = "Inline",
        value = {
                "BinaryInlineSingleByte65534.txt",
                "BinaryInlineSingleByte65535.txt",
                "BinaryInlineSingleByte65536.txt",
                //"BinaryInlineAll16BitSequences.bin",
                //"BinaryInlineMegabytes.bin",
        },
        strategy = Strategy.INLINE
)
@ByteArrays(
        name = "Const",
        value = {
                "BinaryEncodedSingleByte65534.txt",
                "BinaryEncodedSingleByte65535.txt",
                "BinaryEncodedSingleByte65536.txt",
                "BinaryEncodedAll16BitSequences.bin",
                "BinaryEncodedMegabytes.bin",
        },
        strategy = Strategy.CONST
)
@ByteArrays(
        name = "Lazy",
        value = {
                "BinaryLazyMegabytes.bin",
        },
        strategy = Strategy.LAZY
)
class ByteArrayTest {

    @Test
    void isExpectedLengthAndContent() throws IOException {
        verify("BinaryInlineSingleByte65534.txt", Inline.binaryInlineSingleByte65534());
        verify("BinaryInlineSingleByte65535.txt", Inline.binaryInlineSingleByte65535());
        verify("BinaryInlineSingleByte65536.txt", Inline.binaryInlineSingleByte65536());
        //verify("BinaryInlineAll16BitSequences.bin", Inline.binaryInlineAll16BitSequences());
        //verify("BinaryInlineMegabytes.bin", BinaryInlineMegabytes.bytes());

        verify("BinaryEncodedSingleByte65534.txt", Const.binaryEncodedSingleByte65534());
        verify("BinaryEncodedSingleByte65535.txt", Const.binaryEncodedSingleByte65535());
        verify("BinaryEncodedSingleByte65536.txt", Const.binaryEncodedSingleByte65536());
        verify("BinaryEncodedAll16BitSequences.bin", Const.binaryEncodedAll16BitSequences());
        verify("BinaryEncodedMegabytes.bin", Const.binaryEncodedMegabytes());

        verify("BinaryLazyMegabytes.bin", Lazy.binaryLazyMegabytes());
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
