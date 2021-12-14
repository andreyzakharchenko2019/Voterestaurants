package com.andreyzakharchenko.voterestaurants.service;

import com.andreyzakharchenko.voterestaurants.model.VoteUser;
import com.andreyzakharchenko.voterestaurants.repository.VoteUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static com.andreyzakharchenko.voterestaurants.util.ValidationUtil.checkNotFoundWithId;

@Service
public class VoteUserService {
    private final VoteUserRepository repository;

    public VoteUserService(VoteUserRepository repository) {
        this.repository = repository;
    }

    public VoteUser create(VoteUser voteUser, int userId, int launchMenuId) {
        Assert.notNull(voteUser, "voteUser must not be null");
        return repository.save(voteUser, userId, launchMenuId);
    }

    public void delete(int id, int userId) {
        checkNotFoundWithId(repository.delete(id, userId), id);
    }

    public List<VoteUser> getAll(int userId) {
        return repository.getAll(userId);
    }
}
