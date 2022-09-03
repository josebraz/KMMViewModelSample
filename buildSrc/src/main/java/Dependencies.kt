
/**
 * To define plugins
 */
object BuildPlugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
}

/**
 * To define dependencies
 */
object Deps {
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.androidxAppCompat}" }
    val core by lazy { "androidx.core:core-ktx:${Versions.androidxCore}" }
    val lifecycleViewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidxLifecycle}" }
    val materialDesign by lazy { "com.google.android.material:material:${Versions.material}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.androidxConstraintLayout}" }
    val coroutineCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinxCoroutine}" }
    val coroutineTest by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinxCoroutine}" }
    val datetime by lazy { "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.kotlinxDatetime}" }

    val composeUi by lazy { "androidx.compose.ui:ui:${Versions.composeUi}" }
    val composeMaterial by lazy { "androidx.compose.material:material:${Versions.composeMaterial}" }
    val composeUiPreview by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.composeUiPreview}" }
    val lifecycleRuntime by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.androidxLifecycleRuntime}" }
    val composeActivity by lazy { "androidx.activity:activity-compose:${Versions.androidxComposeActivity}" }

    val composeUiTestJunit by lazy { "androidx.compose.ui:ui-test-junit4:${Versions.composeUiTestJunit}" }
    val composeUiTooling by lazy { "androidx.compose.ui:ui-tooling:${Versions.composeUiTooling}" }
    val composeUiTestManifest by lazy { "androidx.compose.ui:ui-test-manifest:${Versions.composeUiTestManifest}" }
}