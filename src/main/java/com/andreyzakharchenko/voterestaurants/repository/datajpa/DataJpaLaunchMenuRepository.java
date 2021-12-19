package com.andreyzakharchenko.voterestaurants.repository.datajpa;

import com.andreyzakharchenko.voterestaurants.model.LaunchMenu;
import com.andreyzakharchenko.voterestaurants.repository.LaunchMenuRepository;
import org.springframework.data.domain.Sort;

import java.util.List;

public class DataJpaLaunchMenuRepository implements LaunchMenuRepository {
    private static final Sort SORT_DATE = Sort.by(Sort.Direction.DESC, "date");

    private final CrudLaunchMenuRepository crudLaunchMenuRepository;

    public DataJpaLaunchMenuRepository(CrudLaunchMenuRepository crudLaunchMenuRepository) {
        this.crudLaunchMenuRepository = crudLaunchMenuRepository;
    }

    @Override
    public LaunchMenu save(LaunchMenu launchMenu) {
        return crudLaunchMenuRepository.save(launchMenu);
    }

    @Override
    public boolean delete(int id) {
        return crudLaunchMenuRepository.delete(id) != 0;
    }

    @Override
    public LaunchMenu get(int id) {
        return crudLaunchMenuRepository.findById(id).orElse(null);
    }

    @Override
    public List<LaunchMenu> getAll() {
        return crudLaunchMenuRepository.findAll(SORT_DATE);
    }
}
