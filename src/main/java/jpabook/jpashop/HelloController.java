package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){   // 데이터를 실어 나르는 객체
        model.addAttribute("data","hello!!!");
        return "hello"; // view 파일명
    }
}
