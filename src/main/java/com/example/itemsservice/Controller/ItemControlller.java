package com.example.itemsservice.Controller;

import com.example.itemsservice.Model.Item;
import com.example.itemsservice.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/item")
public class ItemControlller {

    @Autowired
    ItemService itemService;

    @PostMapping("/create") public String saveItem(@RequestBody Item item){
        itemService.saveItem(item);
        return "Item Added";
    }

    
}
