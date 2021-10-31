package com.ozan.core.di

import com.ozan.core.error.DefaultErrorFactory
import com.ozan.core.error.ErrorFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CoreModule {

    @Provides
    @Singleton
    internal fun provideErrorFactory(): ErrorFactory = DefaultErrorFactory()

}