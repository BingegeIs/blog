package bingege.blog.article

import bingege.blog.common.base.Base
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "t_article")
class Article : Base() {

    var title: String? = null

    var content: String? = null

    var view: Long = 0

    var publish: Boolean = true

    @ManyToOne
    var category: ArticleCategory? = null
}
