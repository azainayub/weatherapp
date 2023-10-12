package com.azain.weatherapp.models.currentobservation;

import java.util.Objects;

public class Atmosphere
{
    private int humidity;
    private double visibility;
    private double pressure;

    public Atmosphere()
    {}

    public Atmosphere(int humidity, int visibility, float pressure)
    {
        this.humidity = humidity;
        this.visibility = visibility;
        this.pressure = pressure;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public double getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getVisibility() {
        return visibility;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atmosphere that = (Atmosphere) o;
        return humidity == that.humidity &&
                visibility == that.visibility &&
                Double.compare(that.pressure, pressure) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(humidity, visibility, pressure);
    }

    @Override
    public String toString() {
        return "Atmosphere{" +
                "humidity=" + humidity +
                ", visibility=" + visibility +
                ", pressure=" + pressure +
                '}';
    }
}
