package com.ozan.game.dashboard.data.datasource

import com.google.common.truth.Truth
import com.ozan.core.constant.Constants
import com.ozan.core.model.DataHolder
import com.ozan.core.rule.CoroutinesTestRule
import com.ozan.core.entity.GamesResponseFactory
import com.ozan.core.entity.PagedApiResponseFactory
import com.ozan.game.data.GameService
import com.ozan.game.data.GamesRemoteDataSource
import com.ozan.game.data.GamesResponseMapper
import com.ozan.game.domain.GamesResponse
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class GamesRemoteDataSourceTest {

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @MockK
    lateinit var gameService: GameService

    lateinit var gamesResponseMapper: GamesResponseMapper

    private lateinit var gamesRemoteDataSource: GamesRemoteDataSource

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        gamesResponseMapper = GamesResponseMapper()
        gamesRemoteDataSource = GamesRemoteDataSource(gameService, gamesResponseMapper)
    }

    @After
    fun tearDown() {
        unmockkAll()
        clearAllMocks()
    }

    @Test
    fun test_fetchGames_returns_the_expected_data() {
        coroutinesTestRule.testDispatcher.runBlockingTest {
            // Given
            coEvery {
                gameService.fetchGames(Constants.PAGE)
            }.coAnswers {
                PagedApiResponseFactory.getPagedApiResponse()
            }

            // When
            val result: DataHolder<GamesResponse> = gamesRemoteDataSource.getResult(Constants.PAGE)

            // Then
            Truth.assertThat(result).isNotNull()
            Truth.assertThat(result)
                .isInstanceOf(DataHolder.Success(GamesResponseFactory.getGamesResponse()).javaClass)

            coVerify(exactly = 1) { gameService.fetchGames(Constants.PAGE) }
            confirmVerified(gameService)
        }
    }
}