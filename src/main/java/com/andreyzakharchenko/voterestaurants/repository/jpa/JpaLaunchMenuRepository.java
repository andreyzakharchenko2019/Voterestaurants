package com.andreyzakharchenko.voterestaurants.repository.jpa;

import com.andreyzakharchenko.voterestaurants.model.LaunchMenu;
import com.andreyzakharchenko.voterestaurants.model.Restaurant;
import com.andreyzakharchenko.voterestaurants.repository.LaunchMenuRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaLaunchMenuRepository implements LaunchMenuRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public LaunchMenu save(LaunchMenu launchMenu) {
        if (launchMenu.isNew()) {
            em.persist(launchMenu);
            return launchMenu;
        } else {
            return em.merge(launchMenu);
        }
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return em.createNamedQuery(LaunchMenu.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Override
    public LaunchMenu get(int id) {
        return em.find(LaunchMenu.class, id);
    }

    @Override
    public List<LaunchMenu> getAll() {
        return em.createNamedQuery(LaunchMenu.ALL_SORTED, LaunchMenu.class)
                .getResultList();
    }
}
