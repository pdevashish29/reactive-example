package com.abc.reactiveexample.rest.service;

import com.abc.reactiveexample.rest.vo.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {


    public  Mono<List<Product>> getProduct(){
        WebClient webClient = WebClient.create("https://fakestoreapi.com/");
       return webClient.get().uri("products").retrieve().bodyToMono(new ParameterizedTypeReference<List<Product>>() {}).flatMap(res -> {
            return Mono.just(Collections.emptyList());
        });

    }
}
