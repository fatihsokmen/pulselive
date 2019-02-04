package com.github.fatihsokmen.pulselive.articles.data

import io.reactivex.Single
import retrofit2.http.GET

interface ArticleApiService {

    @GET(value = "contentList.json")
    fun getArticles(): Single<ArticlesResponseDto>
}
