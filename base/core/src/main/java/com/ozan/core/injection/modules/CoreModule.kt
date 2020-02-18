package com.ozan.core.injection.modules

import com.ozan.core.error.DefaultErrorFactory
import com.ozan.core.error.ErrorFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoreModule {

    @Provides
    @Singleton
    internal fun provideErrorFactory(): ErrorFactory = DefaultErrorFactory()

}
