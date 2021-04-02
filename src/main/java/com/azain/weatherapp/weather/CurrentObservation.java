package com.azain.weatherapp.weather;

import com.azain.weatherapp.weather.currentobservation.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class CurrentObservation
{
    private Wind wind;
    private Atmosphere atmosphere;
    private Astronomy astronomy;
    private Condition condition;
    private int pubDate;
    private SimpleDateFormat date;

    public CurrentObservation(){}

    public CurrentObservation(int pubgDate, Wind wind, Atmosphere atmosphere, Astronomy astronomy, Condition condition){
        this.astronomy = astronomy;
        this.wind = wind;
        this.atmosphere = atmosphere;
        this.condition = condition;
        this.pubDate = pubgDate;
    }

    public void setAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }

    public void setPubDate(int pubDate) {
        this.pubDate = pubDate;;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public void setAstronomy(Astronomy astronomy) {
        this.astronomy = astronomy;
    }

    public Wind getWind() {
        return wind;
    }

    public Astronomy getAstronomy() {
        return astronomy;
    }

    public Condition getCondition() {
        return condition;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public int getPubDate() {
        return pubDate;
    }

    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy h:mm a");
        Date date = new Date(TimeUnit.SECONDS.toMillis(pubDate));
        return formatter.format(date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentObservation that = (CurrentObservation) o;
        return pubDate == that.pubDate &&
                Objects.equals(wind, that.wind) &&
                Objects.equals(atmosphere, that.atmosphere) &&
                Objects.equals(astronomy, that.astronomy) &&
                Objects.equals(condition, that.condition) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wind, atmosphere, astronomy, condition, pubDate, date);
    }

    @Override
    public String toString() {
        return "CurrentObservation{" +
                "wind=" + wind +
                ", atmosphere=" + atmosphere +
                ", astronomy=" + astronomy +
                ", condition=" + condition +
                ", pubDate=" + pubDate +
                ", date=" + date +
                '}';
    }
}
