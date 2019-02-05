package com.github.fatihsokmen.pulselive.details


import com.github.fatihsokmen.pulselive.R
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.fatihsokmen.pulselive.App
import kotlinx.android.synthetic.main.fragment_article_details.*
import javax.inject.Inject

class ArticleDetailsFragment : Fragment(), ArticleDetailsFragmentContract.View {

    @Inject
    internal lateinit var presenter: ArticleDetailsFragmentContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_article_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = activity?.intent?.getStringExtra(ArticleDetailsActivity.KEY_ARTICLE)!!

        createArticleDetailsComponent(this).inject(this)

        presenter.init(id)

    }

    override fun setTitle(title: String) {
        (activity as AppCompatActivity).supportActionBar?.title = title
    }

    override fun setSubTitle(subTitle: String) {
        (activity as AppCompatActivity).supportActionBar?.subtitle = subTitle
    }

    override fun setDate(date: String) {
        dateView.text = date
    }

    override fun setBody(body: String) {
        bodyView.text = body
    }

    override fun showProgress(show: Boolean) {
        progressView.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun showError(message: String?) {
        Snackbar.make(view!!, message
                ?: getString(R.string.unknown_error_message), Snackbar.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.cleanup()
    }

    companion object {
        private fun createArticleDetailsComponent(fragment: ArticleDetailsFragment)
                : ArticleDetailsFragmentComponent {
            val baseComponent = (fragment.activity?.application as App).baseComponent
            return DaggerArticleDetailsFragmentComponent
                    .builder()
                    .view(fragment)
                    .baseComponent(baseComponent)
                    .build()
        }
    }

}
