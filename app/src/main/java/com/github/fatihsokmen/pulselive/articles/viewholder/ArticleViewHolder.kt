package com.github.fatihsokmen.pulselive.articles.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.github.fatihsokmen.pulselive.details.ArticleDetailsActivity
import com.github.fatihsokmen.pulselive.articles.data.ArticleDomain
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.view_article.*
import javax.inject.Inject

class ArticleViewHolder @Inject constructor(
        override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    private lateinit var article: ArticleDomain

    init {
        itemView.setOnClickListener {
            onArticleClicked()
        }
    }

    fun bind(article: ArticleDomain) {
        this.article = article
        titleView.text = article.title
        dateView.text = article.date
        subTitleView.text = article.subTitle
    }

    private fun onArticleClicked() {
        itemView.context.run {
            startActivity(ArticleDetailsActivity.getIntent(this, article))
        }
    }
}