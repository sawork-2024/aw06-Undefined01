package com.example.webpos.db;

import org.springframework.data.repository.CrudRepository;
import com.example.webpos.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
