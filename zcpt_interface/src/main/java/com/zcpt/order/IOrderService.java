package com.zcpt.order;

import com.zcpt.pojo.order.Order;

import java.util.List;

public interface IOrderService {
    //插入订单信息
    void addOrder(Order order);

    //查找我的订单
    List<Order> findMyOrder(Integer userId);
}
