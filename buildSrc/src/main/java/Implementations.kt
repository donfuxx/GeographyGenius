import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.implementations() {
    implementation(Deps.coreKtx)
    implementation(Deps.appCompat)
    implementation(Deps.constraintLayout)
    implementation(Deps.lifecycleExtenstions)
    implementation(Deps.lifecycleViewModel)
    implementation(Deps.koinAndroid)
    implementation(Deps.koinCore)
    implementation(Deps.koinViewModel)
}

fun DependencyHandler.implementation(dependency: String) = add("implementation", dependency)