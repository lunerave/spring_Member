package springproject.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // first page 요청 메서드
    @GetMapping("/")
    public String index() {
        return "index";
    }

}
