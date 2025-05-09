module uk.autores.integration.gradlem.test {
    requires uk.autores.integration.gradlem;

    requires org.junit.jupiter.api;

    opens uk.autores.integration.gradlem.test  to org.junit.platform.commons;
}
