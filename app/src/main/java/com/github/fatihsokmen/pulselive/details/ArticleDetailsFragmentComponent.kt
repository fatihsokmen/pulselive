package com.github.fatihsokmen.pulselive.details

import com.github.fatihsokmen.pulselive.dependency.BaseComponent
import com.github.fatihsokmen.pulselive.dependency.scope.FragmentViewScope
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [BaseComponent::class], modules = [ArticleDetailsFragmentModule::class])
@FragmentViewScope
interface ArticleDetailsFragmentComponent {

    fun inject(fragment: ArticleDetailsFragment)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun view(view: ArticleDetailsFragmentContract.View): Builder

        fun baseComponent(baseComponent: BaseComponent): Builder

        fun build(): ArticleDetailsFragmentComponent
    }
}