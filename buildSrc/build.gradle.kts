plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

allprojects{
    java{
        toolchain {
            languageVersion = JavaLanguageVersion.of(21)
            vendor = JvmVendorSpec.ADOPTIUM
        }
    }
}

