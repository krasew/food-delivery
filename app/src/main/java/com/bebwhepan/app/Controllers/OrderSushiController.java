package com.bebwhepan.app.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bebwhepan.app.Models.Sushi.SushiOrder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ordersSushi")
@SessionAttributes("sushiOrder")

public class OrderSushiController {
    @GetMapping("/current")
    public String orderFormSushi() {
        return "orderFormSushi";
        }
    @PostMapping
    public String processOrder(SushiOrder order,
        SessionStatus sessionStatus) {
            log.info("Order submitted: {}", order);
            sessionStatus.setComplete();
        return "redirect:/";
        }
}   