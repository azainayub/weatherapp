package com.azain.weatherapp.models;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Forecast
{
    private String day;
    private int lDate;
    private Date date;
    private int low;
    private int high;
    private String text;
    private String code;
    private String IMAGE_URL;

    public Forecast()
    {

    }

    public Forecast(String day, int lDate, int low, int high,
                    String text, String code)
    {
        this.code = code;
        this.high = high;
        this.lDate = lDate;
        this.low = low;
        this.high = high;
        this.text = text;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setlDate(int lDate) {
        Date date = new Date(lDate * 1000);
        this.setDate(date);
        this.lDate = lDate;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIMAGE_URL(String IMAGE_URL) {
        this.IMAGE_URL = IMAGE_URL;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public void setCode(String code) {
        String IMAGE_URL = "https://openweathermap.org/img/wn/" + code  + "@2x.png";
        this.setIMAGE_URL(IMAGE_URL);
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public String getCode() {
        return code;
    }

    public int getHigh() {
        return high;
    }

    public int getLow() {
        return low;
    }

    public String getDay() {
        return day;
    }

    public String getForecastSentence()
    {
        return "On " + day + ", weather will be " + text + " with temperature " + getHigh() +"°C High/" + low + "°C Low";
    }

    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy h:mm a");
        Date date = new Date(TimeUnit.SECONDS.toMillis(lDate));
        return formatter.format(date);
    }

    public ImageIcon getIcon()
    {
        URL url;
        ImageIcon icon;
        try
        {
            url = new URL(IMAGE_URL);
            icon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT));
        }

        catch(MalformedURLException e)
        {
            icon = new ImageIcon("C:\\Users\\Azain\\Documents\\Java-Projects\\WeatherApp\\src\\Images\\Icons\\broken_image_16px.png");
        }
        return icon;
    }

    public int getlDate() {
        return lDate;
    }

    public String getIMAGE_URL() {
        return IMAGE_URL;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "day='" + day + '\'' +
                ", lDate=" + lDate +
                ", date=" + date +
                ", low=" + low +
                ", high=" + high +
                ", text='" + text + '\'' +
                ", code=" + code +
                ", IMAGE_URL='" + IMAGE_URL + '\'' +
                '}';
    }
}
