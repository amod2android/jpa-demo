package com.bajaj.jpalearning.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity(name ="addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_no",nullable = false)
    private Integer roomNo;

    @Column(nullable = false)
    private String details;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private Integer pincode;

    @ManyToOne()
    @JsonIgnore
    private Customer customer;

    @JsonIgnore
    public Customer getCustomer() {
        return customer;
    }

    @JsonProperty("customer")
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address() {
    }

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Address(Integer roomNo, String details, String city, Integer pincode, Customer customer) {
        this.roomNo = roomNo;
        this.details = details;
        this.city = city;
        this.pincode = pincode;
        this.customer = customer;
    }

    public Address(Long id, Integer roomNo, String details, String city, Integer pincode, Customer customer, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.roomNo = roomNo;
        this.details = details;
        this.city = city;
        this.pincode = pincode;
        this.customer = customer;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
