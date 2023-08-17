package com.example.itemsservice.Service;

import com.example.itemsservice.Manager.ItemManager;
import com.example.itemsservice.Model.Item;
import com.example.itemsservice.Model.ItemEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor

public class ItemService {

    @Autowired
    ItemManager itemManager;


    public void saveItem(Item item){
        itemManager.saveItem(mapToItemEntity(item));
    }

    private List<Item> getAllItems(){
        return itemManager.getAllItems().stream().map(this::maptoItem).collect(Collectors.toList());
    }

    public Item getItemById(Long id){
        return maptoItem(itemManager.getItemById(id));
    }

    public void deleteAllItems(){
        itemManager.deleteAllItems();
    }

    public void deleteItemById(Long id){
        itemManager.deleteItemById(id);
    }

    public void updateItem(Item item, Long id){
        itemManager.updateItem(mapToItemEntity(item),id);
    }

    public ItemEntity mapToItemEntity(Item item){
        ItemEntity mappedItem = new ItemEntity();
        mappedItem.setId(item.getId());
        mappedItem.setQuantity(item.getQuantity());
        mappedItem.setVolume(item.getVolume());
        mappedItem.setPrice(item.getPrice());
        mappedItem.setName(item.getName());
        return mappedItem;
    }


    public Item maptoItem(ItemEntity itemEntity){
        Item mappedItem = new Item();
        mappedItem.setId(itemEntity.getId());
        mappedItem.setPrice(itemEntity.getPrice());
        mappedItem.setName(itemEntity.getName());
        mappedItem.setQuantity(itemEntity.getQuantity());
        mappedItem.setVolume(itemEntity.getVolume());
        return mappedItem;
    }

}
