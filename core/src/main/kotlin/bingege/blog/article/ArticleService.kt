package bingege.blog.article

import bingege.blog.article.payload.CreateArticle
import bingege.blog.article.payload.UpdateArticle
import bingege.blog.common.base.BaseService
import org.springframework.data.domain.Pageable


interface ArticleService : BaseService<Article> {

    fun create(createArticle: CreateArticle): Article

    fun update(updateArticle: UpdateArticle)

    fun publish(id: Long)

    fun suppress(id: Long)

    fun createCategory(name: String): ArticleCategory

    fun getCategory(): List<ArticleCategory>
}