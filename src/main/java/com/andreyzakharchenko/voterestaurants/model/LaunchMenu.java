package com.andreyzakharchenko.voterestaurants.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LaunchMenu extends AbstractNamedEntity {

    private Integer restaurant_id;

    private double price;

    private LocalDate date;

    public LaunchMenu() {
    }

    public LaunchMenu(Integer id, String name, Integer restaurant_id, double price, LocalDate date) {
        super(id, name);
        this.restaurant_id = restaurant_id;
        this.price = price;
        this.date = date;
    }

    public Integer getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Integer restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "LaunchMenu{" +
                "restaurant_id=" + restaurant_id +
                ", price=" + price +
                ", dateTime=" + date +
                '}';
    }
}
