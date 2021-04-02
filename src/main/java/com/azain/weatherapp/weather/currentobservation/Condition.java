package com.azain.weatherapp.weather.currentobservation;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class Condition
{
    private String text;
    private int code;
    private int temperature;
    private String IMAGE_URL;

    public Condition(){}

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCode(int code) {
        this.IMAGE_URL = "http://l.yimg.com/a/i/us/we/52/" + code  + ".gif";
        this.code = code;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    public String getIMAGE_URL() {
        return IMAGE_URL;
    }

    public void setIMAGE_URL(String IMAGE_URL) {
        this.IMAGE_URL = IMAGE_URL;
    }

    public ImageIcon getIcon()
    {
        URL url;
        ImageIcon icon;
        try
        {
            url = new URL(IMAGE_URL);
            icon = new ImageIcon(url);
        }

        //If we're not able to load image
        catch(MalformedURLException e)
        {
            icon = new ImageIcon(getClass().getResource("/Icons/broken_image_100px.png"));
        }
        return icon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Condition condition = (Condition) o;
        return code == condition.code &&
                temperature == condition.temperature &&
                Objects.equals(text, condition.text) &&
                Objects.equals(IMAGE_URL, condition.IMAGE_URL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, code, temperature, IMAGE_URL);
    }

    @Override
    public String toString() {
        return "Condition{" +
                "text='" + text + '\'' +
                ", code=" + code +
                ", temperature=" + temperature +
                ", IMAGE_URL='" + IMAGE_URL + '\'' +
                '}';
    }
}
