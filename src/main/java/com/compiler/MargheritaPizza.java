package com.compiler;
@Factory(
        id = "Margherita",
        type = Meal.class
)
public class MargheritaPizza implements Meal{
    @Override
    public float getPrice() {
        return 0.1f;
    }
}
