package com.ozan.game.data

import com.ozan.core.data.api.ApiConstants
import com.ozan.core.data.api.PagedApiResponse
import com.ozan.game.domain.Game
import com.ozan.game.domain.GameDetail
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GameServices {

    @GET("games")
    fun fetchGames(
        @Query("page") page: Int? = ApiConstants.PAGE,
        @Query("page_size") pageSize: Int? = ApiConstants.PAGE_SIZE
    ): Single<PagedApiResponse<List<Game>>>

    @GET("games/{id}")
    fun fetchGameDetail(
        @Path("id") id: Int?
    ): Single<GameDetail>
}