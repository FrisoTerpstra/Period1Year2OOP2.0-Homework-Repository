package com.nhlstenden.hospital;

public class BloodPressure
{
    private int diastolicBloodPressure;
    private int systolicBloodPressure;

    public BloodPressure(int diastolicBloodPressure, int systolicBloodPressure)
    {
        this.setDiastolicBloodPressure(diastolicBloodPressure);
        this.setSystolicBloodPressure(systolicBloodPressure);
    }

    public int getDiastolicBloodPressure()
    {
        return this.diastolicBloodPressure;
    }

    public void setDiastolicBloodPressure(int diastolicBloodPressure)
    {
        this.diastolicBloodPressure = diastolicBloodPressure;
    }

    public int getSystolicBloodPressure()
    {
        return this.systolicBloodPressure;
    }

    public void setSystolicBloodPressure(int systolicBloodPressure)
    {
        this.systolicBloodPressure = systolicBloodPressure;
    }
}
