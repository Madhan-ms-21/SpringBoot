package com.example.ThirdPartAPi.ProductService.Models;

public class Product {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  String title;
    public  long price ;
    public String description;
    public String category;
}
