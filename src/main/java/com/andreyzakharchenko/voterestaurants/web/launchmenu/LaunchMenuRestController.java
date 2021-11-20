package com.andreyzakharchenko.voterestaurants.web.launchmenu;

import com.andreyzakharchenko.voterestaurants.model.LaunchMenu;
import com.andreyzakharchenko.voterestaurants.model.Restaurant;
import com.andreyzakharchenko.voterestaurants.service.LaunchMenuService;
import com.andreyzakharchenko.voterestaurants.service.RestaurantService;
import com.andreyzakharchenko.voterestaurants.util.SecurityUtil;
import org.springframework.stereotype.Controller;

import java.util.List;

import static com.andreyzakharchenko.voterestaurants.util.ValidationUtil.assureIdConsistent;
import static com.andreyzakharchenko.voterestaurants.util.ValidationUtil.checkNew;

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

    public void update(LaunchMenu launchMenu, int id) {
        //log.info("update {} for user {}", restaurant, userId);
        assureIdConsistent(launchMenu, id);
        service.update(launchMenu);
    }

    public LaunchMenu create(LaunchMenu launchMenu) {
        //log.info("create {} for user {}", launchMenu);
        checkNew(launchMenu);
        return service.create(launchMenu);
    }
}
