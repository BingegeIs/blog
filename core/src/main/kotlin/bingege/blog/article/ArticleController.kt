package bingege.blog.article

import bingege.blog.article.payload.CreateArticle
import bingege.blog.article.payload.CreateArticleCategory
import bingege.blog.article.payload.UpdateArticle
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/article")
@RestController
@Api(tags = ["W 文章"])
class ArticleController(
    @Autowired val articleService: ArticleService
) {

    @PostMapping("/category")
    @ApiOperation("新建文章分类")
    fun createCategory(@RequestBody req: CreateArticleCategory) {
        articleService.createCategory(req.name)
    }

    @PostMapping
    @ApiOperation("新建文章")
    fun createArticle(@RequestBody req: CreateArticle) {
        articleService.create(req)
    }

    @PutMapping
    @ApiOperation("更新文章")
    fun updateArticle(@RequestBody req: UpdateArticle) {
        articleService.update(req)
    }

    @PutMapping("/{id}/publish")
    @ApiOperation("发布文章")
    fun publish(@PathVariable id: Long) {
        articleService.publish(id)
    }

    @DeleteMapping("/{id}/suppress")
    @ApiOperation("撤回文章")
    fun suppress(@PathVariable id: Long) {
        articleService.suppress(id)
    }

    @GetMapping("/category")
    @ApiOperation("文章分类列表")
    fun getCategory(): List<ArticleCategory> {
        return articleService.getCategory()
    }
}
