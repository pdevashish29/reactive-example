package com.abc.reactiveexample.fakestore.web;

import com.abc.reactiveexample.fakestore.vo.UserVO;
import com.abc.reactiveexample.fakestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fakestore")
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping("/users")
    public List<UserVO> getUsers(){
        return  userService.getUsers();
    }


    @GetMapping("/users/{userId}")
    public UserVO getUseerById(@PathVariable Integer userId){
        return  userService.getUserById(userId);
    }

    @PostMapping("/users")
    public UserVO createOrUpdateUser(@RequestBody UserVO  userVO){
        return  userService.createOrUpdate(userVO);
    }

    @DeleteMapping("users/{userId}")
    public void deleteUser(@PathVariable Integer userId){

        userService.deleteUser(userId);

    }


}
