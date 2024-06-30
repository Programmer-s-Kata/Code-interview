plugins {
    `java-library`
    idea
}

subprojects {
    apply<CodeQualityPlugin>()
}