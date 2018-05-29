package com.learn.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ADDRESS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	@Id
    @Column(name = "ADDRESS_ID")
    private long id;
 
    @Column(name = "STREET")
    private String street;
 
    @Column(name = "CITY")
    private String city;
 
    @Column(name = "COUNTRY")
    private String country;
    
    public Address(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }
}
