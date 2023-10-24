plugins {
    `java-library`
}

group = "uk.autores.integration.gradle"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/") }
}

var libver = "8.0.9-alpha"
if (System.getProperty("AUTORESVER") != null) {
    libver = System.getProperty("AUTORESVER")
}
var autores = "uk.autores:annotations:" + libver

dependencies {
    compileOnly(files("src/main/resources"))
    compileOnly(autores)
    annotationProcessor(autores)
    testImplementation(autores)
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
