package com.azain.weatherapp.weatherdata;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.azain.weatherapp.Config;
import com.azain.weatherapp.models.Forecast;
import com.azain.weatherapp.models.Weather;

public class WeatherAPI {
    public Weather getWeatherData(String location) throws IOException, InterruptedException, IllegalArgumentException {
        Weather weather;
        final String apiKey = Config.get("OWM_API_KEY");
        final String geocodingUrl = "http://api.openweathermap.org/geo/1.0/direct";
        final String oneCallUrl = "https://api.openweathermap.org/data/3.0/onecall";

        // Get weather data from the api
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest geocodingRequest = HttpRequest.newBuilder()
                .uri(URI.create(geocodingUrl + "?q=" + location + "&limit=1&appid=" + apiKey))
                .build();

        HttpResponse<String> geocodingResponse = client.send(geocodingRequest, HttpResponse.BodyHandlers.ofString());
        
        JSONArray jsonArray = new JSONArray(geocodingResponse.body());
        JSONObject geocodingJsonObject = jsonArray.getJSONObject(0);

        HttpRequest onecallRequest = HttpRequest.newBuilder()
                .uri(URI.create(oneCallUrl + "?lat=" + geocodingJsonObject.getDouble("lat") + "&lon=" + geocodingJsonObject.getDouble("lon") + "&exclude=hourly,minutely,alerts&units=metric&appid=" + apiKey))
                .build();
        HttpResponse<String> onecallResponse = client.send(onecallRequest, HttpResponse.BodyHandlers.ofString());

        // Parse the weather data
        JSONObject weatherDataJsonObject = new JSONObject(onecallResponse.body());
        weather = new WeatherDataParser(weatherDataJsonObject, geocodingJsonObject).parseWeatherData();
        return weather;
    }

