/*
 * App Modules
 */
object Modules {

    private const val BASE_DIRECTORY = ":base"
    private const val GAME_DIRECTORY = ":game"

    /*
     * App
     */
    const val APP = ":app"

    /*
     * Base
     */
    const val CORE = "$BASE_DIRECTORY:core"
    const val CORE_PRESENTATION = "$BASE_DIRECTORY:core_presentation"
    const val CORE_DOMAIN = "$BASE_DIRECTORY:core_domain"
    const val CORE_DATA = "$BASE_DIRECTORY:core_data"
    const val CORE_NAVIGATION = "$BASE_DIRECTORY:core_navigation"

    /*
     * Game
     */
     const val GAME_DATA = "$GAME_DIRECTORY:game_data"
     const val GAME_DOMAIN = "$GAME_DIRECTORY:game_domain"
     const val GAME_PRESENTATION = "$GAME_DIRECTORY:game_presentation"
}