package com.azain.weatherapp.weatherdata;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONObject;

import com.azain.weatherapp.models.CurrentObservation;
import com.azain.weatherapp.models.Forecast;
import com.azain.weatherapp.models.Location;
import com.azain.weatherapp.models.Weather;
import com.azain.weatherapp.models.currentobservation.Astronomy;
import com.azain.weatherapp.models.currentobservation.Atmosphere;
import com.azain.weatherapp.models.currentobservation.Condition;
import com.azain.weatherapp.models.currentobservation.Wind;

public class WeatherDataParser {
    private JSONObject weatherDataJsonObject;
    private JSONObject geocodingJsonObject;

    public WeatherDataParser(JSONObject weatherDataJsonObject, JSONObject geocodingJsonObject) throws IOException, InterruptedException {
        this.weatherDataJsonObject = weatherDataJsonObject;
        this.geocodingJsonObject = geocodingJsonObject;
    }

    public Weather parseWeatherData() {
        if (this.weatherDataJsonObject == null) {
            return null;
        }

        Weather weather;
        CurrentObservation currentObservation = this.jsonToCurrentObservation();
        Location location = this.jsonToLocation();
        LinkedList<Forecast> forecasts = this.jsonToForecasts();

        weather = new Weather(location, currentObservation, forecasts);

        return weather;
    }

    private Astronomy jsonToAstronomy()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a");
        dateFormat.setTimeZone(TimeZone.getTimeZone(weatherDataJsonObject.getString("timezone")));

        JSONObject current = weatherDataJsonObject.getJSONObject("current");
        

        String sunrise = dateFormat.format(new Date(TimeUnit.SECONDS.toMillis(current.getInt("sunrise"))));
        String sunset = dateFormat.format(new Date(TimeUnit.SECONDS.toMillis(current.getInt("sunset"))));

        Astronomy astronomy = new Astronomy();
        astronomy.setSunrise(sunrise);
        astronomy.setSunset(sunset);

        return astronomy;
    }

    private Atmosphere jsonToAtmosphere()
    {
        JSONObject current = weatherDataJsonObject.getJSONObject("current");
        
        Atmosphere atmosphere = new Atmosphere();
        atmosphere.setHumidity(current.getInt("humidity"));
        atmosphere.setPressure(current.getInt("pressure"));
        atmosphere.setVisibility(current.getInt("visibility"));

        return atmosphere;
    }

    private Condition jsonToCondition()
    {
        JSONObject current = weatherDataJsonObject.getJSONObject("current");

        Condition condition = new Condition();
        condition.setCode(current.getJSONArray("weather").getJSONObject(0).getString("icon"));
        condition.setTemperature((int)current.getDouble("temp"));
        condition.setText(current.getJSONArray("weather").getJSONObject(0).getString("main"));

        return condition;
    }

    private Wind jsonToWind()
    {
        JSONObject current = weatherDataJsonObject.getJSONObject("current");

        Wind wind = new Wind();
        // wind.setChill((int) current.getDouble("wind_gust"));
        wind.setDirection(current.getInt("wind_deg"));
        wind.setSpeed(current.getDouble("wind_speed"));

        return wind;
    }

    private CurrentObservation jsonToCurrentObservation()
    {
        JSONObject current = weatherDataJsonObject.getJSONObject("current");

        CurrentObservation currentObservation = new CurrentObservation();
        currentObservation.setAstronomy(this.jsonToAstronomy());
        currentObservation.setWind(this.jsonToWind());
        currentObservation.setCondition(this.jsonToCondition());
        currentObservation.setAtmosphere(this.jsonToAtmosphere());
        currentObservation.setPubDate(current.getInt("dt"));

        return currentObservation;
    }

    private Location jsonToLocation()
    {
        JSONObject geocodingJsonObject = this.geocodingJsonObject;
        JSONObject weatherDataJsonObject = this.weatherDataJsonObject;

        Location location = new Location();
        location.setCountry(geocodingJsonObject.getString("country"));
        location.setCityName(geocodingJsonObject.getString("name"));
        location.setLatitude(geocodingJsonObject.getDouble("lat"));
        location.setLongitude(geocodingJsonObject.getDouble("lon"));
        location.setTimeZone(TimeZone.getTimeZone(weatherDataJsonObject.getString("timezone")));
        return location;
    }

    private LinkedList<Forecast> jsonToForecasts()
    {
        JSONArray forecastsArray = weatherDataJsonObject.getJSONArray("daily");
        LinkedList<Forecast> forecasts = new LinkedList<>();

        for(int i = 0; i < forecastsArray.length(); i++)
        {
            JSONObject forecastJsonObject = forecastsArray.getJSONObject(i);
            Forecast forecast = new Forecast();
            forecast.setCode(forecastJsonObject.getJSONArray("weather").getJSONObject(0).getString("icon"));
            forecast.setText(forecastJsonObject.getJSONArray("weather").getJSONObject(0).getString("main"));
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
            forecast.setDay(dateFormat.format(new Date(forecastJsonObject.getInt("dt") * 1000)));

            JSONObject temperatureJsonObject = forecastJsonObject.getJSONObject("temp");
            forecast.setHigh((int) temperatureJsonObject.getDouble("max"));
            forecast.setLow((int) temperatureJsonObject.getDouble("min"));
            forecast.setlDate( (int) forecastJsonObject.getInt("dt"));
            forecasts.add(forecast);
        }

        return forecasts;
    }
}
