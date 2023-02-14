package com.abc.reactiveexample.vo;

import lombok.Data;

@Data
public class AddressVO {
    private Geolocation geolocation;
    private String city;
    private String street;
    private int number;
    private String zipcode;
}
