package com.nhlstenden.smartbbq.Bbq;

import java.util.HashSet;
import java.util.Set;

public class SmartBBq
{
    private Set<Food> food;
    private int temperature;
    private boolean isOn;

    private static final int MAX_DEGREE = 250;
    private static final int MAX_FOOD = 6;

    public SmartBBq()
    {
        this.food = new HashSet<>();
        this.temperature = 0;
        this.isOn = false;
    }

    public Set<Food> getFood()
    {
        return new HashSet<>(this.food);
    }

    public void setFood(Set<Food> food) //same as setTemp comment
    {
        if (food == null)
        {
            throw new IllegalArgumentException("Food collection cannot be null");
        }

        if (food.contains(null))
        {
            throw new IllegalArgumentException("Food collection cannot contain null");
        }

        if (food.size() > MAX_FOOD)
        {
            throw new IllegalArgumentException("Max amount of food can not be extended");
        }

        this.food = new HashSet<>(food);
    }

    public int getTemperature()
    {
        return this.temperature;
    }

    public void setTemperature(int temperature) // I know I don't need these setters, especially because we are giving the temp to the turnOn method, but im doing this for now because it's what I have been taught to do, if you read this please let me know if it's wrong for the exam, I will ask in the next code review
    {
        if (temperature < 0 || temperature > MAX_DEGREE)
        {
            throw new IllegalArgumentException("Temperature must be between 0 and 250 degrees");
        }

        this.temperature = temperature;
    }

    public boolean isOn()
    {
        return this.isOn;
    }

    public void addFood(Food food)
    {
        if (food == null)
        {
            throw new IllegalArgumentException("Food cannot be null");
        }

        if (this.food.size() >= MAX_FOOD && !this.food.contains(food))
        {
            throw new IllegalArgumentException("Max amount of food can not be extended");
        }

        this.food.add(food);
    }

    public void removeFood(Food food)
    {
        if (food == null)
        {
            throw new IllegalArgumentException("Food cannot be null");
        }

        this.food.remove(food);
    }

    public void turnOn(int temperature)
    {
        if (temperature < 1 || temperature > MAX_DEGREE)
        {
            throw new IllegalArgumentException("Temperature must be between 1 and 250");
        }

        this.temperature = temperature;
        this.isOn = true;
    }

    public void turnOff()
    {
        this.isOn = false;
    }
}
