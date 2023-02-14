package com.abc.reactiveexample;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.security.PublicKey;
import java.util.List;

@Service
public class ProductService {



    public  Mono<List<Product>> getProduct(){

        WebClient webClient = WebClient.create("https://fakestoreapi.com/");
        Mono<List<Product>> products =  webClient.get().uri("products").retrieve().bodyToMono(new ParameterizedTypeReference<List<Product>>() { });

       return products;

    }
}
