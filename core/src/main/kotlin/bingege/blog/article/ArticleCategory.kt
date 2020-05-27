package bingege.blog.article

import bingege.blog.common.base.Base
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "t_article_category")
class ArticleCategory(
    var name: String
) : Base()
