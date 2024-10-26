package dev.taimoor_sasha.recipely;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;
    public List<Recipe> allRecipes() {
        return recipeRepository.findAll();
    }

//    public Optional<Recipe> singleRecipe(ObjectId id) {
//        return recipeRepository.findById(id);
//    }
    public Optional<Recipe> singleRecipe(String name) {
        return recipeRepository.findRecipeByName(name);
    }

    public Recipe createRecipe(String userId, String firstName, String lastName, String userPicturePath, String picturePath, String name, String description, String ingredients) {
        Recipe recipe =  recipeRepository.insert(new Recipe(userId, firstName, lastName, userPicturePath, picturePath, name, description, ingredients));
        return recipe;
    }

    public Optional<Recipe> deleteRecipe(String name) {
        Optional<Recipe> recipe = recipeRepository.deleteRecipeByName(name);
        return recipe;
    }

}