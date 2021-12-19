package com.andreyzakharchenko.voterestaurants.repository.datajpa;

import com.andreyzakharchenko.voterestaurants.model.LaunchMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CrudLaunchMenuRepository extends JpaRepository<LaunchMenu, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM LaunchMenu l WHERE l.id=:id")
    int delete(@Param("id") int id);
}
