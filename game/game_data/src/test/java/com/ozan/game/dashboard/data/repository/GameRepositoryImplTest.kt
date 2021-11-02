package com.ozan.game.dashboard.data.repository

import com.google.common.truth.Truth
import com.ozan.core.constant.Constants
import com.ozan.core.entity.GameDetailFactory
import com.ozan.core.entity.GamesResponseFactory
import com.ozan.core.entity.PagedApiResponseFactory
import com.ozan.core.model.DataHolder
import com.ozan.core.rule.CoroutinesTestRule
import com.ozan.game.data.GameDetailRemoteDataSource
import com.ozan.game.data.GameRepositoryImpl
import com.ozan.game.data.GamesRemoteDataSource
import com.ozan.game.domain.GameDetail
import com.ozan.game.domain.GameRepository
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
class GameRepositoryImplTest {

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @MockK
    lateinit var gamesRemoteDataSource: GamesRemoteDataSource

    @MockK
    lateinit var gameDetailRemoteDataSource: GameDetailRemoteDataSource

    private lateinit var gameRepository: GameRepository


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        gameRepository = GameRepositoryImpl(gamesRemoteDataSource, gameDetailRemoteDataSource)
    }

    @After
    fun tearDown() {
        unmockkAll()
        clearAllMocks()
    }

    @Test
    fun test_fetchGames_returns_success() {
        coroutinesTestRule.testDispatcher.runBlockingTest {
            // Given
            coEvery {
                gamesRemoteDataSource.getResult(Constants.PAGE)
            }.coAnswers {
                DataHolder.Success(GamesResponseFactory.getGamesResponse())
            }

            // When
            val result: DataHolder<GamesResponse> = gameRepository.fetchGames(Constants.PAGE)

            // Then
            Truth.assertThat(result).isNotNull()
            Truth.assertThat(result)
                .isInstanceOf(DataHolder.Success(GamesResponseFactory.getGamesResponse()).javaClass)

            coVerify(exactly = 1) { gameRepository.fetchGames(Constants.PAGE) }
        }
    }

    @Test
    fun test_fetchGameDetail_returns_success() {
        coroutinesTestRule.testDispatcher.runBlockingTest {
            // Given
            coEvery {
                gameDetailRemoteDataSource.getResult(Constants.ID)
            }.coAnswers {
                DataHolder.Success(GameDetailFactory.getGameDetail())
            }

            // When
            val result: DataHolder<GameDetail> = gameRepository.fetchGameDetail(Constants.ID)

            // Then
            Truth.assertThat(result).isNotNull()
            Truth.assertThat(result)
                .isInstanceOf(DataHolder.Success(GameDetailFactory.getGameDetail()).javaClass)

            coVerify(exactly = 1) { gameRepository.fetchGameDetail(Constants.ID) }
        }
    }
}