package uk.autores.integration.mavencp.test.generated;

import org.junit.jupiter.api.Test;
import uk.autores.Strategy;
import uk.autores.Texts;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

@Texts(
        value = {
                "InlineSingleByte65534.txt",
                "InlineSingleByte65535.txt",
                "InlineSingleByte65536.txt",
                "InlineAllCodePoints.txt",
        },
        strategy = Strategy.INLINE
)
class StringsTest {

    @Test
    void isExpectedLengthAndContent() throws IOException {
        verify("InlineSingleByte65534.txt", InlineSingleByte65534.text());
        verify("InlineSingleByte65535.txt", InlineSingleByte65535.text());
        verify("InlineSingleByte65536.txt", InlineSingleByte65536.text());
        verify("InlineAllCodePoints.txt", InlineAllCodePoints.text());
    }

    private void verify(String resource, String s) throws IOException {
        try (InputStream in = StringsTest.class.getResourceAsStream(resource);
             InputStream buf = new BufferedInputStream(in);
            Reader reader = new InputStreamReader(buf, StandardCharsets.UTF_8)) {
            for (int i = 0; i < s.length(); i++) {
                int expected = reader.read();
                assertFalse(expected < 0);
                char actual = s.charAt(i);
                assertEquals((char) expected, actual);
            }
            assertTrue(reader.read() < 0, "exhausted");
        }
    }
}
