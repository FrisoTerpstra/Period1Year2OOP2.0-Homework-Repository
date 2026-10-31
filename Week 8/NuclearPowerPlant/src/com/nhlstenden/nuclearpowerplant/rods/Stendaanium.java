package com.nhlstenden.nuclearpowerplant.rods;

import com.nhlstenden.nuclearpowerplant.exception.MeltdownException;

public class Stendaanium extends SplittingRod
{
    private static final int MAX_TEMPERATURE = 150;
    private static final int MIN_TEMPERATURE_FOR_DECREASE = 50;
    private static final double DECREASE_MULTI_TEMP = 0.00007;
    private static final double DECREASE_MULTI_TIME = 0.0004;
    private static final int STEAM_MULTI = 50;
    private static final double HEAT_TIME_DIVIDE = 0.5;
    private static final double HEAT_MULTI = 20;

    public Stendaanium()
    {
        super();
    }

    @Override
    public SplittingResult split(int timeInSeconds, double temperature) throws MeltdownException
    {
        double heat = 0;
        double steam = 0;

        if (temperature > MAX_TEMPERATURE)
        {
            throw new MeltdownException();
        }

        if (!(temperature < MIN_TEMPERATURE_FOR_DECREASE))
        {
            double decrease = DECREASE_MULTI_TEMP * temperature * timeInSeconds + DECREASE_MULTI_TIME;
            setSplittingLeft(getSplittingLeft() - decrease);
        }

        steam = STEAM_MULTI * temperature;

        heat = (timeInSeconds / HEAT_TIME_DIVIDE) * HEAT_MULTI;

        return new SplittingResult(heat, steam);
    }
}
