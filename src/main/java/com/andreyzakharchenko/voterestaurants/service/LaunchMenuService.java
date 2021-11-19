package com.andreyzakharchenko.voterestaurants.service;

import com.andreyzakharchenko.voterestaurants.model.LaunchMenu;
import com.andreyzakharchenko.voterestaurants.model.Restaurant;
import com.andreyzakharchenko.voterestaurants.repository.LaunchMenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.andreyzakharchenko.voterestaurants.util.ValidationUtil.checkNotFoundWithId;

@Service
public class LaunchMenuService {

    private final LaunchMenuRepository repository;

    public LaunchMenuService(LaunchMenuRepository repository) {
        this.repository = repository;
    }

    public List<LaunchMenu> getAll() {
        return repository.getAll();
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public LaunchMenu get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }


}
