package bingege.blog.article

import bingege.blog.article.payload.CreateArticle
import bingege.blog.article.payload.UpdateArticle


interface ArticleService {

    fun create(createArticle: CreateArticle): Article

    fun update(updateArticle: UpdateArticle)

    fun publish(id: Long)

    fun suppress(id: Long)

    fun createCategory(name: String): ArticleCategory
}