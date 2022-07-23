import dependencies.Dependencies
import dependencies.AnnotationProcessing
import dependencies.Java

plugins {
    id(Plugins.library)
    id(Plugins.kotlin)
    id(Plugins.kapt)
    id(Plugins.dagger)
}

android {
    compileSdk = Versions.compileSDK

    defaultConfig {
        minSdk = Versions.minsdk
        targetSdk = Versions.targetsdk

        testInstrumentationRunner = Test.testInstrumentals
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_16
        targetCompatibility = JavaVersion.VERSION_16
    }
    kotlinOptions {
        jvmTarget = Java.java_versions
    }
}

dependencies {
    //dagger-hilt
    implementation(Dependencies.hilt_android)
    kapt(AnnotationProcessing.dagger_hilt_kapt)

    //retrofit
    implementation(Dependencies.retrofit)
    implementation(Dependencies.converter_gson)
    implementation(Dependencies.okhttp)
    implementation(Dependencies.okhttp_login_interceptor)

    //coroutines
    implementation(Dependencies.coroutines)
    implementation(Dependencies.lifecycle_runtime)

    //modules
    implementation(project(Modules.domain))

    //tests
    testImplementation(Test.unit_junit)
}