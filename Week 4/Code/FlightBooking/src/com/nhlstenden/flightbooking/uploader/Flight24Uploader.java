package com.nhlstenden.flightbooking.uploader;

import java.util.ArrayList;
import java.util.List;

public class Flight24Uploader
{
    private List<String> data;

    public Flight24Uploader()
    {
        this.data = new ArrayList<>();
    }

    public List<String> getData()
    {
        return this.data;
    }

    public void setData(List<String> data)
    {
        if (data == null)
        {
            throw new IllegalArgumentException("data cannot be null");
        }

        for (String dataItem : data)
        {
            if (dataItem == null)
            {
                throw new IllegalArgumentException("data cannot be null");
            }
        }

        this.data = new ArrayList<>(data);
    }

    public void uploadData(String data)
    {
        this.data.add(data);
    }
}
