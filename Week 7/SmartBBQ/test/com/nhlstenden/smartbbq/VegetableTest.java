package com.nhlstenden.smartbbq;

import com.nhlstenden.smartbbq.Veggies.Corn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VegetableTest
{

    @Test
    void testGrill_grillTwiceCheckMoist_moistLessAfterGrilling()
    {
        Corn corn = new Corn();

        double moistBeforeGrill = corn.getMoistPercentage();

        corn.grill(100);
        corn.grill(100);

        System.out.println(corn.getMoistPercentage());

        assertTrue(corn.getMoistPercentage() < moistBeforeGrill);
    }

    @Test
    void testGrill_temperatureIncreasesByHalfDegree_shouldBeIncreasedAfterGrilling()
    {
        Corn corn = new Corn();

        double temperatureBeforeGrill = corn.getCurrentTemperature();

        corn.grill(180);

        System.out.println(corn.getCurrentTemperature());

        assertEquals(temperatureBeforeGrill + 0.5, corn.getCurrentTemperature());
    }

    @Test
    void testGrill_moistPercentageNotBelowZero_shouldBeCappedAtZero()
    {
        Corn corn = new Corn();

        corn.setMoistPercentage(4);

        corn.grill(100); // Corn moister decreaser per second (per grill) is 0.05 so after grilling for 1 sec on 100 degrees, the moist percentage goes down by 5, 5-4 = -1 and gets set back to 0;

        System.out.println(corn.getMoistPercentage());

        assertEquals(0, corn.getMoistPercentage());
    }
}