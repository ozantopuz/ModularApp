package com.ozan.game.presentation

import com.ozan.core.presentation.recyclerview.*
import com.ozan.game.presentation.GamePresentationConstants.TYPES.GAME
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntKey
import dagger.multibindings.IntoMap

@Module
abstract class GamePresentationModule {

    @Binds
    @IntoMap
    @IntKey(GAME)
    internal abstract fun bindGameViewHolderFactory(viewHolderFactory: GameViewHolder.GameViewHolderFactory): ViewHolderFactory

    @Binds
    @IntoMap
    @IntKey(GAME)
    internal abstract fun bindGameViewHolderBinder(viewHolderBinder: GameViewHolder.GameViewHolderBinder): ViewHolderBinder

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun provideDisplayItemComparator(): DisplayItemComparator = DefaultDisplayItemComparator()

        @JvmStatic
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