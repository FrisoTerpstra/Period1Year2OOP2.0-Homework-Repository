package com.nhlstenden.nuclearpowerplant.monitoring;

import com.nhlstenden.nuclearpowerplant.buildings.CoolingSystem;
import com.nhlstenden.nuclearpowerplant.buildings.Generator;
import com.nhlstenden.nuclearpowerplant.buildings.Reactor;
import com.nhlstenden.nuclearpowerplant.exception.MeltdownException;
import com.nhlstenden.nuclearpowerplant.rods.SplittingResult;
import com.nhlstenden.nuclearpowerplant.rods.SplittingRod;

public class PowerPlant
{
    private Reactor reactor;
    private Generator generator;
    private CoolingSystem coolingSystem;
    private ControlRoom controlRoom;

    public PowerPlant(Reactor reactor, Generator generator, CoolingSystem coolingSystem, ControlRoom controlRoom)
    {
        this.reactor = reactor;
        this.generator = generator;
        this.coolingSystem = coolingSystem;
        this.controlRoom = controlRoom;
    }

    public double run(double temperature, int timeInSeconds) throws MeltdownException
    {
        double totalSteam = 0;
        double totalHeat = 0;

        for (SplittingRod rod : this.reactor.getSplittingRods())
        {
            SplittingResult result = rod.split(timeInSeconds, temperature);

            totalSteam += result.getAmountOfSteamInCubicMeters();
            totalHeat += result.getResidualHeat();
        }

        double kWh = generator.generateEnergy(totalSteam);

        coolingSystem.abductResidualHeat(totalHeat);

        return kWh;
    }
}
