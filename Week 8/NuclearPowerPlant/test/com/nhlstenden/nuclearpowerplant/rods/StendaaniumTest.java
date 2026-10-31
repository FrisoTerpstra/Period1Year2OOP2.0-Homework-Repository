package com.nhlstenden.nuclearpowerplant.rods;

import com.nhlstenden.nuclearpowerplant.exception.MeltdownException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StendaaniumTest // please let me know if these things are good to test, or if I should test something different or even a power plant to check more? because in the practise exam just tells me to test this class and this is the only things I can come up with for this class. Except maybe to test setter validation if it was in there was a setter. What im trying to ask is if this is good enough for the actual exam if it just asks me to test for example only this class. Thank you.
{
    private static final double DECREASE_MULTI_TEMP = 0.00007; //One more question: do I need all these constants for tests? Or do magic numbers still count for pre-calculations to assertEquals in tests?
    private static final double DECREASE_MULTI_TIME = 0.0004;
    private static final int STEAM_MULTI = 50;
    private static final double HEAT_TIME_DIVIDE = 0.5;
    private static final double HEAT_MULTI = 20;

    @Test
    void testSplit_temperatureAboveFifty_returnResultWithDecrease() throws MeltdownException
    {
        Stendaanium stendaanium = new Stendaanium();

        final double START_PERCENTAGE_LEFT = 100;
        final double TEMPERATURE = 52;
        final int TIME = 100;

        double heat = (TIME / HEAT_TIME_DIVIDE) * HEAT_MULTI;
        double steam = STEAM_MULTI * TEMPERATURE;

        SplittingResult splittingResult = stendaanium.split(TIME, TEMPERATURE);

        double decrease = DECREASE_MULTI_TEMP * TEMPERATURE * TIME + DECREASE_MULTI_TIME;
        double expectedSplittingLeft = START_PERCENTAGE_LEFT - decrease;

        // System.out.println(stendaanium.getSplittingLeft());

        assertEquals(heat, splittingResult.getResidualHeat());
        assertEquals(steam, splittingResult.getAmountOfSteamInCubicMeters());

        assertEquals(expectedSplittingLeft, stendaanium.getSplittingLeft());
    }

    @Test
    void testSplit_temperatureNormal_returnResultAndNoDecrease() throws MeltdownException
    {
        Stendaanium stendaanium = new Stendaanium();

        final double START_PERCENTAGE_LEFT = 100;
        final double TEMPERATURE = 48;
        final int TIME = 100;

        double heat = (TIME / HEAT_TIME_DIVIDE) * HEAT_MULTI;
        double steam = STEAM_MULTI * TEMPERATURE;

        SplittingResult splittingResult = stendaanium.split(TIME, TEMPERATURE);

        assertEquals(heat, splittingResult.getResidualHeat());
        assertEquals(steam, splittingResult.getAmountOfSteamInCubicMeters());

        assertEquals(START_PERCENTAGE_LEFT, stendaanium.getSplittingLeft());
    }

    @Test
    void testSplit_temperatureAboveOneFifty_throwMeltdownException() throws MeltdownException
    {
        Stendaanium stendaanium = new Stendaanium();

        final double TEMPERATURE = 151;
        final int TIME = 100;

        assertThrows(MeltdownException.class, () ->
        {
            SplittingResult splittingResult = stendaanium.split(TIME, TEMPERATURE);
        });
    }
}