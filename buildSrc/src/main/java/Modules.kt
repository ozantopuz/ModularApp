/*
 * App Modules
 */
object Modules {

    private const val BASE_DIRECTORY = ":base"
    private const val GAME_DIRECTORY = ":game"

    /*
     * App
     */
    const val app = ":app"

    /*
     * Base
     */
    const val core = "$BASE_DIRECTORY:core"
    const val corePresentation = "$BASE_DIRECTORY:core_presentation"
    const val coreDomain = "$BASE_DIRECTORY:core_domain"
    const val coreData = "$BASE_DIRECTORY:core_data"
    const val coreNavigation = "$BASE_DIRECTORY:core_navigation"

    /*
     * Game
     */
     const val gameData = "$GAME_DIRECTORY:game_data"
     const val gameDomain = "$GAME_DIRECTORY:game_domain"
     const val gamePresentation = "$GAME_DIRECTORY:game_presentation"
}