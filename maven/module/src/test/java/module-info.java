module maven.java8.module.test {
    requires maven.java8.module;
    requires org.junit.jupiter.api;
    requires org.junit.jupiter.engine;
    opens uk.autores.integration.mavencp.test to org.junit.platform.commons;
}
