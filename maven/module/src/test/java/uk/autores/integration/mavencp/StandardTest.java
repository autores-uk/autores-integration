package uk.autores.integration.mavencp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StandardTest {

    @Test
    void verify() {
        assertNotNull(Mavencp.foo());
    }
}
