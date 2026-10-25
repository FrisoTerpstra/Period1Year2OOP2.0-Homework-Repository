package com.nhlstenden.smartbbq.Meat;

import com.nhlstenden.smartbbq.Bbq.Food;

public abstract class Meat extends Food
{
    private double currentCookedPercentage;
    private double cookingFactor;
    private MeatType meatType;

    private final static int MEAT_DIVISOR = 100;

    public Meat(double cookingFactor, MeatType meatType, double browningFactor)
    {
        super(browningFactor);

        this.currentCookedPercentage = 0;
        this.cookingFactor = cookingFactor;
        this.meatType = meatType;
    }

    @Override
    public String toString()
    {
        return this.meatType.toString();
    }

    public double getCurrentCookedPercentage()
    {
        return this.currentCookedPercentage;
    }

    public void setCurrentCookedPercentage(double currentCookedPercentage)
    {
        if (currentCookedPercentage < 0)
        {
            throw new IllegalArgumentException("current cooked percentage cannot be negative");
        }

        this.currentCookedPercentage = currentCookedPercentage;
    }

    public double getCookingFactor()
    {
        return this.cookingFactor;
    }

    public void setCookingFactor(double cookingFactor)
    {
        if (cookingFactor < 0)
        {
            throw new IllegalArgumentException("cooking factor can not be negative");
        }

        this.cookingFactor = cookingFactor;
    }

    public MeatType getMeatType()
    {
        return this.meatType;
    }

    public void setMeatType(MeatType meatType)
    {
        if (meatType == null)
        {
            throw new IllegalArgumentException("meat type cannot be null");
        }

        this.meatType = meatType;
    }

    @Override
    public void grill(double temperature)
    {
        super.grill(temperature);

        increaseBrowning(temperature, MEAT_DIVISOR);

        this.currentCookedPercentage += this.cookingFactor * temperature;
    }
}
