package config

import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.tasks.javadoc.Javadoc
import org.gradle.external.javadoc.StandardJavadocDocletOptions
import org.gradle.kotlin.dsl.withType

fun Project.configureJavadoc() {
    plugins.withType<JavaPlugin>().configureEach {
        configureJavadocTasks()
    }
}

private fun Project.configureJavadocTasks() {
    tasks.withType<Javadoc>().configureEach {
        configureJavadocOptions()
    }
}

private fun Javadoc.configureJavadocOptions() {
    (options as? StandardJavadocDocletOptions)?.apply {
        configureCustomTags()
        configureHtml5Output()
        configureDoclintChecks()
    }
}

private fun StandardJavadocDocletOptions.configureCustomTags() {
    tags = listOf(
        "apiNote:a:API Note:",
        "implNote:a:Implementation Note:",
        "implSpec:a:Implementation Requirements:"
    )
}

private fun StandardJavadocDocletOptions.configureHtml5Output() {
    addBooleanOption("html5", true)
}

private fun StandardJavadocDocletOptions.configureDoclintChecks() {
    addBooleanOption("Xdoclint:all,-missing", true)
    addStringOption("Xmaxwarns", "1000")
}