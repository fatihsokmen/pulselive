package com.github.fatihsokmen.pulselive.articles

import com.github.fatihsokmen.pulselive.dependency.scheduler.Scheduler
import com.github.fatihsokmen.pulselive.articles.data.ArticleApiInteractor
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ArticlesFragmentPresenter @Inject constructor(
        private val view: ArticlesFragmentContract.View,
        private val articleApInteractor: ArticleApiInteractor,
        private val scheduler: Scheduler
) : ArticlesFragmentContract.Presenter {

    private val subscriptions = CompositeDisposable()

    override fun init() {
        view.showProgress(true)
        subscriptions.addAll(
                articleApInteractor.getArticles()
                        .subscribeOn(scheduler.io())
                        .observeOn(scheduler.main())
                        .subscribe({ articles ->
                            view.showProgress(false)
                            view.bindData(articles)

                        }, { error ->
                            view.showProgress(false)
                            view.showError(error.message)
                        })
        )
    }

    override fun cleanup() {
        subscriptions.dispose()
    }
}
