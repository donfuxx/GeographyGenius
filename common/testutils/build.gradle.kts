plugins {
    id("com.android.library")
    id("kotlin-android")
}

apply {
    from("$rootDir/common-android.gradle")
}

android {

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(TestDeps.lifecycleCoreTesting)
    implementation(TestDeps.jUnit5)
}
