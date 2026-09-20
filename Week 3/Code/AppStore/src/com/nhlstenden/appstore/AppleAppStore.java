package com.nhlstenden.appstore;

public class AppleAppStore extends Appstore
{
    public AppleAppStore(Currency currency)
    {
        super(currency);
    }

    @Override
    public void uploadApp(App app)
    {
        if (app.containsNudity())
        {
            return;
        }

        super.uploadApp(app);
    }

    @Override
    public double calculateTotalRevenue()
    {
        return super.calculateTotalRevenue() * APPSTORE_SHARE;
    }

    @Override
    public double calculateRevenue(App app)
    {
        return super.calculateRevenue(app) * APPSTORE_SHARE;
    }
}
