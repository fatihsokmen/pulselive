package com.github.fatihsokmen.pulselive.details.data

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ArticleDetailsApiService {

    @GET(value = "content/{id}.json")
    fun getArticleDetails(@Path(value = "id") id: String): Single<ArticleDetailsResponseDto>
}
