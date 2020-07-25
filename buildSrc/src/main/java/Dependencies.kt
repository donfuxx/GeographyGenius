object Modules {
    const val domain = ":domain"
    const val network = ":network"
    const val android = ":common:android"
    const val testUtils = ":common:testutils"
    const val home = ":features:home"
    const val game = ":features:game"
}

object Versions {
    const val appCompat = "1.1.0"
    const val constraintLayout = "1.1.3"
    const val coroutinesTest = "1.3.7"
    const val coreKtx = "1.3.0"
    const val googleMaps = "17.0.0"
    const val espressoCore = "3.2.0"
    const val gradle = "4.0.0"
    const val gradleVersionsPlugin = "0.28.0"
    const val junit5GradlePlugin = "1.3.2.0"
    const val junit5 = "5.6.2"
    const val junitExt = "1.1.1"
    const val koin = "2.1.6"
    const val koTest = "4.1.2"
    const val kotlin = "1.3.72"
    const val lifecycle = "2.2.0"
    const val lifecycleExtensions = "1.1.1"
    const val mockk = "1.10.0"
    const val materialDesign = "1.1.0"
    const val okhttp = "4.7.2"
    const val retrofit = "2.9.0"
    const val shimmer = "0.5.0"
}

object Deps {
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val googleMaps = "com.google.android.gms:play-services-maps:${Versions.googleMaps}"
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val gradleVersionsPlugin = "com.github.ben-manes:gradle-versions-plugin:${Versions.gradleVersionsPlugin}"
    const val lifecycleExtenstions = "android.arch.lifecycle:extensions:${Versions.lifecycleExtensions}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    const val koinCore = "org.koin:koin-core:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val okhttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val shimmer = "com.facebook.shimmer:shimmer:${Versions.shimmer}"
}

object TestDeps {
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTest}"
    const val junit5GradlePlugin = "de.mannodermaus.gradle.plugins:android-junit5:${Versions.junit5GradlePlugin}"
    const val jUnit5 = "org.junit.jupiter:junit-jupiter-api:${Versions.junit5}"
    const val koTest = "io.kotest:kotest-runner-junit5-jvm:${Versions.koTest}"
    const val koTestAssertions = "io.kotest:kotest-assertions-core-jvm:${Versions.koTest}"
    const val koTestProperty = "io.kotest:kotest-property-jvm:${Versions.koTest}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val lifecycleCoreTesting = "android.arch.core:core-testing:${Versions.lifecycleExtensions}"
}

object TestRuntimeOnly {
    const val jUnit5 = "org.junit.jupiter:junit-jupiter-engine:${Versions.junit5}"
}

object AndroidTestDeps {
    const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}

object DefaultConfig {
    const val minSdk = 21
    const val targetSdk = 29
    const val compileSdk = 29
    const val appId = "com.appham.geographygenius"
}

object Releases {
    val versionCode = 1
    val versionName = "1.0"
}