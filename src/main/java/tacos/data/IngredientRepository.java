package tacos.data;

import tacos.Ingredient;

import java.util.Optional;


//we want the Ingredient repository to be able to do some actions.
public interface IngredientRepository {
    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);

}
