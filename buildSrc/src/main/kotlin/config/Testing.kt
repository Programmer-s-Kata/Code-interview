package config

import deps.JUnit
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.*

fun Project.configureTesting() {

    dependencies {
        dependencies.add("testImplementation", platform(JUnit.bom))
        dependencies.add("testImplementation", JUnit.api)
        dependencies.add("testRuntimeOnly", JUnit.engine)
        dependencies.add("testImplementation", JUnit.params)
    }

    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
        testLogging {
            showExceptions = true
            exceptionFormat = TestExceptionFormat.FULL
            showCauses = true
            showStackTraces = true
            showStandardStreams = true
            events = setOf(
                TestLogEvent.PASSED,
                TestLogEvent.SKIPPED,
                TestLogEvent.FAILED,
                TestLogEvent.STANDARD_ERROR,
                TestLogEvent.STANDARD_OUT,
            )
        }
    }
}