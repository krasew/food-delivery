package com.bebwhepan.app.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bebwhepan.app.Models.Taco.TacoOrder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ordersTaco")
@SessionAttributes("tacoOrder")

public class OrderTacoController {
    @GetMapping("/current")
    public String orderFormT() {
        return "orderFormTaco";
        }
    @PostMapping
    public String processOrder(TacoOrder order,
        SessionStatus sessionStatus) {
            log.info("Order submitted: {}", order);
            sessionStatus.setComplete();
        return "redirect:/";
        }
}   