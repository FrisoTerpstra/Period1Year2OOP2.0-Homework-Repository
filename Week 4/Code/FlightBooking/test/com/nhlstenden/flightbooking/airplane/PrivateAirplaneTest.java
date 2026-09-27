package com.nhlstenden.flightbooking.airplane;

import com.nhlstenden.flightbooking.exceptions.CustomException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrivateAirplaneTest
{
    @Test
    void hasAvailableSeat_enoughSeatsAvailable_ShouldReturnTrue()
    {
        PrivateAirplane airplane = new PrivateAirplane(5, "ABC123", 50000);

        assertTrue(airplane.hasAvailableSeat());
    }

    @Test
    void reserveSeat_notEnoughSeats_ShouldReserveASeat() throws CustomException
    {
        PrivateAirplane airplane = new PrivateAirplane(1, "ABC123", 50000);

        airplane.reserveSeat();

        assertFalse(airplane.hasAvailableSeat());
    }

    @Test
    void reserveSeat__ShouldThrowException() throws CustomException
    {
        PrivateAirplane airplane = new PrivateAirplane(1, "ABC123", 50000);

        airplane.reserveSeat();

        assertThrows(CustomException.class, () -> {
            airplane.reserveSeat();
        });
    }
}