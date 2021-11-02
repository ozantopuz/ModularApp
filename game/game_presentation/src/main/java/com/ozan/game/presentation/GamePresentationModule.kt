package com.ozan.game.presentation

import com.ozan.core.mapper.Mapper
import com.ozan.core.presentation.recyclerview.*
import com.ozan.game.domain.Game
import com.ozan.game.domain.GameDetail
import com.ozan.game.presentation.GamePresentationConstants.TYPES.GAME
import com.ozan.game.presentation.gamedetail.GameDetailViewEntityMapper
import com.ozan.game.presentation.games.GameViewEntityMapper
import com.ozan.game.presentation.games.GameViewHolder
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntKey
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
abstract class GamePresentationModule {

    @Binds
    @IntoMap
    @IntKey(GAME)
    internal abstract fun bindGameViewHolderFactory(viewHolderFactory: GameViewHolder.GameViewHolderFactory): ViewHolderFactory

    @Binds
    @IntoMap
    @IntKey(GAME)
    internal abstract fun bindGameViewHolderBinder(viewHolderBinder: GameViewHolder.GameViewHolderBinder): ViewHolderBinder

    companion object {

        @Provides
        fun provideGameViewEntityMapper(): GameViewEntityMapper = GameViewEntityMapper()

        @Provides
        fun provideGameDetailViewEntityMapper(): GameDetailViewEntityMapper = GameDetailViewEntityMapper()

        @Provides
        fun provideDisplayItemComparator(): DisplayItemComparator = DefaultDisplayItemComparator()

        @Provides
        fun provideRecyclerAdapter(
            itemComparator: DisplayItemComparator,
            factoryMap: Map<Int, @JvmSuppressWildcards ViewHolderFactory>,
            binderMap: Map<Int, @JvmSuppressWildcards ViewHolderBinder>
        ): RecyclerViewAdapter {
            return RecyclerViewAdapter(
                itemComparator = itemComparator,
                viewHolderFactoryMap = factoryMap,
                viewBinderFactoryMap = binderMap
            )
        }
    }
}