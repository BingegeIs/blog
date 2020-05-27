package bingege.blog.article

import bingege.blog.common.base.BaseRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.stereotype.Repository

@Repository
interface ArticleRepository : BaseRepository<Article>, QuerydslPredicateExecutor<Article> {
}