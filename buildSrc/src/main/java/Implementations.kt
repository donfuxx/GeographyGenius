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
    implementation(Deps.materialDesign)
}

fun DependencyHandler.testImplementations() {
    testImplementation(TestDeps.jUnit5)
    testRuntimeOnly(TestRuntimeOnly.jUnit5)
    testImplementation(TestDeps.mockk)
    testImplementation(TestDeps.livecycleCoreTesting)
}

fun DependencyHandler.networkImplementations() {
    implementation(Deps.okhttpLoggingInterceptor)
    implementation(Deps.retrofit)
    implementation(Deps.retrofitMoshi)
    implementation(Deps.retrofitCoroutines)
}

private fun DependencyHandler.implementation(dependency: String) = add("implementation", dependency)
private fun DependencyHandler.testImplementation(dependency: String) = add("testImplementation", dependency)
private fun DependencyHandler.testRuntimeOnly(dependency: String) = add("testRuntimeOnly", dependency)