package com.abc.reactiveexample.fakestore.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "reactive_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String email;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String phone;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    private Integer __v;
}
