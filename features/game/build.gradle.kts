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

        getByName("debug") {
            isMinifyEnabled = false

            manifestPlaceholders = mapOf(Secrets.GOOGLE_MAPS_DEBUG_KEY to Secrets.googleMapsDebugKey)
        }
    }
}

dependencies {
    implementation(project(Modules.domain))
    implementations()
    mapImplementations()

    testImplementations()

    androidTestImplementation(AndroidTestDeps.junitExt)
    androidTestImplementation(AndroidTestDeps.espressoCore)
}
