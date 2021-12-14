package com.andreyzakharchenko.voterestaurants.repository.jpa;

import com.andreyzakharchenko.voterestaurants.model.LaunchMenu;
import com.andreyzakharchenko.voterestaurants.model.User;
import com.andreyzakharchenko.voterestaurants.model.VoteUser;
import com.andreyzakharchenko.voterestaurants.repository.VoteUserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaVoteUserRepository implements VoteUserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public VoteUser save(VoteUser voteUser, int userId, int launchMenuId) {
        voteUser.setUser(em.getReference(User.class, userId));
        voteUser.setLaunchMenu(em.getReference(LaunchMenu.class, launchMenuId));
        if (voteUser.isNew()) {
            em.persist(voteUser);
            return voteUser;
        } else if (get(voteUser.id(), userId) == null) {
            return null;
        }
        return em.merge(voteUser);
    }

    @Override
    @Transactional
    public boolean delete(int id, int userId) {
        return em.createNamedQuery(VoteUser.DELETE)
                .setParameter("id", id)
                .setParameter("userId", userId)
                .executeUpdate() != 0;
    }

    @Override
    public VoteUser get(int id, int userId) {
        return null;
    }

    @Override
    public List<VoteUser> getAll(int userId) {
        return em.createNamedQuery(VoteUser.ALL, VoteUser.class)
                .setParameter("userId", userId)
                .getResultList();
    }
}
