package com.andreyzakharchenko.voterestaurants.repository.datajpa;

import com.andreyzakharchenko.voterestaurants.model.LaunchMenu;
import com.andreyzakharchenko.voterestaurants.model.VoteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudVoteUserRepository extends JpaRepository<VoteUser, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM VoteUser v WHERE v.id=:id AND v.user.id=:userId")
    int delete(@Param("id") int id, @Param("userId") int userId);

    @Query("SELECT v FROM VoteUser v WHERE v.user.id=:userId ORDER BY v.date_vote DESC")
    List<VoteUser> getAll(@Param("userId") int userId);
}
