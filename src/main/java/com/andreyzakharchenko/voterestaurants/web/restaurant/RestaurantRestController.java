package com.andreyzakharchenko.voterestaurants.web.restaurant;

import com.andreyzakharchenko.voterestaurants.model.Restaurant;
import com.andreyzakharchenko.voterestaurants.service.RestaurantService;
import com.andreyzakharchenko.voterestaurants.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

import static com.andreyzakharchenko.voterestaurants.util.ValidationUtil.assureIdConsistent;
import static com.andreyzakharchenko.voterestaurants.util.ValidationUtil.checkNew;

@Controller
public class RestaurantRestController {

    private final RestaurantService service;

    public RestaurantRestController(RestaurantService service) {
        this.service = service;
    }

    public List<Restaurant> getAll() {
        int userId = SecurityUtil.authUserId();
        return service.getAll(userId);
    }

    public void delete(int id) {
        //log.info("delete meal {} for user {}", id, userId);
        service.delete(id);
    }

    public Restaurant get(int id) {
        int userId = SecurityUtil.authUserId();
        //log.info("get meal {} for user {}", id, userId);
        return service.get(id, userId);
    }

    public void update(Restaurant restaurant, int id) {
        int userId = SecurityUtil.authUserId();
        //log.info("update {} for user {}", restaurant, userId);
        assureIdConsistent(restaurant, id);
        service.update(restaurant, userId);
    }

    public Restaurant create(Restaurant restaurant) {
        //log.info("create {} for user {}", restaurant, userId);
        checkNew(restaurant);
        return service.create(restaurant);
    }
}
