package com.github.fatihsokmen.pulselive.articles

import com.github.fatihsokmen.pulselive.dependency.BaseComponent
import com.github.fatihsokmen.pulselive.dependency.scope.FragmentViewScope
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [BaseComponent::class], modules = [ArticlesFragmentModule::class])
@FragmentViewScope
interface ArticlesFragmentComponent {

    fun inject(fragment: ArticlesFragment)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun view(view: ArticlesFragmentContract.View): Builder

        fun baseComponent(baseComponent: BaseComponent): Builder

        fun build(): ArticlesFragmentComponent
    }
}