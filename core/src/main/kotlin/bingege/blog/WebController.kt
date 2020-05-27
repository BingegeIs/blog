package bingege.blog

import io.swagger.annotations.Api
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@Api(tags = ["A 主页"])
class WebController {

    @RequestMapping(value = ["index", "/"])
    fun index(model: Model): String {
        model.addAttribute("avatar", "/image/20190815095735993296.jpeg")
        model.addAttribute("name", "nobody")
        model.addAttribute("saying", "fuck")
        return "index"
    }
}
