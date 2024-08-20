package com.example.ThirdPartAPi.ProductService.Controller;

import com.example.ThirdPartAPi.ProductService.Models.Producct;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductContoller {

    @GetMapping("/products")
    public String getProducts(){
        List<Producct> allProducts = new ArrayList<>();
        return "Hello World";
    }

    @PostMapping("/create")
    public String createProduct(){
        return "Inside Post Request";
    }

    @PatchMapping("/update/{productId}")
    public String updateProduct(@PathVariable("productId") int productId){
        return "Inside Patch Request";
    }
}
