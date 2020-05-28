package bingege.blog.article

import bingege.blog.SecurityTestConfig
import bingege.blog.article.payload.CreateArticle
import bingege.blog.article.payload.CreateArticleCategory
import bingege.blog.article.payload.UpdateArticle
import com.google.gson.Gson
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(ArticleController::class)
@Import(SecurityTestConfig::class)
@WithMockUser
class ArticleControllerTest {

    @Autowired
    lateinit var mvc: MockMvc

    @MockBean
    lateinit var articleService: ArticleService

    @Test
    fun createCategory() {
        given(articleService.createCategory("test"))
            .willReturn(ArticleCategory("test"))

        val category = CreateArticleCategory("test")
        mvc.perform(post("/api/article/category")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(Gson().toJson(category)))
            .andExpect(status().isOk)
    }

    @Test
    fun createArticle() {
        val payload = CreateArticle()
        BDDMockito.`when`(articleService.create(payload)).thenReturn(Article())

        mvc.perform(post("/api/article")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(Gson().toJson(payload)))
            .andExpect(status().isOk)
    }


    @Test
    fun updateArticle() {
        BDDMockito.doNothing().`when`(articleService)

        val payload = UpdateArticle()
        mvc.perform(put("/api/article")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(Gson().toJson(payload)))
            .andExpect(status().isOk)
    }

    @Test
    fun publish() {
        val id = 1L
        BDDMockito.doNothing().`when`(articleService)

        mvc.perform(put("/api/article/${id}/publish"))
            .andExpect(status().isOk)
    }

    @Test
    fun suppress() {
        val id = 1L
        BDDMockito.doNothing().`when`(articleService)

        mvc.perform(put("/api/article/${id}/suppress"))
            .andExpect(status().isOk)
    }

    @Test
    fun getCategory() {
        given(articleService.getCategory()).willReturn(listOf(ArticleCategory("test")))

        mvc.perform(get("/api/article/category"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$[0].name").value("test"))
            .andDo(MockMvcResultHandlers.print())
    }
}
