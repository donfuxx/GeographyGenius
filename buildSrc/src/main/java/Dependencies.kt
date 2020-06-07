object Modules {
    val home = ":features:home"
}

object Versions {
    const val appCompat = "1.1.0"
    const val constraintLayout = "1.1.3"
    const val coreKtx = "1.3.0"
    const val espressoCore = "3.2.0"
    const val gradle = "4.0.0"
    const val gradleVersionsPlugin = "0.28.0"
    const val junit = "4.12"
    const val junitExt = "1.1.1"
    const val kotlin = "1.3.72"
}

object Deps {
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
}

object TestDeps {
    const val jUnit = "junit:junit:${Versions.junit}"
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