package com.nhlstenden.hospital;

import java.util.ArrayList;
import java.util.List;

public class Bed
{
    private Patient patient;
    private List<Device> devices;

    public Bed()
    {
        this.devices = new ArrayList<>();
    }


    public Patient getPatient()
    {
        return this.patient;
    }

    public void setPatient(Patient patient)
    {
        this.patient = patient;
    }

    public List<Device> getDevices()
    {
        return this.devices;
    }

    public void setDevices(List<Device> devices)
    {
        if (devices == null || devices.isEmpty())
        {
            throw new IllegalArgumentException("devices cannot be null or empty");
        }

        for (Device device : devices)
        {
            if (device == null)
            {
                throw new IllegalArgumentException("devices cannot be null");
            }
        }

        this.devices = new ArrayList<>(devices);
    }

    public void addDevice(Device device)
    {
        devices.add(device);
    }
}
