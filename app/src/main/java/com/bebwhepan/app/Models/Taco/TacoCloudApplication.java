package com.bebwhepan.app.Models.Taco;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bebwhepan.app.Models.Taco.IngredientTaco.Type;
import com.bebwhepan.app.Data.IngredientRepository;

@SpringBootApplication
public class TacoCloudApplication {
    public static void main(String[] args) {
            SpringApplication.run(TacoCloudApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository repo) {
    return args -> {
      repo.deleteAll(); // TODO: Quick hack to avoid tests from stepping on each other with constraint violations
      repo.save(new IngredientTaco("FLTO", "Flour Tortilla", Type.WRAP));
      repo.save(new IngredientTaco("COTO", "Corn Tortilla", Type.WRAP));
      repo.save(new IngredientTaco("GRBF", "Ground Beef", Type.PROTEIN));
      repo.save(new IngredientTaco("CARN", "Carnitas", Type.PROTEIN));
      repo.save(new IngredientTaco("TMTO", "Diced Tomatoes", Type.VEGGIES));
      repo.save(new IngredientTaco("LETC", "Lettuce", Type.VEGGIES));
      repo.save(new IngredientTaco("CHED", "Cheddar", Type.CHEESE));
      repo.save(new IngredientTaco("JACK", "Monterrey Jack", Type.CHEESE));
      repo.save(new IngredientTaco("SLSA", "Salsa", Type.SAUCE));
      repo.save(new IngredientTaco("SRCR", "Sour Cream", Type.SAUCE));
    };
  }
}
