/*
 * This file was generated by the Gradle 'init' task.
 *
 * The settings file is used to specify which projects to include in your build.
 * For more detailed information on multi-project builds, please refer to https://docs.gradle.org/8.7/userguide/multi_project_builds.html in the Gradle documentation.
 * This project uses @Incubating APIs which are subject to change.
 */
pluginManagement {
	repositories {
		mavenCentral()
		gradlePluginPortal()
		maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
	}
}

plugins {
	id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "graphs-graphs-12"
include("graphs-lab")