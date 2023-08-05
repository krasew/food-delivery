package com.bebwhepan.app.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

//import com.bebwhepan.app.Models.Taco.TacoOrder;
import com.bebwhepan.app.Models.Order;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("Order")

public class OrderController {
    @GetMapping("/current")
    public String orderFormT() {
        return "orderForm";
        }
    @PostMapping
    public <T> String processOrder(Order<T> order,
        SessionStatus sessionStatus) {
            log.info("Order submitted: {}", order);
            sessionStatus.setComplete();
        return "redirect:/";
        }
}   