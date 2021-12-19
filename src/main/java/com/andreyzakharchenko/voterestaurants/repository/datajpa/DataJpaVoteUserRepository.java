package com.andreyzakharchenko.voterestaurants.repository.datajpa;

import com.andreyzakharchenko.voterestaurants.model.VoteUser;
import com.andreyzakharchenko.voterestaurants.repository.VoteUserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DataJpaVoteUserRepository implements VoteUserRepository {

    private final CrudVoteUserRepository crudVoteUserRepository;
    private final CrudUserRepository crudUserRepository;
    private final CrudLaunchMenuRepository crudLaunchMenuRepository;

    public DataJpaVoteUserRepository(CrudVoteUserRepository crudVoteUserRepository, CrudUserRepository crudUserRepository, CrudLaunchMenuRepository crudLaunchMenuRepository) {
        this.crudVoteUserRepository = crudVoteUserRepository;
        this.crudUserRepository = crudUserRepository;
        this.crudLaunchMenuRepository = crudLaunchMenuRepository;
    }

    @Override
    @Transactional
    public VoteUser save(VoteUser voteUser, int userId, int launchId) {
        if (!voteUser.isNew() && get(voteUser.id(), userId) == null) {
            return null;
        }
        voteUser.setUser(crudUserRepository.getById(userId));
        voteUser.setLaunchMenu(crudLaunchMenuRepository.getById(launchId));
        return crudVoteUserRepository.save(voteUser);
    }

    @Override
    public boolean delete(int id, int userId) {
        return crudVoteUserRepository.delete(id, userId) != 0;
    }

    @Override
    public VoteUser get(int id, int userId) {
        return crudVoteUserRepository.findById(id)
                .filter(voteUser -> voteUser.getUser().getId() == userId)
                .orElse(null);
    }

    @Override
    public List<VoteUser> getAll(int userId) {
        return crudVoteUserRepository.getAll(userId);
    }
}
