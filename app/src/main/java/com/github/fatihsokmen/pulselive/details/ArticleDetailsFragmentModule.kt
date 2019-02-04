package com.github.fatihsokmen.pulselive.details

import com.github.fatihsokmen.pulselive.dependency.scope.FragmentViewScope
import com.github.fatihsokmen.pulselive.details.data.ArticleDetailsApiService
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
abstract class ArticleDetailsFragmentModule {

    @Binds
    @FragmentViewScope
    abstract fun bindsArticleDetailsPresenter(impl: ArticleDetailsFragmentPresenter):
            ArticleDetailsFragmentContract.Presenter

    @Module
    companion object {

        @JvmStatic
        @Provides
        @FragmentViewScope
        fun provideArticleDetailsService(retrofit: Retrofit): ArticleDetailsApiService {
            return retrofit.create(ArticleDetailsApiService::class.java)
        }
    }
}
