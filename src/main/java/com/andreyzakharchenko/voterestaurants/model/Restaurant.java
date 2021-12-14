package com.andreyzakharchenko.voterestaurants.model;


import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = Restaurant.ALL, query = "SELECT r FROM Restaurant r"),
        @NamedQuery(name = Restaurant.DELETE, query = "DELETE FROM Restaurant r WHERE r.id=:id"),

})

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractNamedEntity {

    public static final String ALL = "Restaurant.getAll";
    public static final String DELETE = "Restaurant.delete";

    public Restaurant() {
    }

    public Restaurant(Integer id, String name) {
        super(id, name);
    }
    public Restaurant(Integer id) {
        super(id, null);
    }

    public Restaurant(String name) {
        super(null, name);
    }


}
