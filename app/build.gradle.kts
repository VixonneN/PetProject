import dependencies.Application
import dependencies.Dependencies
import dependencies.Java
import dependencies.AnnotationProcessing

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Versions.compileSDK

    defaultConfig {
        applicationId = Application.id
        minSdk = Versions.minsdk
        targetSdk = Versions.targetsdk
        versionCode = Application.version_code
        versionName = Application.version_name

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        viewBinding.isEnabled = true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
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
}

dependencies {

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
    implementation(Dependencies.okhttp_login_interceptor)

    //coroutines
    implementation(Dependencies.coroutines)
    implementation(Dependencies.lifecycle_runtime)

    implementation(Dependencies.android_core_ktx)
    implementation(Dependencies.android_appcompat)
    implementation(Dependencies.material)
    implementation(Dependencies.fragment_ktx)

    implementation(project(Modules.data))
    implementation(project(Modules.domain))

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}