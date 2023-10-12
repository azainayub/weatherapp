package com.azain.weatherapp.models.currentobservation;

import java.util.Objects;

public class Wind {
    private int chill;
    private int direction;
    private double speed;

    public Wind()
    {

    }

    public Wind(int chill, int direction, float speed)
    {
        this.chill = chill;
        this.direction = direction;
        this.speed = speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setChill(int chill) {
        this.chill = chill;
    }

    public int getChill() {
        return chill;
    }

    public double getSpeed() {
        return speed;
    }

    public int getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wind wind = (Wind) o;
        return chill == wind.chill &&
                direction == wind.direction &&
                Double.compare(wind.speed, speed) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chill, direction, speed);
    }

    @Override
    public String toString() {
        return "Wind{" +
                "chill=" + chill +
                ", direction=" + direction +
                ", speed=" + speed +
                '}';
    }
}
