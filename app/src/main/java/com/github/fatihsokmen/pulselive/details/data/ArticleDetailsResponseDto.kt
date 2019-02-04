package com.github.fatihsokmen.pulselive.details.data

import com.google.gson.annotations.SerializedName

data class ArticleDetailsResponseDto(
        @SerializedName("item") val item: ArticleDetailDto
)

data class ArticleDetailDto(
        @SerializedName("id") val id: String,
        @SerializedName("title") val title: String,
        @SerializedName("subtitle") val subTitle: String,
        @SerializedName("date") val date: String,
        @SerializedName("body") val body: String
)