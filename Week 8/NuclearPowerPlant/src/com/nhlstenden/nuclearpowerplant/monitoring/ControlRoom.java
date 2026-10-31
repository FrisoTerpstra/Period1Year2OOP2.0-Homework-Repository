package com.nhlstenden.nuclearpowerplant.monitoring;

import com.nhlstenden.nuclearpowerplant.buildings.CoolingSystem;
import com.nhlstenden.nuclearpowerplant.buildings.Generator;
import com.nhlstenden.nuclearpowerplant.buildings.Reactor;
import com.nhlstenden.nuclearpowerplant.buildings.Status;

public class ControlRoom
{
    private Generator generator;
    private Reactor reactor;
    private CoolingSystem coolingSystem;

    public ControlRoom(Generator generator, Reactor reactor, CoolingSystem coolingSystem)
    {
        this.generator = generator;
        this.reactor = reactor;
        this.coolingSystem = coolingSystem;
    }

    public boolean isNuclearReactorStable()
    {
        if (!(generator.getStatus().equals(Status.STABLE)) || !(reactor.getStatus().equals(Status.STABLE)) || !(coolingSystem.getStatus().equals(Status.STABLE)))
        {
            return false;
        }

        return true;
    }
}
