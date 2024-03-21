package org.example.controller;


import org.example.entity.Product;
import org.example.entity.Users;
import org.example.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Collection<Product> getAll(){
        return productService.findAll();
    }

    @RequestMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @RequestMapping(path = "/saveAll", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public List<Product> saveAll(@RequestBody List<Product> product){
        return productService.save(product);
    }

    @RequestMapping(path = "/subscribe", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Product subscribe(@RequestBody Product product,
                          @RequestBody Users users){
        product.getUsersSubscribe().add(users);
        return productService.save(product);
    }
}
