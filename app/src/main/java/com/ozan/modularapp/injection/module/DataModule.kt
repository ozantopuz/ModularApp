package com.ozan.modularapp.injection.module

import com.ozan.core.data.injection.modules.ApiModule
import com.ozan.game.data.GameDataModule
import dagger.Module

@Module(
    includes = [
        ApiModule::class,
        GameDataModule::class
    ]
)
internal abstract class DataModule