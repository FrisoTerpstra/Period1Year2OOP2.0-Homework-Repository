package com.nhlstenden.hospital;

public abstract class Device
{
    private int serialNumber;
    private int energyConsumption;

    public Device(int serialNumber, int energyConsumption)
    {
        this.setSerialNumber(serialNumber);
        this.setEnergyConsumption(energyConsumption);
    }

    public int getSerialNumber()
    {
        return this.serialNumber;
    }

    public void setSerialNumber(int serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    public int getEnergyConsumption()
    {
        return this.energyConsumption;
    }

    public void setEnergyConsumption(int energyConsumption)
    {
        this.energyConsumption = energyConsumption;
    }

    public abstract String getStatus(Patient patient);

}
