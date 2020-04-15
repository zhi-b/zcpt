package com.zcpt.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zcpt.mapper.OrderMapper;
import com.zcpt.order.IOrderService;
import com.zcpt.pojo.order.Order;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void addOrder(Order order) {
        orderMapper.insert(order);
    }

    @Override
    public List<Order> findMyOrder(Integer userId) {
        return orderMapper.selectList(new QueryWrapper<Order>().eq("user_id" , userId));
    }
}
