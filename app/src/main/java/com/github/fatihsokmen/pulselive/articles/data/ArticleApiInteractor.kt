package com.github.fatihsokmen.pulselive.articles.data

import io.reactivex.Single
import javax.inject.Inject

class ArticleApiInteractor @Inject constructor(
        private val apiService: ArticleApiService,
        private val dtoToDomainMapper: ArticleDtoToDomainMapper
) {

    fun getArticles(): Single<List<ArticleDomain>> =
            apiService.getArticles().map { responseDto ->
                responseDto.articles.map { dto ->
                    dtoToDomainMapper.map(dto)
                }.sortedBy { it.date }
            }
}

