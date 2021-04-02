package com.azain.weatherapp.weather.currentobservation;


public class Astronomy
{
    private String sunrise;
    private String sunset;

    public Astronomy()
    {}

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunrise() {
        return sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    @Override
    public String toString() {
        return "Astronomy{" +
                "sunrise='" + sunrise + '\'' +
                ", sunset='" + sunset + '\'' +
                '}';
    }
}
