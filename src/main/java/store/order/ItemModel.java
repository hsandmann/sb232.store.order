package store.order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import store.product.ProductOut;

@Entity
@Table(name = "orders_item")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class ItemModel {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "id_orders")
    private String idOrder;

    @Column(name = "id_product")
    private String idProduct;

    @Column(name = "qtd")
    private Integer qtd;

    @Column(name = "total")
    private Double total;

    public ItemModel(Item o) {
        this.id = o.id();
        this.idOrder = o.order().id();
        this.idProduct = o.product().id();
        this.qtd = o.qtd();
        this.total = o.total();
    }

    public Item to() {
        return Item.builder()
            .id(this.id)
            .order(new OrderOut(id))
            .product(new ProductOut(id))
            .qtd(qtd)
            .total(total)
            .build();
    }

}
