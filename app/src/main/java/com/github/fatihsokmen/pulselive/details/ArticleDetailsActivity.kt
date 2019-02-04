package com.github.fatihsokmen.pulselive.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import butterknife.BindView
import butterknife.ButterKnife
import com.github.fatihsokmen.pulselive.R
import com.github.fatihsokmen.pulselive.articles.data.ArticleDomain

class ArticleDetailsActivity : AppCompatActivity() {

    @BindView(R.id.toolbar)
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_details)
        ButterKnife.bind(this)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {

        @VisibleForTesting
        const val KEY_ARTICLE = "article"

        fun getIntent(context: Context, article: ArticleDomain) =
                Intent(context, ArticleDetailsActivity::class.java).apply {
                    putExtra(KEY_ARTICLE, article.id)
                }
    }
}