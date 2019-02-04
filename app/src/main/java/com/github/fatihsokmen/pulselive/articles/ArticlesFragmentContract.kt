package com.github.fatihsokmen.pulselive.articles

import com.github.fatihsokmen.pulselive.articles.data.ArticleDomain


class ArticlesFragmentContract {

    interface View {
        fun showProgress(show: Boolean)

        fun bindData(articles: List<ArticleDomain>)

        fun showError(message: String?)
    }

    interface Presenter {
        fun init()

        fun cleanup()
    }
}
