/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a01;

import java.util.Comparator;

/**
 *
 * @author Aitezaz Siddiqi (A00431079)
 */
public class Food implements Comparator<Food> {

    //Variables.
    private String foodName;
    private double servingSize;

    //Constants.
    public final double SODIUM_CONTENT;
    public final double CARBS_CONTENT;

    //Comparators
    public static final Comparator<Food> BY_SODIUM_CONTENT
            = (Food one, Food other) -> {
                return one.getSodiumContent().compareTo(other.getSodiumContent());
            };

    public static final Comparator<Food> BY_CARBS_CONTENT
            = (Food one, Food other) -> {
                return one.getCarbsContent().compareTo(other.getCarbsContent());
            };

    /**
     * A Constructor of Food.
     *
     * @param name Name of the food.
     * @param serveSize Serving size of the food.
     * @param sodium Sodium content of the food.
     * @param carb Carbohydrate content of the food.
     */
    public Food(String name, double serveSize, double sodium, double carb) {
        foodName = name;
        if (serveSize > 0) {
            servingSize = serveSize;
        } else {
            throw new IllegalArgumentException("Illegal value -- Serving size: " + serveSize);
        }

        if (sodium >= 0) {
            SODIUM_CONTENT = sodium;
        } else {
            throw new IllegalArgumentException("Illegal value -- Sodium content: " + sodium);
        }

        if (carb >= 0) {
            CARBS_CONTENT = carb;
        } else {
            throw new IllegalArgumentException("Illegal value -- Carbohydrates: " + carb);
        }

    }

    /**
     * A setter to change the name of the food.
     *
     * @param foodName Name of the food.
     */
    public void setName(String foodName) {
        this.foodName = foodName;
    }

    /**
     * A getter for food name.
     *
     * @return Name of the food.
     */
    public String getName() {
        return foodName;
    }

    /**
     * A getter for the serving size of the food.
     *
     * @return Serving size of the food.
     */
    public double getServingSize() {
        return servingSize;
    }

    /**
     * A getter for sodium content of the food.
     *
     * @return Sodium content of the food.
     */
    public Double getSodiumContent() {
        return SODIUM_CONTENT;
    }

    /**
     * A getter for carbohydrate content of the food.
     *
     * @return Carbohydrate content of the food.
     */
    public Double getCarbsContent() {
        return CARBS_CONTENT;
    }

    /**
     * A compare method to compare the name of two foods.
     *
     * @param food1 First food.
     * @param food2 Second food.
     * @return Name of the food which comes first in Alphabetic order.
     */
    @Override
    public int compare(Food food1, Food food2) {
        return food1.getName().compareTo(food2.getName());
    }

}
