package com.azain.weatherapp.weather;

import java.util.Objects;
import java.util.TimeZone;

public class Location
{
    private long woeid;
    private String cityName;
    private String region;
    private String country;
    private double latitude;
    private double longitude;
    private TimeZone timeZone;

    public Location()
    {

    }

    public Location(long woeid, String cityName, String region, String country, Double latitude, Double longitude, TimeZone timeZone)
    {
        this.woeid = woeid;
        this.cityName = cityName;
        this.region = region;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timeZone = timeZone;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public void setWoeid(long woeid) {
        this.woeid = woeid;
    }

    public String getRegion() {
        return region;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public String getCountry() {
        return country;
    }

    public String getCityName() {
        return cityName;
    }

    public long getWoeid() {
        return woeid;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return woeid == location.woeid &&
                Double.compare(location.latitude, latitude) == 0 &&
                Double.compare(location.longitude, longitude) == 0 &&
                Objects.equals(cityName, location.cityName) &&
                Objects.equals(region, location.region) &&
                Objects.equals(country, location.country) &&
                Objects.equals(timeZone, location.timeZone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(woeid, cityName, region, country, latitude, longitude, timeZone);
    }

    @Override
    public String toString() {
        return "Location{" +
                "woeid=" + woeid +
                ", cityName='" + cityName + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", timeZone=" + timeZone +
                '}';
    }
}
