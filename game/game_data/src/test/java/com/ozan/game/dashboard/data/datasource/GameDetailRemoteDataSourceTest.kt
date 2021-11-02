package com.ozan.game.dashboard.data.datasource

import com.google.common.truth.Truth
import com.ozan.core.constant.Constants
import com.ozan.core.model.DataHolder
import com.ozan.core.rule.CoroutinesTestRule
import com.ozan.core.entity.GameDetailFactory
import com.ozan.game.data.GameDetailRemoteDataSource
import com.ozan.game.data.GameService
import com.ozan.game.domain.GameDetail
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class GameDetailRemoteDataSourceTest {

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @MockK
    lateinit var gameService: GameService

    private lateinit var gameDetailRemoteDataSource: GameDetailRemoteDataSource

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        gameDetailRemoteDataSource = GameDetailRemoteDataSource(gameService)
    }

    @After
    fun tearDown() {
        unmockkAll()
        clearAllMocks()
    }

    @Test
    fun test_fetchGameDetail_returns_the_expected_data() {
        coroutinesTestRule.testDispatcher.runBlockingTest {
            // Given
            coEvery {
                gameService.fetchGameDetail(Constants.ID)
            }.coAnswers {
                GameDetailFactory.getGameDetail()
            }

            // When
            val result: DataHolder<GameDetail> = gameDetailRemoteDataSource.getResult(Constants.ID)

            // Then
            Truth.assertThat(result).isNotNull()
            Truth.assertThat(result)
                .isInstanceOf(DataHolder.Success(GameDetailFactory.getGameDetail()).javaClass)

            coVerify(exactly = 1) { gameService.fetchGameDetail(Constants.ID) }
            confirmVerified(gameService)
        }
    }
}