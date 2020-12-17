package com.perrychambers.rms.Recipe;

import java.util.ArrayList;

public class Recipe {
    ArrayList<String> ingredients = new ArrayList<String>();
    private String name;
    private int id;
    private int calories;
    private double price;

    public Recipe(String name, int calories, int id, double price) {
        this.name = name;
        this.calories = calories;
        this.id = id;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void addIngredients(ArrayList<String> ingredients) {
        for (String i : ingredients) {
            ingredients.add(i);
        }
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "ID: " + this.getId() + ", Name: " + this.getName() + " ,Calories: " + this.getCalories() + " .";
    }

}
