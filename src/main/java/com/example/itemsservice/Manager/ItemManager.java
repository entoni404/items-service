package com.example.itemsservice.Manager;

import com.example.itemsservice.Model.ItemEntity;
import com.example.itemsservice.Repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
@RequiredArgsConstructor

public class ItemManager {

    @Autowired
    ItemRepository itemRepository;

    public void saveItem(ItemEntity itemEntity) {
        itemRepository.save(itemEntity);
    }

    public List<ItemEntity> getAllItems() {
        return itemRepository.findAll();
    }

    public ItemEntity getItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("The item does not exist"));
    }

    public void deleteAllItems() {
        itemRepository.deleteAll();
    }

    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }

    public void updateItem(ItemEntity itemEntity, Long id) {
        ItemEntity currentItem = getItemById(id);
        currentItem.setName(itemEntity.getName());
        currentItem.setPrice(itemEntity.getPrice());
        currentItem.setQuantity(itemEntity.getQuantity());
        currentItem.setVolume(itemEntity.getVolume());
        itemRepository.save(currentItem);
    }

}
