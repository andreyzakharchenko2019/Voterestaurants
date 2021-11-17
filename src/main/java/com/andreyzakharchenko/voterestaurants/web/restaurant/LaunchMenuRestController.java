package com.andreyzakharchenko.voterestaurants.web.restaurant;

import com.andreyzakharchenko.voterestaurants.model.LaunchMenu;
import com.andreyzakharchenko.voterestaurants.model.Restaurant;
import com.andreyzakharchenko.voterestaurants.service.LaunchMenuService;
import com.andreyzakharchenko.voterestaurants.service.RestaurantService;
import com.andreyzakharchenko.voterestaurants.util.SecurityUtil;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class LaunchMenuRestController {

    private final LaunchMenuService service;

    public LaunchMenuRestController(LaunchMenuService service) {
        this.service = service;
    }

    public List<LaunchMenu> getAll() {
        int userId = SecurityUtil.authUserId();
        return service.getAll(userId);
    }
}
