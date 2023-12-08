package store.order;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import store.customer.CustomerOut;

@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Accessors(chain = true, fluent = true)
public class Order {

    private String id;
    private CustomerOut customer;
    private Date creationDate;

    private List<Item> items;
    
}
