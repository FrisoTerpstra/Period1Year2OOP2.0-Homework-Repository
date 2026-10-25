package com.nhlstenden.smartbbq.Meat;

public class Hamburger extends Meat
{
    public Hamburger()
    {
        super(1.0 / (100 * Math.PI), MeatType.COW, 0.06); // are there magic numbers for in the super? or is this okay?
    }
}
