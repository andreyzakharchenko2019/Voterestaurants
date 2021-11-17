package com.andreyzakharchenko.voterestaurants.repository;

import com.andreyzakharchenko.voterestaurants.model.LaunchMenu;
import com.andreyzakharchenko.voterestaurants.model.Restaurant;

import java.util.List;

public interface LaunchMenuRepository {
    LaunchMenu save(LaunchMenu launchMenu, int userId);

    boolean delete(int id, int userId);

    LaunchMenu get(int id, int userId);

    List<LaunchMenu> getAll(int userId);
}
