package store.order;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import store.customer.CustomerOut;

@CrossOrigin(origins = "*")
@RestController
public class OrderResource implements OrderController {

    @Autowired
    private OrderService orderService;

    @Override
    public List<OrderOut> list(String idUser) {
        return orderService.list().stream().map(OrderParser::to).toList();
    }

    @Override
    public ResponseEntity<Object> create(String idUser, OrderIn in) {
        Order order = OrderParser.to(in)
            .customer(new CustomerOut(idUser))
            .creationDate(new Date());
        return ResponseEntity.created(
                    ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(orderService.save(order).id())
                        .toUri())
                    .build();        
    }

    @Override
    public void delete(String idUser, String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public OrderOut get(String idUser, String id) {
        return OrderParser.to(orderService.get(id));
    }

}
