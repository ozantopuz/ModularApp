package com.ozan.modularapp.injection.module

import com.ozan.game.domain.GameDomainModule
import dagger.Module

@Module(
    includes = [GameDomainModule::class]
)
internal abstract class DomainModule