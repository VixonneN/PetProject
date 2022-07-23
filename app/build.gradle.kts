import dependencies.Application
import dependencies.Dependencies
import dependencies.Java
import dependencies.AnnotationProcessing

plugins {
    id(Plugins.application)
    id(Plugins.kotlin)
    id(Plugins.kapt)
    id(Plugins.dagger)
}

android {
    compileSdk = Versions.compileSDK

    defaultConfig {
        applicationId = Application.id
        minSdk = Versions.minsdk
        targetSdk = Versions.targetsdk
        versionCode = Application.version_code
        versionName = Application.version_name

        testInstrumentationRunner = Test.testInstrumentals
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    file("proguard-rules.pro")
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_16
        targetCompatibility = JavaVersion.VERSION_16
    }

    kotlinOptions {
        jvmTarget = Java.java_versions
    }

    packagingOptions {
        resources {
            resources.excludes.add("META-INF/AL2.0")
            resources.excludes.add("META-INF/LGPL2.1")
        }
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    //images
    implementation(Dependencies.coil)

    //room
    implementation(Dependencies.room_runtime)
    kapt(AnnotationProcessing.room_compiler)
    implementation(Dependencies.room_ktx)

    //dagger-hilt
    implementation(Dependencies.hilt_android)
    kapt(AnnotationProcessing.dagger_hilt_kapt)
    implementation(Dependencies.nav_compose)

    //retrofit
    implementation(Dependencies.retrofit)
    implementation(Dependencies.converter_gson)
    implementation(Dependencies.okhttp)
    debugImplementation(Dependencies.okhttp_login_interceptor)

    //coroutines
    implementation(Dependencies.coroutines)
    implementation(Dependencies.lifecycle_runtime)

    //android
    implementation(Dependencies.android_core_ktx)
    implementation(Dependencies.android_appcompat)
    implementation(Dependencies.material)
    implementation(Dependencies.fragment_ktx)

    //modules
    implementation(project(Modules.data))
    implementation(project(Modules.domain))

    //tests
    testImplementation(Test.unit_junit)
    androidTestImplementation(Test.android_junit)
    androidTestImplementation(Test.android_espresso)
}