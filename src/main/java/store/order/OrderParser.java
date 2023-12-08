package store.order;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import store.product.ProductOut;

public final class OrderParser {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Order to(OrderIn in) {
        return Order.builder().build();
    }

    public static OrderOut to(Order o) {
        return new OrderOut(
            o.id(),
            sdf.format(o.creationDate()),
            o.customer(),
            o.items() == null ? new ArrayList<>() : o.items().stream().map(OrderParser::to).toList()         
        );
    }

    public static Item to(ItemIn in) {
        return Item.builder()
            .order(new OrderOut(in.orderId()))
            .product(new ProductOut(in.productId()))
            .qtd(in.qtd())
            .build();
    }

    public static ItemOut to(Item o) {
        return new ItemOut(
            o.id(),
            o.order(),
            o.product(),
            o.qtd(),
            o.price(),
            o.total()
        );
    }
    
}
