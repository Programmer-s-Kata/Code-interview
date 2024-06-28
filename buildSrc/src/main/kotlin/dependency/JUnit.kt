package dependency

object JUnit {
    private const val ver = "5.10.0"
    val api = listOf(
        "org.junit.jupiter:junit-jupiter-api",
        "org.junit.jupiter:junit-jupiter-params"
    )
    val engine = "org.junit.jupiter:junit-jupiter-engine"
    const val bom = "org.junit:junit-bom:${ver}"
}
