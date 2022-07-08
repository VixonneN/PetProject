package dependencies

object Dependencies {
    //compose
    const val compose_ui = "androidx.compose.ui:ui:${Versions.compose}"
    const val compose_material = "androidx.compose.material:material:${Versions.compose}"
    const val compose_preview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val compose_activity = "androidx.activity:activity-compose:${Versions.activity_compose}"
    const val compose_ui_tooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"

    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlin_coroutines}"
    const val fragment_ktx = "androidx.fragment:fragment-ktx:${Versions.fragment_ktx}"

    const val lifecycle_viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttp_login_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

    const val room_runtime = "androidx.room:room-runtime:${Versions.room}"
    const val room_ktx = "androidx.room:room-ktx:${Versions.room}"

    const val hilt_android = "com.google.dagger:hilt-android:${Versions.hilt}"

    const val nav_compose = "androidx.navigation:navigation-compose:${Versions.nav_version}"
    const val hilt_nav_compose = "androidx.hilt:hilt-navigation-compose:${Versions.compose_hilt_nav}"
    const val accompanist_nav_animation = "com.google.accompanist:accompanist-navigation-animation:${Versions.accompanist}"
    const val accompanist_swipe_refresher = "com.google.accompanist:accompanist-swiperefresh:${Versions.accompanist}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glide_compose = "com.github.skydoves:landscapist-glide:${Versions.glide_compose}"
    const val coil_compose = "io.coil-kt:coil-compose:${Versions.coil}"

    const val android_core_ktx = "androidx.core:core-ktx:${Versions.ktx}"
    const val android_appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"

}