package com.zcpt.controller.order;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zcpt.order.IOrderService;
import com.zcpt.pojo.order.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/orderlogin")
public class OrderController {
    @Reference
    private IOrderService orderService;

    @RequestMapping("/myOrder")
    public String findMyOrder(Model model , @RequestParam Integer id){
        List<Order> orderList = orderService.findMyOrder(id);
        if(orderList != null){
            model.addAttribute("orderList" , orderList);
            return "";
        }
        return "  ";
    }

    @RequestMapping("/addOrder")
    public String addOrder(@RequestBody Order order){
        orderService.addOrder(order);
        return "success";
    }
}
