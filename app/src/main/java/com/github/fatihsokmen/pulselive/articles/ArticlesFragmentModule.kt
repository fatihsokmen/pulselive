package com.github.fatihsokmen.pulselive.articles

import com.github.fatihsokmen.pulselive.dependency.scope.FragmentViewScope
import com.github.fatihsokmen.pulselive.articles.data.ArticleApiService
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
abstract class ArticlesFragmentModule {

    @Binds
    @FragmentViewScope
    abstract fun bindsArticlesPresenter(impl: ArticlesFragmentPresenter):
            ArticlesFragmentContract.Presenter

    @Module
    companion object {

        @JvmStatic
        @Provides
        @FragmentViewScope
        fun provideArticleApiService(retrofit: Retrofit): ArticleApiService {
            return retrofit.create(ArticleApiService::class.java)
        }

        @JvmStatic
        @Provides
        @FragmentViewScope
        fun provideArticleAdapter() = ArticlesAdapter()
    }
}
