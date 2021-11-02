/*
 * Support Libraries
 */
object SupportLibraries {
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX_VERSION}"
    const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT_VERSION}"
    const val CONSTRAINT_LAYOUT =
        "com.android.support.constraint:constraint-layout:${Versions.CONSTRAINT_LAYOUT_VERSION}"
    const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:${Versions.X_VERSION}"
    const val MATERIAL_DESIGN = "com.google.android.material:material:${Versions.X_VERSION}"
    const val LIVE_DATA_KTX =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE_VERSION}"
    const val VIEW_MODEL_KTX =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_VERSION}"
    const val RUNTIME_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_VERSION}"
    const val LIFECYCLE_COMMON =
        "androidx.lifecycle:lifecycle-common-java8:${Versions.LIFECYCLE_VERSION}"
}

/*
 * Test Libraries
 */
object TestLibraries {
    const val J_UNIT = "junit:junit:${Versions.J_UNIT_VERSION}"
    const val ANDROID_TEST_IMPLEMENTATION =
        "androidx.test.ext:junit:${Versions.TEST_IMPLEMENTATION_VERSION}"
    const val ESPRESSO_CORE =
        "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE_VERSION}"
    const val COROUTINES_TEST =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.KOTLIN_COROUTINES_TEST_VERSION}"
    const val MOCKK = "io.mockk:mockk:${Versions.MOCKK_VERSION}"
    const val TRUTH = "androidx.test.ext:truth:${Versions.TRUTH_VERSION}"
    const val ARCH_CORE = "androidx.arch.core:core-testing:${Versions.ARCH_CORE_VERSION}"
}

/*
 * Common Libraries
 */
object Libraries {
    const val DAGGER_HILT = "com.google.dagger:hilt-android:${Versions.DAGGER_HILT_VERSION}"
    const val DAGGER_HILT_COMPILER =
        "com.google.dagger:hilt-android-compiler:${Versions.DAGGER_HILT_VERSION}"
    const val JAVAX_ANNOTATION =
        "org.glassfish:javax.annotation:${Versions.JAVAX_ANNOTATION_VERSION}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT_VERSION}"
    const val OKHTTP_LOGGING_INTERCEPTOR =
        "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP_LOGGING_INTERCEPTOR_VERSION}"
    const val GSON = "com.squareup.retrofit2:converter-gson:${Versions.GSON_VERSION}"
    const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP_VERSION}"
    const val VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel:${Versions.VIEW_MODEL_VERSION}"
    const val LIFECYCLE_EXTENSIONS =
        "androidx.lifecycle:lifecycle-extensions:${Versions.VIEW_MODEL_VERSION}"
    const val COROUTINES_CORE =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES_VERSION}"
    const val COROUTINES_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES_VERSION}"
    const val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
}