    /* 
     * public static void main(String[] args) {
        try {
            WeatherAPI weatherAPI = new WeatherAPI();
            Weather weather = weatherAPI.getWeatherData("Rawalpindi");
            System.out.println(weather.toString());

        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        JSONObject weatherDataJsonObject = new JSONObject("{\"current\":{\"sunrise\":1697068876,\"temp\":270.6,\"visibility\":10000,\"uvi\":1.29,\"pressure\":1024,\"clouds\":2,\"feels_like\":263.74,\"wind_gust\":9.1,\"dt\":1697106442,\"wind_deg\":298,\"dew_point\":252.17,\"sunset\":1697110303,\"weather\":[{\"icon\":\"01d\",\"description\":\"clear sky\",\"main\":\"Clear\",\"id\":800}],\"humidity\":19,\"wind_speed\":7.48},\"timezone\":\"Asia/Shanghai\",\"timezone_offset\":28800,\"daily\":[{\"moonset\":1697106540,\"summary\":\"There will be partly cloudy until morning, then clearing\",\"sunrise\":1697068876,\"temp\":{\"min\":264.62,\"max\":270.65,\"eve\":270.43,\"night\":267.71,\"day\":269.4,\"morn\":266.44},\"moon_phase\":0.92,\"uvi\":8.86,\"moonrise\":1697060040,\"pressure\":1027,\"clouds\":3,\"feels_like\":{\"eve\":263.86,\"night\":262.28,\"day\":262.4,\"morn\":260.92},\"wind_gust\":10.01,\"dt\":1697086800,\"pop\":0.12,\"wind_deg\":294,\"dew_point\":250.25,\"sunset\":1697110303,\"weather\":[{\"icon\":\"01d\",\"description\":\"clear sky\",\"main\":\"Clear\",\"id\":800}],\"humidity\":21,\"wind_speed\":8.31},{\"moonset\":1697194380,\"summary\":\"Expect a day of partly cloudy with clear spells\",\"sunrise\":1697155320,\"temp\":{\"min\":266.73,\"max\":273.39,\"eve\":272.09,\"night\":269.92,\"day\":272.06,\"morn\":266.89},\"moon_phase\":0.95,\"uvi\":8.45,\"moonrise\":1697149740,\"pressure\":1023,\"clouds\":24,\"feels_like\":{\"eve\":267.83,\"night\":266.36,\"day\":267.13,\"morn\":263.08},\"wind_gust\":9.62,\"dt\":1697173200,\"pop\":0.04,\"wind_deg\":251,\"dew_point\":254.19,\"sunset\":1697196628,\"weather\":[{\"icon\":\"02d\",\"description\":\"few clouds\",\"main\":\"Clouds\",\"id\":801}],\"humidity\":24,\"wind_speed\":5.73},{\"moonset\":1697282280,\"summary\":\"Expect a day of partly cloudy with rain\",\"rain\":0.13,\"sunrise\":1697241765,\"temp\":{\"min\":268.92,\"max\":275.26,\"eve\":272.31,\"night\":270.72,\"day\":274.23,\"morn\":269.07},\"moon_phase\":0.98,\"uvi\":7.59,\"moonrise\":1697239560,\"pressure\":1015,\"clouds\":71,\"feels_like\":{\"eve\":267.67,\"night\":270.72,\"day\":269.91,\"morn\":266.07},\"wind_gust\":8.42,\"dt\":1697259600,\"pop\":0.4,\"wind_deg\":242,\"dew_point\":259.68,\"sunset\":1697282954,\"weather\":[{\"icon\":\"10d\",\"description\":\"light rain\",\"main\":\"Rain\",\"id\":500}],\"humidity\":32,\"wind_speed\":6.95},{\"moonset\":1697370300,\"summary\":\"There will be partly cloudy today\",\"sunrise\":1697328210,\"temp\":{\"min\":269.44,\"max\":276.11,\"eve\":272.71,\"night\":272.38,\"day\":276.11,\"morn\":269.6},\"moon_phase\":0,\"uvi\":7.94,\"moonrise\":1697329380,\"pressure\":1009,\"clouds\":100,\"feels_like\":{\"eve\":268.18,\"night\":270.36,\"day\":270.6,\"morn\":265.4},\"wind_gust\":10.92,\"dt\":1697346000,\"pop\":0.12,\"wind_deg\":210,\"dew_point\":260.01,\"sunset\":1697369281,\"weather\":[{\"icon\":\"04d\",\"description\":\"overcast clouds\",\"main\":\"Clouds\",\"id\":804}],\"humidity\":29,\"wind_speed\":8.2},{\"moonset\":1697458440,\"summary\":\"Expect a day of partly cloudy with clear spells\",\"sunrise\":1697414655,\"temp\":{\"min\":270.52,\"max\":276.53,\"eve\":273.49,\"night\":272.99,\"day\":276.17,\"morn\":270.52},\"moon_phase\":0.05,\"uvi\":8.2,\"moonrise\":1697419380,\"pressure\":1009,\"clouds\":10,\"feels_like\":{\"eve\":268.76,\"night\":268.17,\"day\":270.54,\"morn\":265.4},\"wind_gust\":19,\"dt\":1697432400,\"pop\":0.08,\"wind_deg\":261,\"dew_point\":256.64,\"sunset\":1697455608,\"weather\":[{\"icon\":\"01d\",\"description\":\"clear sky\",\"main\":\"Clear\",\"id\":800}],\"humidity\":22,\"wind_speed\":12.39},{\"moonset\":1697546880,\"summary\":\"Expect a day of partly cloudy with clear spells\",\"sunrise\":1697501101,\"temp\":{\"min\":270.32,\"max\":275.41,\"eve\":272.69,\"night\":272.1,\"day\":275.41,\"morn\":270.32},\"moon_phase\":0.08,\"uvi\":9,\"moonrise\":1697509500,\"pressure\":1008,\"clouds\":22,\"feels_like\":{\"eve\":268.29,\"night\":268.91,\"day\":268.66,\"morn\":265.96},\"wind_gust\":12.43,\"dt\":1697518800,\"pop\":0.2,\"wind_deg\":236,\"dew_point\":256.28,\"sunset\":1697541937,\"weather\":[{\"icon\":\"02d\",\"description\":\"few clouds\",\"main\":\"Clouds\",\"id\":801}],\"humidity\":22,\"wind_speed\":11.62},{\"moonset\":1697635800,\"summary\":\"There will be partly cloudy until morning, then snow\",\"sunrise\":1697587548,\"temp\":{\"min\":265.31,\"max\":272.77,\"eve\":267.42,\"night\":265.31,\"day\":272.77,\"morn\":269.13},\"moon_phase\":0.11,\"uvi\":9,\"moonrise\":1697599800,\"pressure\":1007,\"clouds\":100,\"feels_like\":{\"eve\":261.3,\"night\":258.31,\"day\":266.45,\"morn\":264.15},\"wind_gust\":15.23,\"dt\":1697605200,\"pop\":1,\"wind_deg\":28,\"dew_point\":259.72,\"snow\":6.02,\"sunset\":1697628266,\"weather\":[{\"icon\":\"13d\",\"description\":\"snow\",\"main\":\"Snow\",\"id\":601}],\"humidity\":36,\"wind_speed\":11.31},{\"moonset\":1697725080,\"summary\":\"Expect a day of partly cloudy with snow\",\"sunrise\":1697673994,\"temp\":{\"min\":264.14,\"max\":268.5,\"eve\":267.69,\"night\":266.42,\"day\":268.5,\"morn\":264.14},\"moon_phase\":0.15,\"uvi\":9,\"moonrise\":1697690100,\"pressure\":1020,\"clouds\":100,\"feels_like\":{\"eve\":267.69,\"night\":262.56,\"day\":262.82,\"morn\":260.01},\"wind_gust\":3.7,\"dt\":1697691600,\"pop\":0.68,\"wind_deg\":306,\"dew_point\":259.32,\"snow\":0.7,\"sunset\":1697714596,\"weather\":[{\"icon\":\"13d\",\"description\":\"light snow\",\"main\":\"Snow\",\"id\":600}],\"humidity\":48,\"wind_speed\":4.43}],\"lon\":90,\"lat\":33}");
        JSONObject geocodingJsonObject = new JSONObject("{\"local_names\":{\"de\":\"Rawalpindi\",\"ps\":\"????????\",\"ru\":\"??????????\",\"kn\":\"??????????\",\"pt\":\"Rawalpindi\",\"el\":\"?α?α?π??τ?\",\"ks\":\"????????\",\"en\":\"Rawalpindi\",\"fr\":\"Rawalpindi\",\"es\":\"Rawalpindi\",\"zh\":\"?????/?????\",\"et\":\"R?walpindi\",\"eu\":\"Rawalpindi\",\"cs\":\"Rávalpindí\",\"ar\":\"????????\",\"sd\":\"????????\",\"te\":\"??????????\",\"pa\":\"?????????\",\"ug\":\"??????????\",\"uk\":\"??????????\",\"ja\":\"?????????\",\"fa\":\"????????\",\"ur\":\"????????\",\"ml\":\"??????????\"},\"country\":\"PK\",\"name\":\"Rawalpindi\",\"lon\":73.0535122,\"state\":\"Punjab\",\"lat\":33.5914237}");

    }
     */
}
