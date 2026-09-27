package com.nhlstenden.flightbooking.airplane;

import com.nhlstenden.flightbooking.exceptions.CustomException;
import com.nhlstenden.flightbooking.flight.Flight;
import com.nhlstenden.flightbooking.person.Person;

public abstract class Airplane
{
    private String code;
    private double fuelLevelInLiters;

    public Airplane(String code, double fuelLevelInLiters)
    {
        this.setCode(code);
        this.setFuelLevelInLiters(fuelLevelInLiters);
    }

    public String getCode()
    {
        return this.code;
    }

    public void setCode(String code)
    {
        if (code == null)
        {
            throw new IllegalArgumentException("code cannot be null");
        }

        this.code = code;
    }

    public double getFuelLevelInLiters()
    {
        return this.fuelLevelInLiters;
    }

    public void setFuelLevelInLiters(double fuelLevelInLiters)
    {
        if (fuelLevelInLiters < 0.0)
        {
            throw new IllegalArgumentException("fuel level can not be negative");
        }

        this.fuelLevelInLiters = fuelLevelInLiters;
    }

    public abstract double calculateFuelUsage(Flight flight);

    public abstract boolean hasAvailableSeat();

    public abstract void reserveSeat() throws CustomException;

    public abstract String getFlight24Info();

    public abstract boolean isLuggageAllowed(Person person);
}
