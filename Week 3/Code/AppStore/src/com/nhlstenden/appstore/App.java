package com.nhlstenden.appstore;

public class App
{
    private String name;
    private double price;
    private boolean containsViolence;
    private boolean containsNudity;

    public App(String name, double price, boolean containsViolence, boolean containsNudity)
    {
        this.setName(name);
        this.setPrice(price);
        this.containsViolence = containsViolence;
        this.containsNudity = containsNudity;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("name cannot be null or blank");
        }

        this.name = name;
    }

    public double getPrice()
    {
        return this.price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public boolean containsViolence()
    {
        return this.containsViolence;
    }

    public void setContainsViolence(boolean containsViolence)
    {
        this.containsViolence = containsViolence;
    }

    public boolean containsNudity()
    {
        return this.containsNudity;
    }

    public void setContainsNudity(boolean containsNudity)
    {
        this.containsNudity = containsNudity;
    }
}
