package com.andreyzakharchenko.voterestaurants.model;

import java.time.LocalDate;

public class VoteUser {

    private Integer user_id;

    private Integer launch_id;

    private LocalDate date_vote;

    public VoteUser() {
    }

    public VoteUser(Integer user_id, Integer launch_id, LocalDate date_vote) {
        this.user_id = user_id;
        this.launch_id = launch_id;
        this.date_vote = date_vote;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getLaunch_id() {
        return launch_id;
    }

    public void setLaunch_id(Integer launch_id) {
        this.launch_id = launch_id;
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
                "user_id=" + user_id +
                ", launch_id=" + launch_id +
                ", date_vote=" + date_vote +
                '}';
    }
}
