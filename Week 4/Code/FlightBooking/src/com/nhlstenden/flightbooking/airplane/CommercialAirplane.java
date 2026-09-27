package com.nhlstenden.flightbooking.airplane;

import com.nhlstenden.flightbooking.exceptions.CustomException;
import com.nhlstenden.flightbooking.flight.Flight;
import com.nhlstenden.flightbooking.person.Person;

public class CommercialAirplane extends Airplane
{
    private int economySeats;
    private int businessSeats;
    private int economySeatsTaken;
    private int businessSeatsTaken;

    public CommercialAirplane(int economySeats, int businessSeats, String code, double fuelLevelInLiters)
    {
        super(code, fuelLevelInLiters);

        this.setEconomySeats(economySeats);
        this.setBusinessSeats(businessSeats);

        this.economySeatsTaken = 0;
        this.businessSeatsTaken = 0;
    }

    public int getEconomySeats()
    {
        return this.economySeats;
    }

    public void setEconomySeats(int economySeats)
    {
        if (economySeats < 0)
        {
            throw new IllegalArgumentException("economy seats can not be negative");
        }

        this.economySeats = economySeats;
    }

    public int getBusinessSeats()
    {
        return this.businessSeats;
    }

    public void setBusinessSeats(int businessSeats)
    {
        if (businessSeats < 0)
        {
            throw new IllegalArgumentException("business seats can not be negative");
        }

        this.businessSeats = businessSeats;
    }

    public int getEconomySeatsTaken()
    {
        return this.economySeatsTaken;
    }

    public void setEconomySeatsTaken(int economySeatsTaken)
    {
        if (economySeatsTaken < 0)
        {
            throw new IllegalArgumentException("economy seats can not be negative");
        }

        this.economySeatsTaken = economySeatsTaken;
    }

    public int getBusinessSeatsTaken()
    {
        return this.businessSeatsTaken;
    }

    public void setBusinessSeatsTaken(int businessSeatsTaken)
    {
        if (businessSeatsTaken < 0)
        {
            throw new IllegalArgumentException("business seats can not be negative");
        }

        this.businessSeatsTaken = businessSeatsTaken;
    }

    @Override
    public boolean hasAvailableSeat()
    {
        return this.economySeats > this.economySeatsTaken || this.businessSeats > this.businessSeatsTaken;
    }

    @Override
    public void reserveSeat() throws CustomException
    {
        if (!this.hasAvailableSeat())
        {
            throw new CustomException("No seats available");
        }

        if (this.economySeatsTaken < this.economySeats)
        {
            this.economySeatsTaken++;
        }
        else
        {
            this.businessSeatsTaken++;
        }
    }

    @Override
    public double calculateFuelUsage(Flight flight)
    {
        return ((this.economySeats * 1.75) + (this.businessSeats * 1.98)) * flight.getDistance() + (this.economySeatsTaken * 2.02) + (this.businessSeatsTaken * 2.87) + (flight.getTotalLuggageWeight() * 0.3);
    }

    @Override
    public String getFlight24Info()
    {
        int emptySeats = (this.economySeats + this.businessSeats)
                - (this.economySeatsTaken + this.businessSeatsTaken);

        return "P: " + this.getCode()
                + ". " + this.getFuelLevelInLiters()
                + " liter fuel. " + emptySeats
                + " empty seats.";
    }

    @Override
    public boolean isLuggageAllowed(Person person)
    {
        return true;
    }
}
