package com.github.fatihsokmen.pulselive.dependency

import com.github.fatihsokmen.pulselive.App
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        AppModule::class,
        NetModule::class
    ]
)
@Singleton
interface AppComponent : BaseComponent {

    fun inject(app: App)

    @Component.Builder
    interface Builder : BaseComponent.Builder<AppComponent, Builder>
}
