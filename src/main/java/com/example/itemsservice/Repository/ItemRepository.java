package com.example.itemsservice.Repository;

import com.example.itemsservice.Model.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity,Long> {

}
