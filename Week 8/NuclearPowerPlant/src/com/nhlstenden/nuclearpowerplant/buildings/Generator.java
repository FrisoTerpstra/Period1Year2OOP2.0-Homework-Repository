package com.nhlstenden.nuclearpowerplant.buildings;

public class Generator implements Monitorable
{
    private double totalEnergy;

    private static final double KWH_TO_ENERGY_MULTI = 8.0;
    private static final double MAX_KWH_FOR_STABLE = 560;

    public Generator()
    {
        this.totalEnergy = 0;
    }

    public double getTotalEnergy()
    {
        return this.totalEnergy;
    }

    public double generateEnergy(double steam)
    {
        double energy = steam * KWH_TO_ENERGY_MULTI;

        this.totalEnergy += energy;

        return energy;
    }

    @Override
    public Status getStatus()
    {
        if (this.totalEnergy > MAX_KWH_FOR_STABLE)
        {
            return Status.UNSTABLE;
        }

        return Status.STABLE;
    }
}
