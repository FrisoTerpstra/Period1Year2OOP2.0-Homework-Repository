package com.nhlstenden.smartbbq.Bbq;

public abstract class Food
{
    private double currentBrownPercentage;
    private double browningFactor;
    private double currentTemperature;

    private final static double INCREASE_TEMP_PER_SEC = 0.5;

    public Food(double browningFactor)
    {
        this.browningFactor = browningFactor;

        this.currentBrownPercentage = 0;
        this.currentTemperature = 0;
    }

    public double getBrowningFactor()
    {
        return this.browningFactor;
    }

    public double getCurrentTemperature()
    {
        return this.currentTemperature;
    }

    public void grill(double temperature)
    {
        this.currentTemperature += INCREASE_TEMP_PER_SEC;
    }

    protected void increaseBrowning(double temperature, double divisor)
    {
        this.currentBrownPercentage += this.browningFactor * temperature / divisor;
    }
}
