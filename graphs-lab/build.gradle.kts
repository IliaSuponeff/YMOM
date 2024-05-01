plugins {
    kotlin("jvm") version "1.9.20"
    `java-library`
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.23.3")
}

detekt {
    config.setFrom("../scripts/detekt-config.yml")
}

