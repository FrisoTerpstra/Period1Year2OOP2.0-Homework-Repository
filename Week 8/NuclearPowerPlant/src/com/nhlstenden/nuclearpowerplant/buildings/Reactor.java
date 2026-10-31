package com.nhlstenden.nuclearpowerplant.buildings;

import com.nhlstenden.nuclearpowerplant.rods.SplittingRod;

import java.util.HashSet;
import java.util.Set;

public class Reactor implements Monitorable
{
    private Set<SplittingRod> splittingRods;

    private static final double MIN_FOR_STABLE_STATUS = 0.2;

    public Reactor()
    {
        this.splittingRods = new HashSet<>();
    }

    public void addSplittingRod(SplittingRod rod)
    {
        this.splittingRods.add(rod);
    }

    public Set<SplittingRod> getSplittingRods()
    {
        return new HashSet<>(splittingRods);
    }

    @Override
    public Status getStatus()
    {
        for (SplittingRod splittingRod : this.splittingRods)
        {
            if (splittingRod.getSplittingLeft() <= MIN_FOR_STABLE_STATUS)
            {
                return Status.NEEDS_ATTENTION;
            }
        }

        return Status.STABLE;
    }
}
