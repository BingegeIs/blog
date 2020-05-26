package bingege.blog.home

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HomeController {

    @RequestMapping("/index")
    fun index(): String {
       return "index"
    }
}