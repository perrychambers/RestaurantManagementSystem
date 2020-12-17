package com.perrychambers.rms.Recipe;

import com.perrychambers.rms.Recipe.Recipe;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/recipe")
public class RecipeMicroservice {

    ArrayList<Recipe> menu = new ArrayList<>();

    @GetMapping("/menu")
    public ArrayList<Recipe> getMenu() {
        // Ideally this would fetch from a database for persistent storage.
        return menu;
    }

    @PostMapping(value = "/new", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String addToMenu(@RequestBody Recipe recipe) {
        /*
        If I had more time to work on this project I would have implemented a factory
        design pattern to be called here.
         */
        recipe.setId(menu.size());
        menu.add(recipe);   // in actual scenario would use a database
        System.out.println("Added item to menu.");
        return "Added " + recipe.getName() + " to the menu.";
    }

    @DeleteMapping(value = "/delete")
    @ResponseBody
    public String deleteRecipe(@RequestParam("id") String id) {
        int recipeId = Integer.parseInt(id);
        System.out.println(recipeId);
        menu.remove(recipeId);
        return "Removed recipe with ID: " + recipeId;
    }

    @PutMapping(value = "/update")
    @ResponseBody
    public String updateRecipe(@RequestParam("id") String id, @RequestBody Recipe recipe) {
        int lookupID = Integer.parseInt(id);
        Recipe newRecipe = recipe;
        newRecipe.setId(lookupID);

        for (Recipe r : menu) {
            if (r.getId() == lookupID) {
                r.setName(newRecipe.getName());
                r.setCalories(newRecipe.getCalories());
            }
        }

        return "Updated recipe to " + newRecipe.toString();
    }
}