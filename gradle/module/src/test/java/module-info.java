module uk.autores.integration.gradlem.test {
    requires uk.autores.integration.gradlem;

    requires org.junit.jupiter.api;
    requires org.junit.jupiter.engine;

    opens uk.autores.integration.gradlem.test  to org.junit.platform.commons;
}
