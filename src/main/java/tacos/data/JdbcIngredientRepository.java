package tacos.data;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tacos.Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcIngredientRepository implements IngredientRepository{


    private JdbcTemplate jdbcTemplate;
    //make a constructor to insert the JDBCTemplate dependency into this class.
    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //this method takes each row from the results and maps it to an ingredient
    private Ingredient mapRowToIngredient(ResultSet row, int rowNum) throws SQLException {
        return new Ingredient(row.getString("id"),
                row.getString("name"),
                Ingredient.Type.valueOf(row.getString("type"))
        );
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query("select id, name, type from Ingredient",
                this::mapRowToIngredient);
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        //querying for a particular ingredient
        List<Ingredient> results = jdbcTemplate.query("select id, name, type from Ingredient where id =?",
                this::mapRowToIngredient,
                id);

        //if the results are completely empty, then return an empty optional
        if(results.size()==0){
            return Optional.empty();
        }
        //else we will return an Optional with the Ingredient that we fetched
        return Optional.of(results.get(0));

    }


    //below we are adding an ew ingredient ot the data base
    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update("insert into Ingredient (id, name, type) values (?,?,?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());

        return ingredient;
    }
}
