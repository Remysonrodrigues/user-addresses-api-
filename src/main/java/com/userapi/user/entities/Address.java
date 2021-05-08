package com.userapi.user.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cep;
    private String state;
    private String city;
    private String district;
    private String street;
    private Integer number;
    private String complement;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public Address() {}

    public Address(
            Long id,
            String cep,
            String state,
            String city,
            String district,
            String street,
            Integer number,
            String complement,
            User user
    ) {
        this.id = id;
        this.cep = cep;
        this.state = state;
        this.city = city;
        this.district = district;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.user = user;
    }

    public Address(Address entity) {
        id = entity.getId();
        cep = entity.getCep();
        state = entity.getState();
        city = entity.getCity();
        district = entity.getDistrict();
        street = entity.getStreet();
        number = entity.getNumber();
        complement = entity.getComplement();
        user = entity.getUser();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
