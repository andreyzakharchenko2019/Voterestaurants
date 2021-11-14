package com.andreyzakharchenko.voterestaurants.web.restaurant;

import com.andreyzakharchenko.voterestaurants.model.Restaurant;
import com.andreyzakharchenko.voterestaurants.service.RestaurantService;
import com.andreyzakharchenko.voterestaurants.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

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
}
