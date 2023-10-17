package uk.autores.integration.mavencp.test;

import org.junit.jupiter.api.Test;
import uk.autores.integration.mavencp.Foo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

class StandardTest {

    @Test
    void verify() {
        assertNotNull(Foo.text());
        fail();
    }
}
