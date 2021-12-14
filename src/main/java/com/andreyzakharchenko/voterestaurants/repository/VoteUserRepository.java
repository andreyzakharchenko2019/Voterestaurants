package com.andreyzakharchenko.voterestaurants.repository;

import com.andreyzakharchenko.voterestaurants.model.VoteUser;

import java.util.List;

public interface VoteUserRepository {
    // null if updated meal do not belong to userId
    VoteUser save(VoteUser voteUser, int userId, int launchId);

    // false if meal do not belong to userId
    boolean delete(int id, int userId);

    // null if meal do not belong to userId
    VoteUser get(int id, int userId);

    // ORDERED dateTime desc
    List<VoteUser> getAll(int userId);
}
