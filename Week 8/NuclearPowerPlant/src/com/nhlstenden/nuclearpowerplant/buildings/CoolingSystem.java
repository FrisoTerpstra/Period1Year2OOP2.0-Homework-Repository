package com.nhlstenden.nuclearpowerplant.buildings;

public class CoolingSystem implements Monitorable
{
    private double waterTemperature;
    private static final double HEAT_TEMPERATURE_MULTI = 0.40;
    private static final int MIN_TEMP_FOR_ATTENTION_STATUS = 80;
    private static final int MAX_TEMP_FOR_ATTENTION_STATUS = 90;
    private static final int MIN_TEMP_FOR_UNSTABLE_STATUS = 90;

    public CoolingSystem()
    {
        this.waterTemperature = 0;
    }

    public void setWaterTemperature(double waterTemperature)
    {
        if (waterTemperature < 0)
        {
            throw new IllegalArgumentException("water temperature cannot be negative");
        }

        this.waterTemperature = waterTemperature;
    }

    public double getWaterTemperature() //Do you get minus points for if a getter or setter is never used? is it considered dead code? Same question for an add method for a list or set.
    {
        return this.waterTemperature;
    }

    public void abductResidualHeat(double heat)
    {
        double result = heat * HEAT_TEMPERATURE_MULTI;

        setWaterTemperature(result);
    }

    @Override
    public Status getStatus()
    {
        if (waterTemperature >= MIN_TEMP_FOR_ATTENTION_STATUS && waterTemperature < MAX_TEMP_FOR_ATTENTION_STATUS)
        {
            return Status.NEEDS_ATTENTION;
        }

        if (waterTemperature >= MIN_TEMP_FOR_UNSTABLE_STATUS)
        {
            return Status.UNSTABLE;
        }

        return Status.STABLE;
    }
}
