plugins {
    id("com.android.application")
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
    implementation(project(Modules.home))
    implementation(project(Modules.game))

    implementation(Deps.appCompat)
    implementation(Deps.constraintLayout)
    implementation(Deps.coreKtx)
    implementation(Deps.koinAndroid)
    implementation(Deps.koinCore)
    implementation(Deps.koinViewModel)

    testImplementation(TestDeps.jUnit)

    androidTestImplementation(AndroidTestDeps.junitExt)
    androidTestImplementation(AndroidTestDeps.espressoCore)
}
