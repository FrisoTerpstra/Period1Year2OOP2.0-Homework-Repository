package com.nhlstenden.hospital;

import java.time.LocalDate;
import java.time.Period;

public class Patient
{
    private String name;
    private LocalDate dateOfBirth;
    private String sex;
    private int heartRate;
    private boolean isAbleToWalk;
    private BloodPressure bloodPressure;

    public Patient(String name, LocalDate dateOfBirth, String sex)
    {
        this.setName(name);
        this.setDateOfBirth(dateOfBirth);
        this.setSex(sex);
        this.setAbleToWalk(true);
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("name cannot be null or blank");
        }

        this.name = name;
    }

    public LocalDate getDateOfBirth()
    {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex()
    {
        return this.sex;
    }

    public void setSex(String sex)
    {
        if (sex == null || sex.isBlank() )
        {
            throw new IllegalArgumentException("sex cannot be null or blank");
        }

        if (!sex.equals("man") && !sex.equals("woman"))
        {
            throw new IllegalArgumentException("please write 'woman' or 'man'");
        }

        this.sex = sex;
    }

    public int getHeartRate()
    {
        return this.heartRate;
    }

    public void setHeartRate(int heartRate)
    {
        this.heartRate = heartRate;
    }

    public boolean isAbleToWalk()
    {
        return this.isAbleToWalk;
    }

    public void setAbleToWalk(boolean ableToWalk)
    {
        isAbleToWalk = ableToWalk;
    }

    public BloodPressure getBloodPressure()
    {
        return this.bloodPressure;
    }

    public void setBloodPressure(BloodPressure bloodpressure)
    {
        this.bloodPressure = bloodpressure;
    }

    public int getAge()
    {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
}
