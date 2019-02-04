package com.github.fatihsokmen.pulselive.articles.data

import com.google.gson.annotations.SerializedName

data class ArticlesResponseDto(
    @SerializedName("items") val articles: List<ArticleDto>
)

data class ArticleDto(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("subtitle") val subTitle: String,
    @SerializedName("date") val date: String
)