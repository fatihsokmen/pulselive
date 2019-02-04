package com.github.fatihsokmen.pulselive.articles.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.github.fatihsokmen.pulselive.R
import com.github.fatihsokmen.pulselive.details.ArticleDetailsActivity
import com.github.fatihsokmen.pulselive.articles.data.ArticleDomain
import javax.inject.Inject

class ArticleViewHolder @Inject constructor(
        itemView: View
) : RecyclerView.ViewHolder(itemView) {

    @BindView(R.id.title)
    lateinit var titleView: TextView
    @BindView(R.id.date)
    lateinit var dateView: TextView
    @BindView(R.id.subtitle)
    lateinit var subTitleView: TextView

    private lateinit var article: ArticleDomain

    init {
        ButterKnife.bind(this, itemView)
    }

    fun bind(article: ArticleDomain) {
        this.article = article

        titleView.text = article.title
        dateView.text = article.date
        subTitleView.text = article.subTitle
    }

    @OnClick(R.id.article)
    fun onArticleClicked() {
        itemView.context.apply {
            startActivity(ArticleDetailsActivity.getIntent(this, article))
        }
    }
}