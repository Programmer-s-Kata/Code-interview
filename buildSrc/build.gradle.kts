plugins {
    `kotlin-dsl`
}

val kotlinVersion = project.properties["kotlinVersion"] ?: "1.9.22"

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation(gradleApi())
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
}