package com.github.fatihsokmen.pulselive.articles


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.fatihsokmen.pulselive.R
import com.github.fatihsokmen.pulselive.articles.data.ArticleDomain
import com.github.fatihsokmen.pulselive.articles.viewholder.ArticleViewHolder
import javax.inject.Inject


class ArticlesAdapter @Inject constructor() : RecyclerView.Adapter<ArticleViewHolder>() {

    private var data = emptyList<ArticleDomain>()

    fun setData(data: List<ArticleDomain>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_article, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
