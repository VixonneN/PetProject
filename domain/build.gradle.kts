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

    //dagger
    implementation(Dependencies.hilt_android)
    kapt(AnnotationProcessing.dagger_hilt_kapt)

    //coroutines
    implementation(Dependencies.coroutines)

    //tests
    testImplementation(Test.unit_junit)
}