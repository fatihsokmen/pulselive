package com.github.fatihsokmen.pulselive.articles.data

import javax.inject.Inject

class ArticleDtoToDomainMapper @Inject constructor() {

    fun map(dto: ArticleDto): ArticleDomain =
        ArticleDomain(
            dto.id,
            dto.title,
            dto.subTitle,
            dto.date
        )
}
