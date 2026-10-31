package com.nhlstenden.nuclearpowerplant.rods;

public class SplittingResult
{
    private double residualHeat;
    private double amountOfSteamInCubicMeters;

    public SplittingResult(double residualHeat, double amountOfSteamInCubicMeters)
    {
        if (amountOfSteamInCubicMeters < 0)
        {
            throw new IllegalArgumentException("Steam cannot be negative");
        }

        this.residualHeat = residualHeat;
        this.amountOfSteamInCubicMeters = amountOfSteamInCubicMeters;
    }

    public void setResidualHeat(double residualHeat)
    {
        if (residualHeat < 0)
        {
            throw new IllegalArgumentException("residual heat can not be negative");
        }

        this.residualHeat = residualHeat;
    }

    public double getResidualHeat()
    {
        return this.residualHeat;
    }

    public double getAmountOfSteamInCubicMeters()
    {
        return this.amountOfSteamInCubicMeters;
    }
}
