package com.zcpt.controller.order;

import com.zcpt.order.IOrderService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Reference
    private IOrderService orderService;

    @GetMapping("/addOrder")
    public String addOrder(){

        return "";
    }
}
