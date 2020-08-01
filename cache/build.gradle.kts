
plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
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
    implementation(project(Modules.android))
    implementation(project(Modules.domain))
    implementations()
    cacheImplementations()
    kapt(Kapt.roomAnnotations)

    testImplementation(project(Modules.testUtils))
    testImplementations()

    androidTestImplementation(AndroidTestDeps.junitExt)
    androidTestImplementation(AndroidTestDeps.espressoCore)
}
