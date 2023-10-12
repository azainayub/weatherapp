package com.azain.weatherapp.geolocation;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

public class CurrentLocation {
    File database;
    DatabaseReader dbReader;
    LocationInfo locationInfo;

    public CurrentLocation() throws IOException
    {
        database = new File("src\\main\\resources\\GeoLite2-City.mmdb");
        dbReader = new DatabaseReader.Builder(database).build();
    }

    public String getCityName()
            throws IOException, GeoIp2Exception {
        String ip = LocationInfo.getIp();

        InetAddress ipAddress = InetAddress.getByName(ip);
        CityResponse response = dbReader.city(ipAddress);

        return response.getCity().getName();
    }
}
