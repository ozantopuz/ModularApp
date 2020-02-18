package com.ozan.modularapp.injection.module

import android.content.Context
import com.ozan.core.injection.modules.CoreModule
import com.ozan.modularapp.ModularApp
import dagger.Module
import dagger.Provides

@Module(
    includes = [CoreModule::class]
)
class ApplicationModule {

    @Provides
    fun provideApplicationContext(app: ModularApp): Context {
        return app.applicationContext
    }
}