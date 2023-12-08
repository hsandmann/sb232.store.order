package store.order;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.customer.CustomerController;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerController customerController;

    public List<Order> list() {
        List<Order> orders = StreamSupport.stream(orderRepository.findAll().spliterator(), false)
            .collect(Collectors.toList())
            .stream().map(OrderModel::to).toList();
        orders.forEach(order -> order.customer(customerController.get(order.customer().id())));
        return orders;
    }

    public Order get(String id) {
        Order order = orderRepository.findById(id).orElse(null).to();
        if (order == null) return null;
        order.customer(customerController.get(order.customer().id()));
        return order;
    }

    public Order save(Order order) {
        return orderRepository.save(new OrderModel(order)).to();
    }

}
