package com.azain.weatherapp.weather;

import com.azain.weatherapp.weather.utils.JSONParser;

import java.io.IOException;

public class WeatherService
{
    private Weather weather;
    private JSONParser jsonParser;

    public WeatherService(String location) throws IOException, InterruptedException {
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
        return "WeatherService{" +
                "weather=" + weather +
                '}';
    }
}
