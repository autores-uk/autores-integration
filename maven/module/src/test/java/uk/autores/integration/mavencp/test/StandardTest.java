package uk.autores.integration.mavencp.test;

import org.junit.jupiter.api.Test;
import uk.autores.integration.mavencp.Mavencp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class StandardTest {

    @Test
    void verify() {
        assertNotNull(Mavencp.foo());
    }
}
