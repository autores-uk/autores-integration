plugins {
    `java-library`
}

group = "uk.autores.integration.gradle"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/") }
}

var libver = "8.0.21-beta"
if (System.getProperty("AUTORESVER") != null) {
    libver = System.getProperty("AUTORESVER")
}
var autores = "uk.autores:annotations:" + libver

dependencies {
    compileOnly(files("src/main/resources"))
    compileOnly(autores)
    annotationProcessor(autores)
    testImplementation(autores)
    testImplementation(platform("org.junit:junit-bom:5.10.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
