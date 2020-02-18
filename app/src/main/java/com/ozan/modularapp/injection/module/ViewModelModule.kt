package com.ozan.modularapp.injection.module

import androidx.lifecycle.ViewModelProvider
import com.ozan.core.presentation.viewmodel.VmFactory
import dagger.Binds
import dagger.Module

@Module
internal abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(vmFactory: VmFactory): ViewModelProvider.Factory
}