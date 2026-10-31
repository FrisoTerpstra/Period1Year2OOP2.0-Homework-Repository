package com.nhlstenden.nuclearpowerplant.rods;

import com.nhlstenden.nuclearpowerplant.exception.MeltdownException;

public abstract class SplittingRod
{
    private double splittingLeft;

    private static final double DEFAULT_SPLITTING_LEFT = 100.0;

    public SplittingRod()
    {
        this.splittingLeft = DEFAULT_SPLITTING_LEFT;
    }

    public double getSplittingLeft()
    {
        return this.splittingLeft;
    }

    public void setSplittingLeft(double splittingLeft)
    {
        if (splittingLeft > DEFAULT_SPLITTING_LEFT || splittingLeft < 0)
        {
            throw new IllegalArgumentException("splitting rod left can not be negative or above 100 percent");
        }

        this.splittingLeft = splittingLeft;
    }

    public abstract SplittingResult split(int timeInSeconds, double temperature) throws MeltdownException;
}
