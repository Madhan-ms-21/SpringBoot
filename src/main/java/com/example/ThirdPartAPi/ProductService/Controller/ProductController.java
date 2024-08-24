package com.example.ThirdPartAPi.ProductService.Controller;

import com.example.ThirdPartAPi.ProductService.Exceptions.CategoryNotFoundException;
import com.example.ThirdPartAPi.ProductService.Exceptions.ProductNotFoundException;
import com.example.ThirdPartAPi.ProductService.Models.Category;
import com.example.ThirdPartAPi.ProductService.Models.Product;
import com.example.ThirdPartAPi.ProductService.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {


    private  ProductService  productService ;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    // Get single product
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductbyId(@PathVariable int id) throws ProductNotFoundException {
        Product p = productService.getProdbyId(id);
        return new ResponseEntity<>(p, HttpStatusCode.valueOf(200));
    }

    // Limit results by n

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProductsByLimit(@RequestParam(value = "n", defaultValue = "20")  int n) throws ProductNotFoundException {
        List<Product> p =  productService.getProducts(n);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }


//    add a new product
    @PostMapping("/create")
    public String createProduct(){
        return "Inside Post Request";
    }

    @PatchMapping("/update/{productId}")
    public String updateProduct(@PathVariable("productId") int productId){
        return "Inside Patch Request";
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getCategories() throws CategoryNotFoundException {

        List<Category> l ;
        l = productService.getCategories();
        return new ResponseEntity<>(l,HttpStatusCode.valueOf(200));
    }

//    Get products in a specific category
    @GetMapping("/products/category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("category") String category) throws CategoryNotFoundException {
        List<Product> p =  productService.getProductsByCategory(category);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

}
