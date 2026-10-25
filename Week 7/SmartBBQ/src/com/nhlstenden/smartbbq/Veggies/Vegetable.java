package com.nhlstenden.smartbbq.Veggies;

import com.nhlstenden.smartbbq.Bbq.Food;

public abstract class Vegetable extends Food
{
    private double moistPercentage;
    private double moistFactor;

    private final static int BEGIN_MOIST_PERCENTAGE = 100;
    private final static int VEGETABLE_DIVISOR = 1;

    public Vegetable(double browningFactor, double moistFactor)
    {
        super(browningFactor);

        this.moistPercentage = BEGIN_MOIST_PERCENTAGE;
        this.moistFactor = moistFactor;
    }

    public double getMoistPercentage()
    {
        return this.moistPercentage;
    }

    public void setMoistPercentage(double moistPercentage)
    {
        if (moistPercentage < 0 || moistPercentage > 100)
        {
            throw new IllegalArgumentException("moist percentage cannot be negative or above 100");
        }

        this.moistPercentage = moistPercentage;
    }

    public double getMoistFactor()
    {
        return this.moistFactor;
    }

    public void setMoistFactor(double moistFactor)
    {
        if (moistFactor < 0)
        {
            throw new IllegalArgumentException("moist factor cannot be negative");
        }

        this.moistFactor = moistFactor;
    }

    @Override
    public String toString()
    {
        return this.getClass().getSimpleName();
    }

    @Override
    public void grill(double temperature)
    {
        super.grill(temperature);

        increaseBrowning(temperature, VEGETABLE_DIVISOR);

        this.moistPercentage -= this.moistFactor * temperature;
        if (this.moistPercentage < 0)
        {
            this.moistPercentage = 0;
        }
    }
}
