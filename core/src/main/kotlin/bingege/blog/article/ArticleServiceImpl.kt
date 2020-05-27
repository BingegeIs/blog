package bingege.blog.article

import bingege.blog.article.payload.CreateArticle
import bingege.blog.article.payload.UpdateArticle
import bingege.blog.common.base.BaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ArticleServiceImpl(
    @Autowired val articleRepository: ArticleRepository,
    @Autowired val articleCategoryRepository: ArticleCategoryRepository
) : BaseService<Article>, ArticleService, ArticleRepository by articleRepository {

    override fun create(createArticle: CreateArticle): Article {
        TODO("Not yet implemented")
    }

    override fun update(updateArticle: UpdateArticle) {
        TODO("Not yet implemented")
    }

    override fun publish(id: Long) {
        val article = findOrThrow(id)
        article.publish = true
        save(article)
    }

    override fun suppress(id: Long) {
        val article = findOrThrow(id)
        article.publish = false
        save(article)
    }

    override fun createCategory(name: String): ArticleCategory {
        return ArticleCategory(name)
            .let(articleCategoryRepository::save)
    }
}
