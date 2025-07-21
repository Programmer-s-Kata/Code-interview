package config

import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.plugins.quality.Pmd
import org.gradle.api.plugins.quality.PmdExtension
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType

fun Project.configurePmd() {
    plugins.apply("pmd")

    extensions.configure<PmdExtension>() {

        toolVersion = Analysis.Pmd.ver
        incrementalAnalysis.set(true)
        ruleSets = emptyList()
        ruleSetFiles = files("${rootDir}/buildSrc/src/main/resources/pmd.xml")
        isIgnoreFailures = false

        val mainSourceSet = project.extensions.getByType(JavaPluginExtension::class.java)
            .sourceSets
            .getByName("main")
        sourceSets = listOf(mainSourceSet)

        tasks.withType<Pmd> {
            exclude(
                "**/build/**",
                "**/generated/**",
                "**/test/**"
            )
            mustRunAfter(tasks.withType<Test>())

            reports {
                xml.required.set(false)
                html.required.set(true)
            }
        }
    }
}