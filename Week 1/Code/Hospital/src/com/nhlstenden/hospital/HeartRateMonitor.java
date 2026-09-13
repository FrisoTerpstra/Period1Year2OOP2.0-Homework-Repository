package com.nhlstenden.hospital;

public class HeartRateMonitor extends Device
{
    public HeartRateMonitor(int serialNumber, int energyConsumption)
    {
        super(serialNumber, energyConsumption);
    }

    @Override
    public String getStatus(Patient patient)
    {
        String sex = patient.getSex();
        int heartrate = patient.getHeartRate();

        if (sex.equals("man"))
        {
            if (heartrate >= 60 && heartrate <= 75)
            {
                return "Normal";
            }
            else
                if (heartrate > 75 && heartrate <= 100)
                {
                    return "Warning";
                }
                else
                {
                    return "Critical";
                }
        }
        else
        {
            if (heartrate >= 70 && heartrate <= 80)
            {
                return "Normal";
            }
            else if (heartrate > 80 && heartrate <= 110)
            {
                return "Warning";
            }
            else
            {
                return "Critical";
            }
        }
    }
}
