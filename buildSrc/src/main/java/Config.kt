/*
 * App configuration
 */
object Config {
    const val APPLICATION_ID = "com.ozan.modularapp"
    const val MIN_SDK_VERSION = Versions.MIN_SDK_VERSION
    const val TARGET_SDK_VERSION = Versions.TARGET_SDK_VERSION
    const val COMPILE_SDK_VERSION = Versions.COMPILE_SDK_VERSION
    const val TEST_INSTRUMENTATION_RUNNER = "android.support.test.runner.AndroidJUnitRunner"
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0.0"
    const val BASE_URL = "https://api.rawg.io/api/"
    const val API_KEY = "4dfe2a4b8bb644f1bc2033ffedb35d61"
}

/*
 * Auto generated buildConfig fields
 */
object Fields {
    const val ROOT_URL = "ROOT_URL"
    const val PACKAGE_NAME = "PACKAGE_NAME"
    const val BASE_URL = "BASE_URL"
    const val API_KEY = "API_KEY"
}

/*
 * Flavor Dimensions
 */
object Dimensions {
    const val DEFAULT = "default"
}

/*
 * Product Flavors
 */
object Prod {
    const val VERSION_CODE = Config.VERSION_CODE
    const val VERSION_NAME = Config.VERSION_NAME
    const val PACKAGE_NAME = Config.APPLICATION_ID
    const val BASE_URL = Config.BASE_URL
    const val API_KEY = Config.API_KEY
}

object Dev {
    private const val SUFFIX = ".dev"
    const val VERSION_CODE = Config.VERSION_CODE * 10000
    const val VERSION_NAME = Config.VERSION_NAME
    const val VERSION_NAME_SUFFIX = SUFFIX
    private const val APPLICATION_ID_SUFFIX = SUFFIX
    const val PACKAGE_NAME = Config.APPLICATION_ID + APPLICATION_ID_SUFFIX
    const val BASE_URL = Config.BASE_URL
    const val API_KEY = Config.API_KEY
}