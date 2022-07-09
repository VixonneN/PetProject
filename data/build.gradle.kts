import dependencies.Dependencies
import dependencies.AnnotationProcessing

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
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

    implementation(project(Modules.domain))

    testImplementation("junit:junit:4.13.2")
}