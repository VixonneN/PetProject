pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

rootProject.name = "My Application"
include(":app")
include(":data")
include(":domain")