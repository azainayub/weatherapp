package com.azain.weatherapp.weatherdata;

import com.azain.weatherapp.weather.Weather;
import com.azain.weatherapp.weatherdata.utils.JSONParser;

import java.io.IOException;

public class WeatherData
{
    private Weather weather;
    private JSONParser jsonParser;

    public WeatherData(String location) throws IOException, InterruptedException {
        jsonParser = new JSONParser(location);
        weather = jsonParser.getWeather();
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "weather=" + weather +
                '}';
    }
}
