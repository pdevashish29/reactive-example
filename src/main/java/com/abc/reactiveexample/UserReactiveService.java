package com.abc.reactiveexample;

import com.abc.reactiveexample.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
public class UserReactiveService {


    public Mono<List<UserVO>> getUsers(){
        log.info("reactive-fake store");
        WebClient webClient = WebClient.create("http://127.0.0.1:8000");
return   webClient.get().uri("/fakestore/users").retrieve().bodyToMono(new ParameterizedTypeReference<List<UserVO>>() {
        });
    }

    public UserVO getUserById(Integer userId) {
        UserVO userVO = new UserVO();
       return  userVO;
    }


}
