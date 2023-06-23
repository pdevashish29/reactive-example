package com.abc.reactiveexample.rest.api;

import com.abc.reactiveexample.rest.vo.Product;
import com.abc.reactiveexample.rest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    private ProductService productService;
    @GetMapping("products")
    public Mono<List<Product>> getProduct(){
        return productService.getProduct();
    }
}
