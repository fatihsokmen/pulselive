package com.github.fatihsokmen.pulselive.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.github.fatihsokmen.pulselive.R
import com.github.fatihsokmen.pulselive.articles.data.ArticleDomain
import kotlinx.android.synthetic.main.activity_articles.*

class ArticleDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_details)
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