package com.andreyzakharchenko.voterestaurants.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NamedQueries({
        @NamedQuery(name = LaunchMenu.ALL_SORTED, query = "SELECT l FROM LaunchMenu l ORDER BY l.date DESC"),
        @NamedQuery(name = LaunchMenu.DELETE, query = "DELETE FROM LaunchMenu l WHERE l.id=:id"),

})

@Entity
@Table(name = "launch_menu")
public class LaunchMenu extends AbstractNamedEntity {

    public static final String ALL_SORTED = "LaunchMenu.getAllSorted";
    public static final String DELETE = "LaunchMenu.delete";

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @NotNull
    private Restaurant restaurant;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "date", nullable = false)
    @NotNull
    private LocalDate date;

    public LaunchMenu() {
    }

    public LaunchMenu(Integer id, String name) {
        super(id, name);
    }

    public LaunchMenu(String name, Restaurant restaurant, double price, LocalDate date) {
        super(null, name);
        this.restaurant = restaurant;
        this.price = price;
        this.date = date;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant_id(Restaurant restaurant) {
        this.restaurant = restaurant;
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
                "restaurant=" + restaurant +
                ", price=" + price +
                ", dateTime=" + date +
                '}';
    }
}
