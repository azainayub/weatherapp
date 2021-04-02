package com.azain.weatherapp.weatherdata.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.net.http.HttpResponse;

public class ResponseParser
{
    private JSONObject data;
    private JSONObject locationJSON;
    private JSONObject currentObservationJSON;
    private JSONObject windJSON;
    private JSONObject atmosphereJSON;
    private JSONObject astronomyJSON;
    private JSONObject conditionJSON;
    private JSONArray forecastJSON;
    private HttpResponse<String> response;

    public ResponseParser(String location) throws IOException, InterruptedException {
        response = new Request(location).getResponse();

        data = new JSONObject(response.body());
        locationJSON = data.getJSONObject("location");
        currentObservationJSON = data.getJSONObject("current_observation");
        windJSON = currentObservationJSON.getJSONObject("wind");
        atmosphereJSON = currentObservationJSON.getJSONObject("atmosphere");
        astronomyJSON = currentObservationJSON.getJSONObject("astronomy");
        conditionJSON = currentObservationJSON.getJSONObject("condition");
        forecastJSON = data.getJSONArray("forecasts");
    }

    public JSONObject getAstronomyJSON() {
        return astronomyJSON;
    }

    public JSONObject getAtmosphereJSON() {
        return atmosphereJSON;
    }

    public JSONObject getConditionJSON() {
        return conditionJSON;
    }

    public JSONObject getData() {
        return data;
    }

    public JSONObject getWindJSON() {
        return windJSON;
    }

    public JSONArray getForecastJSON() {
        return forecastJSON;
    }

    public JSONObject getCurrentObservationData() {
        return currentObservationJSON;
    }

    public JSONObject getLocationJSON() {
        return locationJSON;
    }

    public HttpResponse<String> getResponse() {
        return response;
    }

    public void setResponse(HttpResponse<String> response) {
        this.response = response;
    }

    public void setCurrentObservationData(JSONObject currentObservationData) {
        this.currentObservationJSON = currentObservationData;
    }

    public void setWindJSON(JSONObject windJSON) {
        this.windJSON = windJSON;
    }

    public void setForecastJSON(JSONArray forecastJSON) {
        this.forecastJSON = forecastJSON;
    }

    public void setConditionJSON(JSONObject conditionJSON) {
        this.conditionJSON = conditionJSON;
    }

    public void setLocationJSON(JSONObject locationJSON) {
        this.locationJSON = locationJSON;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    public void setAtmosphereJSON(JSONObject atmosphereJSON) {
        this.atmosphereJSON = atmosphereJSON;
    }

    public void setAstronomyJSON(JSONObject astronomyJSON) {
        this.astronomyJSON = astronomyJSON;
    }

    @Override
    public String toString() {
        return "ResponseParser{" +
                "data=" + data +
                ", locationData=" + locationJSON +
                ", currentObservationData=" + currentObservationJSON +
                ", windData=" + windJSON +
                ", atmosphereData=" + atmosphereJSON +
                ", astronomyData=" + astronomyJSON +
                ", conditionData=" + conditionJSON +
                ", forecastData=" + forecastJSON +
                ", response=" + response +
                '}';
    }
}
