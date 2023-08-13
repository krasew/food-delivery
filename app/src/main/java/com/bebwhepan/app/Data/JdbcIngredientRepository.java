package com.bebwhepan.app.Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bebwhepan.app.Models.Taco.IngredientTaco;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {
    private JdbcTemplate jdbcTemplate;
    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<IngredientTaco> findAll() {
        return jdbcTemplate.query(
        "select id, name, type from Ingredient",
        this::mapRowToIngredient);    
    }

    @Override
    public Optional<IngredientTaco> findById(String id) {
        List<IngredientTaco> results = jdbcTemplate.query(
            "select id, name, type from Ingredient where id=?",
            this::mapRowToIngredient, id);
        return results.size() == 0 ?
            Optional.empty() :
            Optional.of(results.get(0));
    }

    @Override
    public IngredientTaco save(IngredientTaco ingredient) {
        jdbcTemplate.update(
            "insert into Ingredient (id, name, type) values (?, ?, ?)",
            ingredient.getId(),
            ingredient.getName(),
            ingredient.getType().toString());
        return ingredient;    
    }

    private IngredientTaco mapRowToIngredient(ResultSet row, int rowNum)
        throws SQLException {
            return new IngredientTaco(
                row.getString("id"),
                row.getString("name"),
                IngredientTaco.Type.valueOf(row.getString("type")));
    }
}