package com.dev.cinema.dao;

import com.dev.cinema.model.Order;
import java.util.List;

public interface OrderDao {

    Order add(Order order);

    List<Order> getAll();

    List<Order> getUserOrders(Long userId);
}
