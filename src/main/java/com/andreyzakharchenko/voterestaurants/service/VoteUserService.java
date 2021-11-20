package com.andreyzakharchenko.voterestaurants.service;

import com.andreyzakharchenko.voterestaurants.model.VoteUser;
import com.andreyzakharchenko.voterestaurants.repository.VoteUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteUserService {
    private final VoteUserRepository repository;

    public VoteUserService(VoteUserRepository repository) {
        this.repository = repository;
    }

    public List<VoteUser> getAll(int userId) {
        return repository.getAll(userId);
    }
}
