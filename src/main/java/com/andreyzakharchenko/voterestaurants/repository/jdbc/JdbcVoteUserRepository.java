package com.andreyzakharchenko.voterestaurants.repository.jdbc;

import com.andreyzakharchenko.voterestaurants.model.VoteUser;
import com.andreyzakharchenko.voterestaurants.repository.VoteUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcVoteUserRepository implements VoteUserRepository {

    private static final RowMapper<VoteUser> ROW_MAPPER = BeanPropertyRowMapper.newInstance(VoteUser.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertMeal;

    @Autowired
    public JdbcVoteUserRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertMeal = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("vote_users");

        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public VoteUser save(VoteUser voteUser, int userId, int launchId) {
        return null;
    }

    @Override
    public boolean delete(int id, int userId) {
        return false;
    }

    @Override
    public VoteUser get(int id, int userId) {
        return null;
    }

    @Override
    public List<VoteUser> getAll(int userId) {
        return jdbcTemplate.query(
                "SELECT * FROM vote_users WHERE user_id=? ORDER BY date_vote DESC", ROW_MAPPER, userId);
    }
}
