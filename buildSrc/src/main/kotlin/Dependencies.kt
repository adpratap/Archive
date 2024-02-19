import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Dependencies {

    const val coreKtx = "androidx.core:core-ktx:1.12.0"
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.7.0"


    //Core Test
    const val testImplementationJunit = "junit:junit:${Versions.testImplementationJunit}"
    const val androidTestImplementationJunit = "androidx.test.ext:junit:1.1.5${Versions.androidTestImplementationJunit}"
    const val androidTestImplementationEspresso = "androidx.test.espresso:espresso-core:${Versions.androidTestImplementationEspresso}"

    //Compose
    const val composeBom = "androidx.compose:compose-bom:${Versions.composeBom}"
    const val composeMaterial = "androidx.compose.material3:material3:${Versions.composeMaterial3}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics:${Versions.compose}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val composeRuntime = "androidx.compose.runtime:runtime:${Versions.compose}"
    const val androidTestImplementationUiTestJunit4 = "androidx.compose.ui:ui-test-junit4"
    const val debugImplementationUiTooling = "androidx.compose.ui:ui-tooling"
    const val debugImplementationUiTestManifest = "androidx.compose.ui:ui-test-manifest"

    //Dagger-Hilt
    const val hiltCore = "com.google.dagger:hilt-core:${Versions.hilt}"
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltWork = "androidx.hilt:hilt-work:${Versions.hiltWork}"
    const val hiltAgp = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"

    //Retrofit
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLoggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    //Room
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    //LifeCycle
    const val liveDataLifecycle = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifeCycle}"
    const val viewModelLifecycle = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycle}"

    //Coroutines
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

}

fun DependencyHandler.room() {
    implementation(Dependencies.roomRuntime)
    implementation(Dependencies.roomKtx)
    kapt(Dependencies.roomCompiler)
}

fun DependencyHandler.liveDataViewModel() {
    implementation(Dependencies.liveDataLifecycle)
    implementation(Dependencies.viewModelLifecycle)
}

fun DependencyHandler.coroutines() {
    implementation(Dependencies.coroutinesCore)
    implementation(Dependencies.coroutinesAndroid)
}

fun DependencyHandler.retrofit() {
    implementation(Dependencies.retrofit)
    implementation(Dependencies.moshiConverter)
    implementation(Dependencies.okHttp)
    implementation(Dependencies.okHttpLoggingInterceptor)
    implementation(Dependencies.gsonConverter)
}

fun DependencyHandler.compose() {
    implementation(platform(Dependencies.composeBom))
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeRuntime)
    implementation(Dependencies.composeUiGraphics)
    implementation(Dependencies.composeUiTooling)
    implementation(Dependencies.composeMaterial)
    androidTest(platform(Dependencies.composeBom))

    androidTest(Dependencies.androidTestImplementationUiTestJunit4)
    debugImplementation(Dependencies.composeUiToolingPreview)

    debugImplementation(Dependencies.debugImplementationUiTooling)
    debugImplementation(Dependencies.debugImplementationUiTestManifest)
}

fun DependencyHandler.hilt() {
    implementation(Dependencies.hiltAndroid)
    implementation(Dependencies.hiltWork)
    kapt(Dependencies.hiltCompiler)
}

fun DependencyHandler.hiltCore() {
    implementation(Dependencies.hiltCore)
    kapt(Dependencies.hiltCompiler)
}

fun DependencyHandler.data() {
    implementation(project(":data"))
}

fun DependencyHandler.domain() {
    implementation(project(":domain"))
}

fun DependencyHandler.coreTest() {
    test(Dependencies.testImplementationJunit)
    androidTest(Dependencies.androidTestImplementationEspresso)
    androidTest(Dependencies.androidTestImplementationJunit)
}

fun DependencyHandler.dependenciesForDomain() {
    implementation(Dependencies.coroutinesCore)
    implementation(Dependencies.retrofit)
    hiltCore()
}


