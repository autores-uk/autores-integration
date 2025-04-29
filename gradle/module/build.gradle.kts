plugins {
    id("java")
}

group = "uk.autores.integrate.module"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/") }
}

var libver = "8.0.42-beta"
if (System.getProperty("AUTORESVER") != null) {
    libver = System.getProperty("AUTORESVER")
}
var annotations = "uk.autores:annotations:" + libver
var processing = "uk.autores:processing:" + libver

dependencies {
    compileOnly(files("src/main/resources"))
    compileOnly(annotations)
    annotationProcessor(processing)
    testImplementation(annotations)
    testImplementation(platform("org.junit:junit-bom:5.11.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter-engine")
}

tasks.test {
    useJUnitPlatform()
}