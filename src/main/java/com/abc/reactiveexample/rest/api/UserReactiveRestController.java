package com.abc.reactiveexample.rest.api;

import com.abc.reactiveexample.rest.service.UserReactiveService;
import com.abc.reactiveexample.rest.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/reactive-fakestore")
@Slf4j
public class UserReactiveRestController {

    @Autowired
    private UserReactiveService userReactiveService;

    @GetMapping("/users")
    public Mono<List<UserVO>> getUsers(){
        log.info("reactive-fake store");
        return  userReactiveService.getUsers();
    }

}
