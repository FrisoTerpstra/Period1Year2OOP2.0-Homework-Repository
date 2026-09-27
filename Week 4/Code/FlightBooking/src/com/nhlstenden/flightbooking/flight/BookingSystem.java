package com.nhlstenden.flightbooking.flight;

import com.nhlstenden.flightbooking.airplane.Airplane;
import com.nhlstenden.flightbooking.exceptions.CustomException;
import com.nhlstenden.flightbooking.person.Person;

import java.util.ArrayList;
import java.util.List;

public class BookingSystem
{
    private List<Flight> flights;

    public BookingSystem()
    {
        this.setFlights(new ArrayList<>());
    }

    public List<Flight> getFlights()
    {
        return this.flights;
    }

    public void setFlights(List<Flight> flights)
    {
        if (flights == null)
        {
            throw new IllegalArgumentException("flights cannot be null");
        }

        for (Flight flight : flights)
        {
            if (flight == null)
            {
                throw new IllegalArgumentException("flights cannot be null");
            }
        }

        this.flights = new ArrayList<>(flights);
    }

    public void addFlight(Flight flight)
    {
        this.flights.add(flight);
    }

    public void bookFlight(Person person, Airport departure, Airport arrival) throws CustomException
    {
        for (Flight flight : this.flights)
        {
            if (flight.getDepartureAirport() == departure
                    && flight.getArrivalAirport() == arrival
                    && flight.getStatus() != Status.DEPARTED
                    && flight.getStatus() != Status.LANDED)
            {
                Airplane airplane = flight.getAirplane();

                if (!airplane.isLuggageAllowed(person))
                {
                    continue;
                }

                if (!airplane.hasAvailableSeat())
                {
                    continue;
                }

                airplane.reserveSeat();
                flight.addPerson(person);
                return;
            }
        }

        throw new CustomException("No available flight found");
    }
}
