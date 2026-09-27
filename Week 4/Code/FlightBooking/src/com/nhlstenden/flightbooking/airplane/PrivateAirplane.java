package com.nhlstenden.flightbooking.airplane;

import com.nhlstenden.flightbooking.exceptions.CustomException;
import com.nhlstenden.flightbooking.flight.Flight;
import com.nhlstenden.flightbooking.person.Person;

public class PrivateAirplane extends Airplane
{
    private int numberOfSeats;
    private int seatsTaken;

    public PrivateAirplane(int numberOfSeats, String code, double fuelLevelInLiters)
    {
        super(code, fuelLevelInLiters);

        this.setNumberOfSeats(numberOfSeats);
        this.seatsTaken = 0;
    }

    public int getNumberOfSeats()
    {
        return this.numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats)
    {
        if (numberOfSeats < 0)
        {
            throw new IllegalArgumentException("seats can not be negative");
        }

        this.numberOfSeats = numberOfSeats;
    }

    public int getSeatsTaken()
    {
        return this.seatsTaken;
    }

    public void setSeatsTaken(int seatsTaken)
    {
        if (seatsTaken < 0)
        {
            throw new IllegalArgumentException("seats can not be negative");
        }

        this.seatsTaken = seatsTaken;
    }

    @Override
    public boolean hasAvailableSeat()
    {
        return this.seatsTaken < this.numberOfSeats;
    }

    @Override
    public void reserveSeat() throws CustomException
    {
        if (!hasAvailableSeat())
        {
            throw new CustomException("there are no seats remaining");
        }

        this.seatsTaken++;
    }

    @Override
    public double calculateFuelUsage(Flight flight)
    {
        return (this.numberOfSeats * 1.31 * flight.getDistance()) + (this.seatsTaken * 1.87) + (flight.getTotalLuggageWeight() * 0.4);
    }

    @Override
    public String getFlight24Info()
    {
        int emptySeats = this.numberOfSeats - this.seatsTaken;

        return "P: " + this.getCode()
                + ". " + this.getFuelLevelInLiters()
                + " liter fuel. " + emptySeats
                + " empty seats.";
    }

    @Override
    public boolean isLuggageAllowed(Person person)
    {
        return !person.hasHoldLuggage();
    }
}
