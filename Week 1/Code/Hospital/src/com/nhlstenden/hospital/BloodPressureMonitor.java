package com.nhlstenden.hospital;

public class BloodPressureMonitor extends Device
{
    public BloodPressureMonitor(int serialNumber, int energyConsumption)
    {
        super(serialNumber, energyConsumption);
    }

    @Override
    public String getStatus(Patient patient)
    {
         int systolic = patient.getBloodPressure().getSystolicBloodPressure();
         int diastolic = patient.getBloodPressure().getDiastolicBloodPressure();

         if (systolic > 180 || diastolic > 110)
         {
             return "Critical";
         }

         if (systolic > 140 || systolic < 120 || diastolic > 90 || diastolic < 80)
         {
             return "Warning";
         }
         else
         {
             return "Normal";
         }
    }
}
