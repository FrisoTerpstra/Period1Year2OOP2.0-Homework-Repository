package com.nhlstenden.flightbooking.airplane;

import com.nhlstenden.flightbooking.exceptions.CustomException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommercialAirplaneTest
{
    @Test
    void hasAvailableSeat_enoughSeatsAvailable_ShouldReturnTrue()
    {
        CommercialAirplane airplane = new CommercialAirplane(5, 2, "KLM123", 50000);

        assertTrue(airplane.hasAvailableSeat());
    }

    @Test
    void reserveSeat_allSeatsBecomeTaken_ShouldReturnFalse() throws CustomException
    {
        CommercialAirplane airplane = new CommercialAirplane(1, 1, "KLM123", 50000);

        airplane.reserveSeat(); // economy
        airplane.reserveSeat(); // business

        assertFalse(airplane.hasAvailableSeat());
    }

    @Test
    void reserveSeat_noSeatsAvailable_ShouldThrowException() throws CustomException
    {
        CommercialAirplane airplane = new CommercialAirplane(1, 1, "KLM123", 50000);

        airplane.reserveSeat(); // economy
        airplane.reserveSeat(); // business

        assertThrows(CustomException.class, () -> {
            airplane.reserveSeat();
        });
    }
}