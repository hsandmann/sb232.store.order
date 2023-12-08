package store.order;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import store.customer.CustomerOut;

@Entity
@Table(name = "orders")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class OrderModel {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "id_customer")
    private String idCustomer;

    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    public OrderModel(Order o) {
        this.id = o.id();
        this.idCustomer = o.customer().id();
        this.dateCreation = o.creationDate();
    }

    public Order to() {
        return Order.builder()
            .id(this.id)
            .customer(new CustomerOut(idCustomer))
            .creationDate(dateCreation)
            .build();
    }

}
