package com.azain.weatherapp.weatherdata.utils;

import com.azain.weatherapp.weather.*;
import com.azain.weatherapp.weather.currentobservation.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.util.LinkedList;
import java.util.TimeZone;

public class JSONParser
{
    private ResponseParser responseParser;
    private Weather weather;

    public JSONParser(String location) throws IOException, InterruptedException {
        responseParser = new ResponseParser(location);
        weather = this.jsonToWeather();
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public void setResponseParser(ResponseParser responseParser) {
        this.responseParser = responseParser;
    }


    public Weather getWeather() {
        return weather;
    }

    public ResponseParser getResponseParser() {
        return responseParser;
    }

    //Parsing JSONObjects to their corresponding objects
    private Weather jsonToWeather()
    {
        Weather weather = new Weather();
        weather.setLocation(this.jsonToLocation());
        weather.setCurrentObservation(this.jsonToCurrentObservation());
        weather.setForecasts(this.jsonToForecasts());

        return weather;
    }

    private Astronomy jsonToAstronomy()
    {
        JSONObject astronomyData = responseParser.getAstronomyJSON();
        Astronomy astronomy = new Astronomy();
        astronomy.setSunrise(astronomyData.getString("sunrise").toUpperCase());
        astronomy.setSunset(astronomyData.getString("sunset").toUpperCase());
        return astronomy;
    }

    private Atmosphere jsonToAtmosphere()
    {
        JSONObject atmosphereData = responseParser.getAtmosphereJSON();

        Atmosphere atmosphere = new Atmosphere();
        atmosphere.setHumidity((int) atmosphereData.get("humidity"));
        atmosphere.setPressure((double) atmosphereData.get("pressure"));
        atmosphere.setVisibility((double) atmosphereData.get("visibility"));

        return atmosphere;
    }

    private Condition jsonToCondition()
    {
        JSONObject conditionJSON = responseParser.getConditionJSON();

        Condition condition = new Condition();
        condition.setCode((int) conditionJSON.get("code"));
        condition.setTemperature((int) conditionJSON.get("temperature"));
        condition.setText(conditionJSON.getString("text"));

        return condition;
    }

    private Wind jsonToWind()
    {
        JSONObject windJSON = responseParser.getWindJSON();

        Wind wind = new Wind();
        wind.setChill((int) windJSON.get("chill"));
        wind.setDirection((int) windJSON.get("direction"));
        wind.setSpeed((double) windJSON.get("speed"));

        return wind;
    }

    private CurrentObservation jsonToCurrentObservation()
    {
        JSONObject currentObservationJSON = responseParser.getCurrentObservationData();
        CurrentObservation currentObservation = new CurrentObservation();
        currentObservation.setAstronomy(this.jsonToAstronomy());
        currentObservation.setWind(this.jsonToWind());
        currentObservation.setCondition(this.jsonToCondition());
        currentObservation.setAtmosphere(this.jsonToAtmosphere());
        currentObservation.setPubDate((int) currentObservationJSON.get("pubDate"));

        return currentObservation;
    }

    private Location jsonToLocation()
    {
        JSONObject locationJSON = responseParser.getLocationJSON();
        Location location = new Location();
        location.setCountry(locationJSON.getString("country"));
        location.setCityName(locationJSON.getString("city"));
        location.setLatitude((double) locationJSON.get("lat"));
        location.setLongitude((double) locationJSON.get("long"));
        location.setRegion(locationJSON.getString("region"));
        location.setTimeZone(TimeZone.getTimeZone(locationJSON.getString("timezone_id")));
        location.setWoeid((int) locationJSON.get("woeid"));
        return location;
    }

    private LinkedList<Forecast> jsonToForecasts()
    {
        JSONArray forecastsArray = responseParser.getForecastJSON();
        LinkedList<Forecast> forecasts = new LinkedList<>();

        for(int i = 0; i < forecastsArray.length(); i++)
        {
            Forecast forecast = new Forecast();
            JSONObject forecastJSON = forecastsArray.getJSONObject(i);
            forecast.setCode((int) forecastJSON.get("code"));
            forecast.setDay(forecastJSON.getString("day"));
            forecast.setHigh( (int) forecastJSON.get("high"));
            forecast.setLow((int) forecastJSON.get("low"));
            forecast.setlDate( (int) forecastJSON.get("date"));
            forecast.setText(forecastJSON.getString("text"));
            forecasts.add(forecast);
        }

        return forecasts;
    }

    @Override
    public String toString() {
        return "JSONParser{" +
                "responseParser=" + responseParser +
                ", weather=" + weather +
                '}';
    }
}
