package com.nhlstenden.nuclearpowerplant.rods;

import com.nhlstenden.nuclearpowerplant.exception.MeltdownException;

public class Nhlium extends SplittingRod
{
    private static final int MAX_TIME = 60;
    private static final int MAX_TEMP = 100;
    private static final double MIN_SPLITTING_LEFT = 0.1;
    private static final double DECREASE_MULTI = 0.06;
    private static final int TEMP_MAX_FOR_STEAM_AND_HEAT_CALC = 90;
    private static final int STEAM_DIVISION_IF_UNDER_MAX = 70;
    private static final double STEAM_MULTI_IF_UNDER_MAX = 0.9;
    private static final int HEAT_MULTI_IF_UNDER_MAX = 3;

    private static final double STEAM_MULTI_IF_ELSE = 0.9;
    private static final int MATH_SQUARE_IF_ELSE = 3;
    private static final int HEAT_DIVISION_IF_ELSE = 10;

    public Nhlium()
    {
        super();
    }

    @Override
    public SplittingResult split(int timeInSeconds, double temperature) throws MeltdownException
    {
        double heat = 0;
        double steam = 0;

        if (timeInSeconds > MAX_TIME && temperature > MAX_TEMP || getSplittingLeft() < MIN_SPLITTING_LEFT) //If the rod starts at 0.12% and splitting takes it below 0.1%, my current check won't detect that until the next split call. The assignment doesn't explicitly say whether to check before or after the decrease, so I did this.
        {
            throw new MeltdownException();
        }

        if (timeInSeconds <= 0 || temperature < 0)
        {
            throw new IllegalArgumentException("time in seconds can not be negative or zero and temperature can not be negative"); //if 0.0/0.0 it gives NaN error for the else statement, so I check if it's not 0. Question: if the exam assignment does not say what to validate, like this 0 check for example, do I need to validate it? Because I did not know it gives that error.
        }

        double decrease = (DECREASE_MULTI * timeInSeconds);

        setSplittingLeft(getSplittingLeft() - decrease);

        if (temperature < TEMP_MAX_FOR_STEAM_AND_HEAT_CALC)
        {
            steam = (temperature / STEAM_DIVISION_IF_UNDER_MAX) * timeInSeconds * STEAM_MULTI_IF_UNDER_MAX;
            heat = timeInSeconds * HEAT_MULTI_IF_UNDER_MAX;
        }
        else
        {
            steam = STEAM_MULTI_IF_ELSE * ((temperature * STEAM_MULTI_IF_ELSE) / timeInSeconds) * Math.sqrt(MATH_SQUARE_IF_ELSE) * timeInSeconds;
            heat = temperature / HEAT_DIVISION_IF_ELSE;
        }

        return new SplittingResult(heat, steam);
    }
}
