package com.abc.reactiveexample.fakestore.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "reactive_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    private String latitude;

    private String longitude;
    private String city;
    private String street;

    private String zipcode;
}
