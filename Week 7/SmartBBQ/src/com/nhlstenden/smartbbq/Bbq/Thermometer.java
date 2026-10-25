package com.nhlstenden.smartbbq.Bbq;

public class Thermometer
{
    public String measure(Object object)
    {
        double temperature;

        if (object instanceof Fridge)
        {
            temperature = ((Fridge) object).getTemperature();
        }
        else
        {
            if (object instanceof SmartBBq)
            {
                temperature = ((SmartBBq) object).getTemperature();
            }
            else
            {
                if (object instanceof Food)
                {
                    temperature = ((Food) object).getCurrentTemperature();
                }
                else
                {
                    throw new IllegalArgumentException("Cannot measure this object");
                }
            }
        }

        String classification = null;

        if (temperature < 10)
        {
            classification = "cold";
        }
        else
        {
            if (temperature >= 10 && temperature <= 70)
            {
                classification = "medium";
            }
            else
            {
                if (temperature > 70)
                {
                    classification = "hot";
                }
            }
        }

        return "I measured a temperature of " + temperature + " degrees Celsius. " + "Classification: " + classification;
    }

}
