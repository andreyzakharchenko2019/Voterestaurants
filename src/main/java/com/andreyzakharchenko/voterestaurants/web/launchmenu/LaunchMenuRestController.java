package com.andreyzakharchenko.voterestaurants.web.launchmenu;

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
        return service.getAll();
    }

    public void delete(int id) {
        //log.info("delete meal {} for user {}", id, userId);
        service.delete(id);
    }

    public LaunchMenu get(int id) {
        //log.info("get meal {} for user {}", id, userId);
        return service.get(id);
    }
}
