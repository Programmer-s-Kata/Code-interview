import dependency.JUnit

plugins {
    `java-library`
}
repositories {
    mavenCentral()
}

dependencies {
    testImplementation(JUnit.engine)
    testImplementation(platform(JUnit.bom))
    JUnit.api.forEach{
        testImplementation(it)
    }

}

tasks.test {
    useJUnitPlatform()
}

