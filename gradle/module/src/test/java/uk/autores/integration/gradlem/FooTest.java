package uk.autores.integration.gradlem;

import org.junit.jupiter.api.Test;
import uk.autores.integration.gradlem.Gradlem;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FooTest {

    @Test
    void checkFoo() {
        assertNotNull(Gradlem.foo());
    }
}
