package com.andreyzakharchenko.voterestaurants.service;

import com.andreyzakharchenko.voterestaurants.model.LaunchMenu;
import com.andreyzakharchenko.voterestaurants.repository.LaunchMenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaunchMenuService {

    private final LaunchMenuRepository repository;

    public LaunchMenuService(LaunchMenuRepository repository) {
        this.repository = repository;
    }

    public List<LaunchMenu> getAll(int userId) {
        return repository.getAll(userId);
    }
}
