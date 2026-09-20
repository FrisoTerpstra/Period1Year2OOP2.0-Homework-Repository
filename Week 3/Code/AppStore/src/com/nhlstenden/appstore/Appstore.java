package com.nhlstenden.appstore;

import java.util.ArrayList;
import java.util.List;

public abstract class Appstore
{
    private Currency currency;
    private List<App> apps;
    private List<Purchase> purchases;

    protected static final double APPSTORE_SHARE = 0.70;

    public Appstore(Currency currency)
    {
        this.setCurrency(currency);
        this.apps = new ArrayList<>();
        this.purchases = new ArrayList<>();
    }

    public Currency getCurrency()
    {
        return this.currency;
    }

    public void setCurrency(Currency currency)
    {
        this.currency = currency;
    }

    public List<App> getApps()
    {
        return this.apps;
    }

    public void setApps(List<App> apps)
    {
        if (apps == null)
        {
            throw new IllegalArgumentException("apps cannot be null");
        }

        for (App app : apps)
        {
            if (app == null)
            {
                throw new IllegalArgumentException("apps cannot be null");
            }
        }

        this.apps = new java.util.ArrayList<>(apps);
    }

    public List<Purchase> getPurchases()
    {
        return this.purchases;
    }

    public void setPurchases(List<Purchase> purchases)
    {
        if (purchases == null)
        {
            throw new IllegalArgumentException("purchases cannot be null");
        }

        for (Purchase purchase : purchases)
        {
            if (purchase == null)
            {
                throw new IllegalArgumentException("purchases cannot be null");
            }
        }

        this.purchases = new java.util.ArrayList<>(purchases);
    }

    public void uploadApp(App app)
    {
        if (app == null)
        {
            throw new IllegalArgumentException("app cannot be null");
        }

        this.apps.add(app);
    }
    public void purchaseApp(App app, User user) throws DownloadNotAllowedException
    {
        if (!this.apps.contains(app))
        {
            throw new DownloadNotAllowedException("App is not available in this store");
        }

        if (app.containsViolence() && user.getAge() < 16)
        {
            throw new DownloadNotAllowedException("User must be at least 16 years old");
        }

        if (app.containsNudity() && user.getAge() < 18)
        {
            throw new DownloadNotAllowedException("User must be at least 18 years old");
        }

        Purchase purchase = new Purchase(user, app);
        this.purchases.add(purchase);
    }

    public double calculateTotalRevenue()
    {
        double total = 0;

        for (Purchase purchase : this.purchases)
        {
            total += purchase.getApp().getPrice();
        }

        return total;
    }

    public double calculateRevenue(App app)
    {
        double total = 0;

        for (Purchase purchase : this.purchases)
        {
            if (purchase.getApp().equals(app))
            {
                total += purchase.getApp().getPrice();
            }
        }
        return total;
    }
}
