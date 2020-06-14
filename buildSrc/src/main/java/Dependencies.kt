object Modules {
    val home = ":features:home"
    val game = ":features:game"
}

object Versions {
    const val appCompat = "1.1.0"
    const val constraintLayout = "1.1.3"
    const val coreKtx = "1.3.0"
    const val espressoCore = "3.2.0"
    const val gradle = "4.0.0"
    const val gradleVersionsPlugin = "0.28.0"
    const val junit5 = "5.6.2"
    const val junitExt = "1.1.1"
    const val koin = "2.1.6"
    const val kotlin = "1.3.72"
    const val lifecycle = "2.2.0"
}

object Deps {
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val gradleVersionsPlugin = "com.github.ben-manes:gradle-versions-plugin:${Versions.gradleVersionsPlugin}"
    const val lifecycleExtenstions = "android.arch.lifecycle:extensions:${Versions.lifecycle}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    const val koinCore = "org.koin:koin-core:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object TestDeps {
    const val jUnit5 = "org.junit.jupiter:junit-jupiter-api:${Versions.junit5}"
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