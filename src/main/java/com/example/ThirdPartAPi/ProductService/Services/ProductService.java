package com.example.ThirdPartAPi.ProductService.Services;

import com.example.ThirdPartAPi.ProductService.Exceptions.CategoryNotFoundException;
import com.example.ThirdPartAPi.ProductService.Exceptions.ProductNotFoundException;
import com.example.ThirdPartAPi.ProductService.Models.Category;
import com.example.ThirdPartAPi.ProductService.Models.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductService {

    public Product getProdbyId(int id) throws ProductNotFoundException {
        String fakeApiUrl = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = new RestTemplate();
        Product p =  restTemplate.getForObject(fakeApiUrl + "/" + id, Product.class);

        if(p == null){
            throw new ProductNotFoundException("Product with " + id +" Not found");
        }
        return p;

    }

    public List<Product> getProducts(int n) throws ProductNotFoundException{

        String fakeApiUrl = "https://fakestoreapi.com/products";
        if(n > 0){
            fakeApiUrl = "https://fakestoreapi.com/products?limit="+n;
        }

        System.out.print(fakeApiUrl);
        RestTemplate restTemplate = new RestTemplate();
        ParameterizedTypeReference<List<Product>> typeRef = new ParameterizedTypeReference<List<Product>>() {};
        ResponseEntity<List<Product>> response = restTemplate.exchange(fakeApiUrl, HttpMethod.GET, null, typeRef);

        if(response.getBody() != null){
            throw new ProductNotFoundException("Products limit Exceeded");
        }
        return response.getBody();
    }

    public List<Category> getCategories() throws CategoryNotFoundException {
        String fakeApiUrl = "https://fakestoreapi.com/products/categories";
        RestTemplate restTemplate = new RestTemplate();
        List<Category> l =restTemplate.exchange(fakeApiUrl, HttpMethod.GET, null, List.class).getBody();
        return l;
    }

    public List<Product> getProductsByCategory(String category) throws CategoryNotFoundException {
        String fakeApiUrl = "https://fakestoreapi.com/products/category/" + category;
        RestTemplate restTemplate = new RestTemplate();
        List<Product> ListProducts = restTemplate.exchange(fakeApiUrl, HttpMethod.GET, null, List.class).getBody();

        if(ListProducts.isEmpty()){
            throw new CategoryNotFoundException("Category " + category + " Not found");
        }
        return ListProducts;
    }

}
