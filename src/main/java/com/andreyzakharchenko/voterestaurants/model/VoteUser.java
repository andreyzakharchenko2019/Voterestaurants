package com.andreyzakharchenko.voterestaurants.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NamedQueries({
        @NamedQuery(name = VoteUser.ALL, query = "SELECT v FROM VoteUser v WHERE v.user.id=:userId"),
        @NamedQuery(name = VoteUser.DELETE, query = "DELETE FROM VoteUser v WHERE v.id=:id AND v.user.id=:userId"),

})

@Entity
@Table(name = "vote_users", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "date_vote"}, name = "vote_users_unique_user_date_vote_idx")})
public class VoteUser extends AbstractBaseEntity {

    public static final String ALL = "VoteUser.getAll";
    public static final String DELETE = "VoteUser.delete";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "launch_id", nullable = false)
    @NotNull
    private LaunchMenu launchMenu;

    @JoinColumn(name = "date_vote", nullable = false)
    private LocalDate date_vote;

    public VoteUser() {
    }

    public VoteUser(LocalDate date_vote) {
        this(null, date_vote);
    }

    public VoteUser(Integer id, LocalDate date_vote) {
        super(id);
        this.date_vote = date_vote;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LaunchMenu getLaunchMenu() {
        return launchMenu;
    }

    public void setLaunchMenu(LaunchMenu launchMenu) {
        this.launchMenu = launchMenu;
    }

    public LocalDate getDate_vote() {
        return date_vote;
    }

    public void setDate_vote(LocalDate date_vote) {
        this.date_vote = date_vote;
    }

    @Override
    public String toString() {
        return "VoteUser{" +
                ", launch_id=" + launchMenu +
                ", date_vote=" + date_vote +
                '}';
    }
}
