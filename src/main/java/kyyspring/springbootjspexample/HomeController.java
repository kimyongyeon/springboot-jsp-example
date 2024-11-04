package kyyspring.springbootjspexample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Hello, Spring Boot with JSP and Gradle!");
        return "index"; // index.jsp로 이동
    }
}