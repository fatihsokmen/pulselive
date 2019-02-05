package com.github.fatihsokmen.pulselive.articles


import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.OrientationHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.github.fatihsokmen.pulselive.App
import com.github.fatihsokmen.pulselive.R
import com.github.fatihsokmen.pulselive.articles.data.ArticleDomain
import javax.inject.Inject

import kotlinx.android.synthetic.main.fragment_articles.*


class ArticlesFragment : Fragment(), ArticlesFragmentContract.View {

    @Inject
    internal lateinit var adapter: ArticlesAdapter

    @Inject
    internal lateinit var presenter: ArticlesFragmentContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_articles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createArticlesComponent(this).inject(this)

        articlesView.addItemDecoration(DividerItemDecoration(context, OrientationHelper.VERTICAL))
        articlesView.adapter = adapter

        presenter.init()

    }

    override fun bindData(articles: List<ArticleDomain>) {
        adapter.setData(articles)
    }

    override fun showProgress(show: Boolean) {
        progressView.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun showError(message: String?) {
        Snackbar.make(view!!, message ?: getString(R.string.unknown_error_message), Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.cleanup()
    }

    companion object {
        private fun createArticlesComponent(fragment: ArticlesFragment)
                : ArticlesFragmentComponent {
            val baseComponent = (fragment.activity?.application as App).baseComponent
            return DaggerArticlesFragmentComponent
                .builder()
                .view(fragment)
                .baseComponent(baseComponent)
                .build()
        }
    }

}
