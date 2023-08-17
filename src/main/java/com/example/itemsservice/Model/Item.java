package com.example.itemsservice.Model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {

    private Long id;
    private String name;
    private int quantity;
    private double price;
    private int volume;

}
