package store.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import store.product.ProductOut;

@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Accessors(chain = true, fluent = true)
public class Item {

    private String id;
    private OrderOut order;
    private ProductOut product;
    private Double price;
    private Integer qtd;
    private Double total;
    
}
