package com.cg.main.entities;

import javax.persistence.Embeddable;


@Embeddable                //address is a value object
public class Address {
public String addType;
public String street;
public String city;
public String state;
public String country;
public String pinCode;
}
