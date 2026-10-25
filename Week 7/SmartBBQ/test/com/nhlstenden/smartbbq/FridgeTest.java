package com.nhlstenden.smartbbq;

import com.nhlstenden.smartbbq.Bbq.Fridge;
import com.nhlstenden.smartbbq.Exceptions.FridgeIsEmptyException;
import com.nhlstenden.smartbbq.Exceptions.NoMoreFoodException;
import com.nhlstenden.smartbbq.Veggies.Corn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FridgeTest
{

    @Test
    void testGetNextMeat_addHamburger_getHamburger() throws NoMoreFoodException, FridgeIsEmptyException
    {
        Fridge fridge = new Fridge();
        Hamburger hamburger = new Hamburger();

        fridge.addFood(hamburger);

        assertEquals(fridge.getNextMeat(), hamburger);
    }

    @Test
    void testGetNextMeat_addHamburgerCheckRemove_shouldRemoveFromSet() throws NoMoreFoodException, FridgeIsEmptyException
    {
        Fridge fridge = new Fridge();
        Hamburger hamburger = new Hamburger();

        fridge.addFood(hamburger);

        fridge.getNextMeat();

        assertFalse(fridge.getFoodInFridge().contains(hamburger));
    }

    @Test
    void testGetNextMeat_tryToGetVegetableButNoVegetable_throwsNoMoreFoodException() throws NoMoreFoodException, FridgeIsEmptyException
    {
        Fridge fridge = new Fridge();
        Corn corn = new Corn();

        fridge.addFood(corn);

        assertThrows(NoMoreFoodException.class, () ->
        {
            fridge.getNextMeat();
        });
    }
}