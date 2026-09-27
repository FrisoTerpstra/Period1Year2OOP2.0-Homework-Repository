package com.nhlstenden.flightbooking.person;

import com.nhlstenden.flightbooking.exceptions.CustomException;

import java.util.ArrayList;
import java.util.List;

public class Person
{
    private String name;
    private List<Luggage> luggage;

    public Person(String name)
    {
        this.setName(name);
        this.luggage = new ArrayList<>();
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        if (name == null)
        {
            throw new IllegalArgumentException("name cannot be null");
        }

        this.name = name;
    }

    public List<Luggage> getLuggage()
    {
        return this.luggage;
    }

    public void setLuggage(List<Luggage> luggage)
    {
        if (luggage == null)
        {
            throw new IllegalArgumentException("luggage cannot be null");
        }

        for (Luggage luggageItem : luggage)
        {
            if (luggageItem == null)
            {
                throw new IllegalArgumentException("luggage cannot be null");
            }
        }

        this.luggage = new java.util.ArrayList<>(luggage);
    }

    public boolean hasCarryOnLuggage()
    {
        for (Luggage luggage1 : this.luggage)
        {
            if (luggage1.getLuggageType() == LuggageType.CARRY_ON)
            {
                return true;
            }
        }

        return false;
    }

    public boolean hasHoldLuggage()
    {
        for (Luggage luggage1 : this.luggage)
        {
            if (luggage1.getLuggageType() == LuggageType.HOLD)
            {
                return true;
            }
        }

        return false;
    }

    public void addLuggage(Luggage luggage) throws CustomException
    {
        if (luggage.getLuggageType() == LuggageType.CARRY_ON && hasCarryOnLuggage())
        {
            throw new CustomException("Only one carry-on is allowed");
        }

        this.luggage.add(luggage);
    }
}
