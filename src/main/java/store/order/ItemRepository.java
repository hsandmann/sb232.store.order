package store.order;

import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<ItemModel, String> {
    
}
