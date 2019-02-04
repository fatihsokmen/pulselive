package com.github.fatihsokmen.pulselive.details


import com.github.fatihsokmen.pulselive.R
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.github.fatihsokmen.pulselive.App
import javax.inject.Inject

class ArticleDetailsFragment : Fragment(), ArticleDetailsFragmentContract.View {


    @BindView(R.id.date)
    lateinit var dateView: TextView

    @BindView(R.id.body)
    lateinit var bodyView: TextView

    @BindView(R.id.progress)
    internal lateinit var progressView: ProgressBar

    @Inject
    internal lateinit var presenter: ArticleDetailsFragmentContract.Presenter


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_article_details, container, false)
        ButterKnife.bind(this, view)

        val id = activity?.intent?.getStringExtra(ArticleDetailsActivity.KEY_ARTICLE)!!

        createArticleDetailsComponent(this).inject(this)

        presenter.init(id)

        return view
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
        Snackbar.make(view!!, message ?: "Unknown error", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        presenter.cleanup()
        super.onDestroyView()
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
