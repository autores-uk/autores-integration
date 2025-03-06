package uk.autores.integration.gradlecp.test;

import org.junit.jupiter.api.Test;
import uk.autores.integration.gradlecp.Gradlecp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FooTest {

    @Test
    void checkFoo() {
        assertNotNull(Gradlecp.foo());
    }
}
