buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Plugins.android_application)
        classpath(Plugins.kotlin_version)

        classpath(Plugins.dagger_plugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}