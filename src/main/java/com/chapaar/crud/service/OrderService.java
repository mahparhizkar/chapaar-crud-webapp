package com.chapaar.crud.service;

import com.chapaar.crud.model.Order;
import com.chapaar.crud.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Transactional
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Transactional
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Transactional
    public void delete(long orderItemId) {
        orderRepository.deleteById(orderItemId);
    }
}
