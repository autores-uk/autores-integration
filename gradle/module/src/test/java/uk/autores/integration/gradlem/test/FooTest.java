package uk.autores.integration.gradlem.test;

import org.junit.jupiter.api.Test;
import uk.autores.integration.gradlem.Foo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FooTest {

    @Test
    void checkFoo() {
        assertNotNull(Foo.text());
    }
}
