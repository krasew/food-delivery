package com.bebwhepan.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {
    @GetMapping("/about") // ENDPOINT (basically the link/url)
    public String about() { // METHOD (handles the endpoint)
        return "about"; // web page file `home.html`
    }
}
