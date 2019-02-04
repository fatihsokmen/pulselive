package com.github.fatihsokmen.pulselive.details


class ArticleDetailsFragmentContract {

    interface View {
        fun setTitle(title: String)

        fun setSubTitle(subTitle: String)

        fun setDate(date: String)

        fun setBody(body: String)

        fun showProgress(show: Boolean)

        fun showError(message: String?)
    }

    interface Presenter {
        fun init(id: String)

        fun cleanup()
    }
}
