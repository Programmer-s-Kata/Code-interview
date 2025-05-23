import config.configureJava
import config.configurePmd
import config.configureTesting

plugins {
    `java-library`
    idea
}
allprojects {
    repositories {
        mavenCentral()
    }
    configureJava()
    configureTesting()
    configurePmd()
}