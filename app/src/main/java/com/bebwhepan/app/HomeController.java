package com.bebwhepan.app;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/") // ENDPOINT (basically the link/url)
    public String home() { // METHOD (handles the endpoint)
        return "home"; // web page file `home.html`
    }
}