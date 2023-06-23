package com.abc.reactiveexample.rest.vo;

import lombok.Data;

@Data
public class UserVO {
    private AddressVO address;
    private Integer id;
    private String email;
    private String username;
    private String password;
    private Name name;
    private String phone;
    private Integer __v;
}
