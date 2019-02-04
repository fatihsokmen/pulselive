package com.github.fatihsokmen.pulselive.details.data

import io.reactivex.Single
import javax.inject.Inject

class ArticleDetailsApiInteractor @Inject constructor(
        private val apiService: ArticleDetailsApiService
) {

    fun getArticleDetails(id: String): Single<ArticleDetailsDomain> =
            apiService.getArticleDetails(id).map { dto ->
                ArticleDetailsDomain(
                        dto.item.id,
                        dto.item.title,
                        dto.item.subTitle,
                        dto.item.date,
                        dto.item.body
                )
            }
}

