package com.azain.weatherapp.models;


import java.util.LinkedList;
import java.util.Objects;

public class Weather
{
    private Location location;
    private CurrentObservation currentObservation;
    private LinkedList<Forecast> forecasts = new LinkedList<>();

    public Weather()
    {

    }

    public Weather(Location location, CurrentObservation currentObservation, LinkedList<Forecast> forecasts)
    {
        this.forecasts = forecasts;
        this.currentObservation = currentObservation;
        this.location = location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setCurrentObservation(CurrentObservation currentObservation) {
        this.currentObservation = currentObservation;
    }

    public void setForecasts(LinkedList<Forecast> forecasts) {
        this.forecasts = forecasts;
    }

    public Location getLocation() {
        return location;
    }

    public LinkedList<Forecast> getForecasts() {
        return forecasts;
    }

    public CurrentObservation getCurrentObservation() {
        return currentObservation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return Objects.equals(location, weather.location) &&
                Objects.equals(currentObservation, weather.currentObservation) &&
                Objects.equals(forecasts, weather.forecasts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, currentObservation, forecasts);
    }

    @Override
    public String toString() {
        return "Weather{" +
                "location=" + location +
                ", currentObservation=" + currentObservation +
                ", forecasts=" + forecasts +
                '}';
    }
}
