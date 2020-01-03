package com.mapri.webbackend.controller;

import com.mapri.webbackend.domain.Product;
import com.mapri.webbackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable <Product> findAll (){
        Iterable<Product> all = productRepository.findAll();
        return all;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product save (@RequestBody Product product){
        Product p = productRepository.save(product);
        return p;
    }

    @RequestMapping (method = RequestMethod.PUT)
    public Product update (@RequestBody Product product){
        Product p = productRepository.save(product);
        return p;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete (@RequestBody Product product){
        productRepository.deleteById(product.getId());
    }
}
