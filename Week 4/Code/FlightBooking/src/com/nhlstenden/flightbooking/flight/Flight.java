package com.nhlstenden.flightbooking.flight;

import com.nhlstenden.flightbooking.airplane.Airplane;
import com.nhlstenden.flightbooking.exceptions.CustomException;
import com.nhlstenden.flightbooking.person.Luggage;
import com.nhlstenden.flightbooking.person.Person;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Flight
{
    private Airplane airplane;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private LocalDateTime departureDate;
    private Status status;
    private List<Person> people;

    public Flight(Airplane airplane, Airport departureAirport, Airport arrivalAirport, LocalDateTime departureDate, Status status)
    {
        this.setAirplane(airplane);
        this.setDepartureAirport(departureAirport);
        this.setArrivalAirport(arrivalAirport);
        this.setDepartureDate(departureDate);
        this.setStatus(status);
        this.setPeople(new ArrayList<>());
    }


    public Airplane getAirplane()
    {
        return this.airplane;
    }

    public void setAirplane(Airplane airplane)
    {
        if (airplane == null)
        {
            throw new IllegalArgumentException("airplane can not be null");
        }

        this.airplane = airplane;
    }

    public Airport getDepartureAirport()
    {
        return this.departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport)
    {
        if (departureAirport == null)
        {
            throw new IllegalArgumentException("airport can not be null");
        }

        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport()
    {
        return this.arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport)
    {
        if (arrivalAirport == null)
        {
            throw new IllegalArgumentException("airport can not be null");
        }

        this.arrivalAirport = arrivalAirport;
    }

    public LocalDateTime getDepartureDate()
    {
        return this.departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate)
    {
        if (departureDate == null)
        {
            throw new IllegalArgumentException("departure date can not be null");
        }

        this.departureDate = departureDate;
    }

    public Status getStatus()
    {
        return this.status;
    }

    public void setStatus(Status status)
    {
        if (status == null)
        {
            throw new IllegalArgumentException("status can not be null");
        }

        this.status = status;
    }

    public List<Person> getPeople()
    {
        return this.people;
    }

    public void setPeople(List<Person> people)
    {
        if (people == null)
        {
            throw new IllegalArgumentException("people cannot be null");
        }

        for (Person person : people)
        {
            if (person == null)
            {
                throw new IllegalArgumentException("people cannot be null");
            }
        }

        this.people = new ArrayList<>(people);
    }

    public void addPerson(Person person)
    {
        this.people.add(person);
    }

    public int getDistance()
    {
        if ((this.departureAirport == Airport.JFK && this.arrivalAirport == Airport.AMS) ||
                (this.departureAirport == Airport.AMS && this.arrivalAirport == Airport.JFK))
        {
            return 5848;
        }

        if ((this.departureAirport == Airport.JFK && this.arrivalAirport == Airport.MEX) ||
                (this.departureAirport == Airport.MEX && this.arrivalAirport == Airport.JFK))
        {
            return 3366;
        }

        if ((this.departureAirport == Airport.JFK && this.arrivalAirport == Airport.LAX) ||
                (this.departureAirport == Airport.LAX && this.arrivalAirport == Airport.JFK))
        {
            return 3975;
        }

        if ((this.departureAirport == Airport.AMS && this.arrivalAirport == Airport.MEX) ||
                (this.departureAirport == Airport.MEX && this.arrivalAirport == Airport.AMS))
        {
            return 9206;
        }

        if ((this.departureAirport == Airport.AMS && this.arrivalAirport == Airport.LAX) ||
                (this.departureAirport == Airport.LAX && this.arrivalAirport == Airport.AMS))
        {
            return 8956;
        }

        if ((this.departureAirport == Airport.MEX && this.arrivalAirport == Airport.LAX) ||
                (this.departureAirport == Airport.LAX && this.arrivalAirport == Airport.MEX))
        {
            return 2500;
        }

        return 0;
    }

    public double getTotalLuggageWeight()
    {
        double total = 0;

        for (Person person : this.people)
        {
            for (Luggage luggage : person.getLuggage())
            {
                total += luggage.getWeightInKg();
            }
        }

        return total;
    }

    public void depart() throws CustomException
    {
        double requiredFuel = this.airplane.calculateFuelUsage(this);

        if (this.airplane.getFuelLevelInLiters() < requiredFuel)
        {
            throw new CustomException("Not enough fuel to depart");
        }

        this.status = Status.DEPARTED;
    }

    public String getFlight24Info()
    {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"); // or grab every value by itself and split them up

        return "F: " + this.departureAirport
                + " -> " + this.arrivalAirport
                + ". Departure " + this.departureDate.format(formatter)
                + ".";
    }
}
