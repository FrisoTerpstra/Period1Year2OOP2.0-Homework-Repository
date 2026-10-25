package com.nhlstenden.smartbbq.Bbq;

import com.nhlstenden.smartbbq.Exceptions.FridgeIsEmptyException;
import com.nhlstenden.smartbbq.Exceptions.NoMoreFoodException;
import com.nhlstenden.smartbbq.Meat.Meat;
import com.nhlstenden.smartbbq.Veggies.Vegetable;

import java.util.HashSet;
import java.util.Set;

public class Fridge
{
    private static Fridge instance;
    private Set<Food> foodInFridge;
    private int temperature;

    public Fridge()
    {
        this.foodInFridge = new HashSet<>();
        this.temperature = 8;
    }

    public static Fridge getInstance()
    {
        if (instance == null)
        {
            instance = new Fridge();
        }

        return instance;
    }

    public int getTemperature()
    {
        return this.temperature;
    }

    public void setTemperature(int temperature)
    {
        this.temperature = temperature;
    }

    public void addFood(Food food)
    {
        if (food == null)
        {
            throw new IllegalArgumentException("food cannot be null");
        }

        this.foodInFridge.add(food);
    }

    public Set<Food> getFoodInFridge()
    {
        return this.foodInFridge;
    }

    public Meat getNextMeat() throws NoMoreFoodException, FridgeIsEmptyException
    {
        if (this.foodInFridge.isEmpty())
        {
            throw new FridgeIsEmptyException();
        }

        for (Food food : this.foodInFridge)
        {
            if (food instanceof Meat)
            {
                this.foodInFridge.remove(food);
                return (Meat) food;
            }
        }

        throw new NoMoreFoodException();
    }

    public Vegetable getNextVegetable() throws NoMoreFoodException, FridgeIsEmptyException
    {
        if (this.foodInFridge.isEmpty())
        {
            throw new FridgeIsEmptyException();
        }

        for (Food food : this.foodInFridge)
        {
            if (food instanceof Vegetable)
            {
                this.foodInFridge.remove(food);
                return (Vegetable) food;
            }
        }

        throw new NoMoreFoodException();
    }
}
