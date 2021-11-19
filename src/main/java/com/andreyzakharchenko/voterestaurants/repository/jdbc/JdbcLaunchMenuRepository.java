package com.andreyzakharchenko.voterestaurants.repository.jdbc;

import com.andreyzakharchenko.voterestaurants.model.LaunchMenu;
import com.andreyzakharchenko.voterestaurants.model.Restaurant;
import com.andreyzakharchenko.voterestaurants.repository.LaunchMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcLaunchMenuRepository implements LaunchMenuRepository {

    private static final RowMapper<LaunchMenu> ROW_MAPPER = BeanPropertyRowMapper.newInstance(LaunchMenu.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertLaunchMenu;

    @Autowired
    public JdbcLaunchMenuRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertLaunchMenu = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("launch_menu")
                .usingGeneratedKeyColumns("id");

        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public LaunchMenu save(LaunchMenu launchMenu, int userId) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return jdbcTemplate.update("DELETE FROM launch_menu WHERE id=?", id) != 0;
    }

    @Override
    public LaunchMenu get(int id) {
        List<LaunchMenu> restaurants = jdbcTemplate.query(
                "SELECT * FROM launch_menu WHERE id = ?", ROW_MAPPER, id);
        return DataAccessUtils.singleResult(restaurants);
    }

    @Override
    public List<LaunchMenu> getAll() {
        return jdbcTemplate.query(
                "SELECT * from launch_menu", ROW_MAPPER);
    }
}
