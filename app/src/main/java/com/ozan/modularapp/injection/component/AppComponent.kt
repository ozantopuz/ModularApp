package com.ozan.modularapp.injection.component

import com.ozan.modularapp.*
import com.ozan.modularapp.injection.module.ActivityModule
import com.ozan.modularapp.injection.module.DataModule
import com.ozan.modularapp.injection.module.DomainModule
import com.ozan.modularapp.injection.module.ViewModelModule
import com.ozan.modularapp.injection.module.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class,
        ApplicationModule::class,
        ActivityModule::class,
        DomainModule::class,
        DataModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: ModularApp): Builder

        fun build(): AppComponent
    }

    fun inject(application: ModularApp)
}