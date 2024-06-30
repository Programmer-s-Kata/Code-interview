import gradle.kotlin.dsl.accessors._b5258395f318e256771440d90b569284.pmd
import gradle.kotlin.dsl.accessors._b5258395f318e256771440d90b569284.reporting
import gradle.kotlin.dsl.accessors._b5258395f318e256771440d90b569284.sourceSets
import org.gradle.kotlin.dsl.java
import org.gradle.kotlin.dsl.pmd

plugins {
    java
    pmd
}

pmd {
    toolVersion = Pmd.ver
    isConsoleOutput = true
    isIgnoreFailures = false
    incrementalAnalysis.set(true)

    sourceSets = listOf(project.sourceSets.named("main").get())
    ruleSetFiles = files("${rootDir}/buildSrc/src/main/resources/pmd.xml")
    reportsDir = file("build/reports/pmd")
}