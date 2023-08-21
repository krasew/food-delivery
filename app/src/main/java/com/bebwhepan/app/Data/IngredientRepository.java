package com.bebwhepan.app.Data;

// import java.util.Optional;
import com.bebwhepan.app.Models.Taco.IngredientTaco;
//import org.springframework.data.repository.CrudRepository;

// public interface IngredientRepository extends Repository<IngredientTaco, String>{
    
//     Iterable<IngredientTaco> findAll();

//     Optional<IngredientTaco> findById(String id);

//     IngredientTaco save(IngredientTaco ingredient);

// }

public interface IngredientRepository extends CrudRepository<IngredientTaco, String> {

}
