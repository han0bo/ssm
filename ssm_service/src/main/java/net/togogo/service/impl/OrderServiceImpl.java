package net.togogo.service.impl;

import net.togogo.domain.Order;
import net.togogo.mapper.OrderMapper;
import net.togogo.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderMapper orderMapper;

    @Override
    public List<Order> findAll() {
        return orderMapper.findAll();
    }
}
