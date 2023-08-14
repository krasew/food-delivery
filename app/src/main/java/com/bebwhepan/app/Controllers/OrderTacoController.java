package com.bebwhepan.app.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bebwhepan.app.Models.Taco.TacoOrder;
import com.bebwhepan.app.Data.OrderRepository;

import jakarta.validation.Valid;
//import lombok.extern.slf4j.Slf4j;

//@Slf4j
@Controller
@RequestMapping("/ordersTaco")
@SessionAttributes("tacoOrder")

public class OrderTacoController {
    private OrderRepository orderRepo;
    public OrderTacoController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }
    @GetMapping("/current")
    public String orderFormT() {
        return "orderFormTaco";
        }
    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors,
        SessionStatus sessionStatus) {
            if (errors.hasErrors()) {
                return "orderFormTaco";
                }

            //log.info("Order submitted: {}", order);
            orderRepo.save(order);
            sessionStatus.setComplete();
            return "redirect:/";
        }
}   