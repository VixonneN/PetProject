object Plugins {
    //android
    const val dagger_plugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    const val android_application = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlin_version = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    //app
    const val application = "com.android.application"
    const val library = "com.android.library"
    const val kotlin = "org.jetbrains.kotlin.android"
    const val kapt = "kotlin-kapt"
    const val dagger = "dagger.hilt.android.plugin"
}