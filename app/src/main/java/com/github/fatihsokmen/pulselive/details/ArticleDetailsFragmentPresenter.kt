package com.github.fatihsokmen.pulselive.details

import com.github.fatihsokmen.pulselive.dependency.scheduler.Scheduler
import com.github.fatihsokmen.pulselive.details.data.ArticleDetailsApiInteractor
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ArticleDetailsFragmentPresenter @Inject constructor(
        private val view: ArticleDetailsFragmentContract.View,
        private val articleDetailsApInteractor: ArticleDetailsApiInteractor,
        private val scheduler: Scheduler
) : ArticleDetailsFragmentContract.Presenter {

    private val subscriptions = CompositeDisposable()

    override fun init(id: String) {
        view.showProgress(true)
        subscriptions.addAll(
                articleDetailsApInteractor.getArticleDetails(id)
                        .subscribeOn(scheduler.io())
                        .observeOn(scheduler.main())
                        .subscribe({ articleDetails ->
                            view.showProgress(false)
                            view.setTitle(articleDetails.title)
                            view.setSubTitle(articleDetails.subTitle)
                            view.setDate(articleDetails.date)
                            view.setBody(articleDetails.body)
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
