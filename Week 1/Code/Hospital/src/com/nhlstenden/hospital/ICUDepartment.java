package com.nhlstenden.hospital;

import java.util.ArrayList;
import java.util.List;

public class ICUDepartment
{
    private List<Bed> beds;
    private String location;
    private double currentAmountOfFTE;

    public ICUDepartment()
    {
        this.beds = new ArrayList<>();
    }

    public List<Bed> getBeds()
    {
        return this.beds;
    }

    public void setBeds(List<Bed> beds)
    {
        if (beds == null || beds.isEmpty())
        {
            throw new IllegalArgumentException("beds cannot be null or empty");
        }

        for (Bed bed : beds)
        {
            if (bed == null)
            {
                throw new IllegalArgumentException("beds cannot be null");
            }
        }

        this.beds = new ArrayList<>(beds);
    }

    public String getLocation()
    {
        return this.location;
    }

    public void setLocation(String location)
    {
        if (location == null || location.isBlank())
        {
            throw new IllegalArgumentException("location cannot be null or blank");
        }

        this.location = location;
    }

    public double getCurrentAmountOfFTE()
    {
        return this.currentAmountOfFTE;
    }

    public void setCurrentAmountOfFTE(double currentAmountOfFTE)
    {
        this.currentAmountOfFTE = currentAmountOfFTE;
    }

    public void addBed(Bed bed)
    {
        beds.add(bed);
    }
}