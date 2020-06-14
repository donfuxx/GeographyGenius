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

    implementations()

    testImplementation(TestDeps.jUnit5)
    testRuntimeOnly(TestRuntimeOnly.jUnit5)

    androidTestImplementation(AndroidTestDeps.junitExt)
    androidTestImplementation(AndroidTestDeps.espressoCore)
}
