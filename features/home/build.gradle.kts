plugins {
    id("com.android.library")
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
    implementation(Deps.coreKtx)
    implementation(Deps.appCompat)
    implementation(Deps.constraintLayout)

    testImplementation(TestDeps.jUnit)

    androidTestImplementation(AndroidTestDeps.junitExt)
    androidTestImplementation(AndroidTestDeps.espressoCore)
}
