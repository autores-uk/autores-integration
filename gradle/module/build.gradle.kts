plugins {
    id("java")
}

group = "uk.autores.integrate.module"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/") }
}

var libver = "8.1.2"
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
    testImplementation("org.junit.jupiter:junit-jupiter:5.13.3")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}