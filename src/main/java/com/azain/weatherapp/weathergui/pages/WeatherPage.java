package com.azain.weatherapp.weathergui.pages;

import com.azain.weatherapp.weather.CurrentObservation;
import com.azain.weatherapp.weather.*;
import com.azain.weatherapp.weather.currentobservation.*;
import com.azain.weatherapp.weathergui.WeatherApplicationGUI;

import java.util.LinkedList;

import javax.swing.*;

/**
 *
 * @author Azain
 */

public class WeatherPage extends javax.swing.JPanel
{


    private WeatherApplicationGUI app;
    private Weather weather;
    private CurrentObservation currentObservation;
    private LinkedList<Forecast> forecastList;
    private Location location;
    private Astronomy astronomy;
    private Atmosphere atmosphere;
    private Condition condition;
    private Wind wind;

    public WeatherPage(WeatherApplicationGUI app, Weather weather) {
        this.weather = weather;
        this.currentObservation = weather.getCurrentObservation();
        this.forecastList = weather.getForecasts();
        this.location = weather.getLocation();
        this.astronomy = currentObservation.getAstronomy();
        this.atmosphere = currentObservation.getAtmosphere();
        this.condition = currentObservation.getCondition();
        this.wind = currentObservation.getWind();
        this.app = app;
        initComponents();
    }

    private void initComponents() {

        currentConditionLabel = new javax.swing.JLabel();
        currentWindLabel = new javax.swing.JLabel();
        currentHumidityLabel = new javax.swing.JLabel();
        sunsetLabel = new javax.swing.JLabel();
        sunriseLabel = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        forecast1ConditionLabel = new javax.swing.JLabel();
        forecast1DayLabel = new javax.swing.JLabel();
        forecast1TempLabel = new javax.swing.JLabel();
        forecast2DayLabel = new javax.swing.JLabel();
        forecast2TempLabel = new javax.swing.JLabel();
        forecast2ConditionLabel = new javax.swing.JLabel();
        forecast3DayLabel = new javax.swing.JLabel();
        forecast3TempLabel = new javax.swing.JLabel();
        forecast3ConditionLabel = new javax.swing.JLabel();
        forecast4DayLabel = new javax.swing.JLabel();
        forecast4TempLabel = new javax.swing.JLabel();
        forecast4ConditionLabel = new javax.swing.JLabel();
        forecast5DayLabel = new javax.swing.JLabel();
        forecast5TempLabel = new javax.swing.JLabel();
        forecast5ConditionLabel = new javax.swing.JLabel();
        forecast6DayLabel = new javax.swing.JLabel();
        forecast6TempLabel = new javax.swing.JLabel();
        forecast6ConditionLabel = new javax.swing.JLabel();
        forecast7DayLabel = new javax.swing.JLabel();
        forecast7TempLabel = new javax.swing.JLabel();
        forecast7ConditionLabel = new javax.swing.JLabel();
        forecast8DayLabel = new javax.swing.JLabel();
        forecast8TempLabel = new javax.swing.JLabel();
        forecast8ConditionLabel = new javax.swing.JLabel();
        currentTemperatureLabel = new javax.swing.JLabel();
        currentConditionIconLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        dateLabel = new javax.swing.JLabel();
        locationNameLabel = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(74, 20, 140));
        setForeground(new java.awt.Color(255, 255, 255));
        setToolTipText("");
        setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        setMaximumSize(new java.awt.Dimension(400, 600));
        setMinimumSize(new java.awt.Dimension(400, 600));
        setName("Weather Details"); // NOI18N
        setPreferredSize(new java.awt.Dimension(400, 600));
        setLayout(null);

        currentConditionLabel.setBackground(new java.awt.Color(0, 0, 0));
        currentConditionLabel.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        currentConditionLabel.setForeground(new java.awt.Color(255, 255, 255));
        currentConditionLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        currentConditionLabel.setText(condition.getText());
        currentConditionLabel.setToolTipText("Weather in " + location.getCityName() + " is " + condition.getText());
        add(currentConditionLabel);
        currentConditionLabel.setBounds(240, 140, 90, 15);

        currentWindLabel.setBackground(new java.awt.Color(0, 0, 0));
        currentWindLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        currentWindLabel.setForeground(new java.awt.Color(255, 255, 255));
        currentWindLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Weather Icons/wind.png"))); // NOI18N
        currentWindLabel.setText("Wind: " + wind.getSpeed() + "kph");
        currentWindLabel.setToolTipText(location.getCityName() + "`s current wind speed is " + wind.getSpeed() + "kph");
        add(currentWindLabel);
        currentWindLabel.setBounds(70, 190, 130, 30);

        currentHumidityLabel.setBackground(new java.awt.Color(0, 0, 0));
        currentHumidityLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        currentHumidityLabel.setForeground(new java.awt.Color(255, 255, 255));
        currentHumidityLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Weather Icons/humidity.png"))); // NOI18N
        currentHumidityLabel.setText("Humidity: " + atmosphere.getHumidity()+ "%");
        currentHumidityLabel.setToolTipText(location.getCityName() + "`s humidity percentage is " + atmosphere.getHumidity() + "%");
        add(currentHumidityLabel);
        currentHumidityLabel.setBounds(70, 220, 130, 30);

        sunsetLabel.setBackground(new java.awt.Color(0, 0, 0));
        sunsetLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        sunsetLabel.setForeground(new java.awt.Color(255, 255, 255));
        sunsetLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        sunsetLabel.setToolTipText("Sunset time in " + location.getCityName() + " is " + astronomy.getSunset());
        sunsetLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Weather Icons/sunset.png"))); // NOI18N
        sunsetLabel.setText("Sunset: " + astronomy.getSunset());
        add(sunsetLabel);
        sunsetLabel.setBounds(200, 220, 130, 30);

        sunriseLabel.setBackground(new java.awt.Color(0, 0, 0));
        sunriseLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        sunriseLabel.setForeground(new java.awt.Color(255, 255, 255));
        sunriseLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Weather Icons/sunrise.png"))); // NOI18N
        sunriseLabel.setText("Sunrise: " + astronomy.getSunrise());
        sunriseLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        sunriseLabel.setToolTipText("Sunrise time in " + location.getCityName() + " is " + astronomy.getSunrise());
        add(sunriseLabel);
        sunriseLabel.setBounds(200, 190, 130, 30);

        jSeparator4.setBackground(new java.awt.Color(225, 190, 231));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator4.setToolTipText(null);
        add(jSeparator4);
        jSeparator4.setBounds(70, 310, 260, 10);

        jSeparator5.setBackground(new java.awt.Color(225, 190, 231));
        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator5.setToolTipText(null);
        add(jSeparator5);
        jSeparator5.setBounds(70, 370, 260, 10);

        jSeparator6.setBackground(new java.awt.Color(225, 190, 231));
        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator6.setToolTipText(null);
        add(jSeparator6);
        jSeparator6.setBounds(70, 400, 260, 10);

        jSeparator7.setBackground(new java.awt.Color(225, 190, 231));
        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator7.setToolTipText(null);
        add(jSeparator7);
        jSeparator7.setBounds(70, 340, 260, 10);

        jSeparator8.setBackground(new java.awt.Color(225, 190, 231));
        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator8.setToolTipText(null);
        add(jSeparator8);
        jSeparator8.setBounds(70, 460, 260, 10);

        jSeparator9.setBackground(new java.awt.Color(225, 190, 231));
        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator9.setToolTipText(null);
        add(jSeparator9);
        jSeparator9.setBounds(70, 430, 260, 10);

        jSeparator10.setBackground(new java.awt.Color(225, 190, 231));
        jSeparator10.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator10.setToolTipText(null);
        add(jSeparator10);
        jSeparator10.setBounds(70, 490, 260, 10);


        forecastList.removeFirst();
        Forecast forecast = forecastList.removeFirst();
        forecast1ConditionLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        forecast1ConditionLabel.setForeground(new java.awt.Color(255, 255, 255));
        forecast1ConditionLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        forecast1ConditionLabel.setText(forecast.getText());
        forecast1ConditionLabel.setToolTipText(forecast.getForecastSentence());
        forecast1ConditionLabel.setIcon(forecast.getIcon());
        add(forecast1ConditionLabel);
        forecast1ConditionLabel.setBounds(220, 290, 110, 20);

        forecast1DayLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        forecast1DayLabel.setForeground(new java.awt.Color(255, 255, 255));
        forecast1DayLabel.setToolTipText(forecast.getForecastSentence());
        forecast1DayLabel.setText(forecast.getDay());
        add(forecast1DayLabel);
        forecast1DayLabel.setBounds(70, 290, 70, 20);

        forecast1TempLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        forecast1TempLabel.setForeground(new java.awt.Color(255, 255, 255));
        forecast1TempLabel.setToolTipText(forecast.getForecastSentence());
        forecast1TempLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        forecast1TempLabel.setText(forecast.getHigh() + "°C/" + forecast.getLow()+ "°C");
        add(forecast1TempLabel);
        forecast1TempLabel.setBounds(140, 290, 80, 20);

        forecast = forecastList.removeFirst();
        forecast2DayLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        forecast2DayLabel.setForeground(new java.awt.Color(255, 255, 255));
        forecast2DayLabel.setToolTipText(forecast.getForecastSentence());
        forecast2DayLabel.setText(forecast.getDay());
        add(forecast2DayLabel);
        forecast2DayLabel.setBounds(70, 320, 70, 20);

        forecast2TempLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        forecast2TempLabel.setForeground(new java.awt.Color(255, 255, 255));
        forecast2TempLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        forecast2TempLabel.setToolTipText(forecast.getForecastSentence());
        forecast2TempLabel.setText(forecast.getHigh() + "°C/" + forecast.getLow()+ "°C");
        add(forecast2TempLabel);
        forecast2TempLabel.setBounds(140, 320, 80, 20);

        forecast2ConditionLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        forecast2ConditionLabel.setForeground(new java.awt.Color(255, 255, 255));
        forecast2ConditionLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        forecast2ConditionLabel.setToolTipText(forecast.getForecastSentence());
        forecast2ConditionLabel.setText(forecast.getText());
        forecast2ConditionLabel.setIcon(forecast.getIcon());
        add(forecast2ConditionLabel);
        forecast2ConditionLabel.setBounds(220, 320, 110, 20);

        forecast = forecastList.removeFirst();
        forecast3DayLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        forecast3DayLabel.setForeground(new java.awt.Color(255, 255, 255));
        forecast3DayLabel.setToolTipText(forecast.getForecastSentence());
        forecast3DayLabel.setText(forecast.getDay());
        add(forecast3DayLabel);
        forecast3DayLabel.setBounds(70, 350, 70, 20);

        forecast3TempLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        forecast3TempLabel.setForeground(new java.awt.Color(255, 255, 255));
        forecast3TempLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        forecast3TempLabel.setToolTipText(forecast.getForecastSentence());
        forecast3TempLabel.setText(forecast.getHigh() + "°C/" + forecast.getLow()+ "°C");
        add(forecast3TempLabel);
        forecast3TempLabel.setBounds(140, 350, 80, 20);

        forecast3ConditionLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        forecast3ConditionLabel.setForeground(new java.awt.Color(255, 255, 255));
        forecast3ConditionLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        forecast3ConditionLabel.setIcon(forecast.getIcon());
        forecast3ConditionLabel.setToolTipText(forecast.getForecastSentence());
        forecast3ConditionLabel.setText(forecast.getText());
        add(forecast3ConditionLabel);
        forecast3ConditionLabel.setBounds(220, 350, 110, 20);

        forecast = forecastList.removeFirst();
        forecast4DayLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        forecast4DayLabel.setForeground(new java.awt.Color(255, 255, 255));
        forecast4DayLabel.setText(forecast.getDay());
        forecast4DayLabel.setToolTipText(forecast.getForecastSentence());
        add(forecast4DayLabel);
        forecast4DayLabel.setBounds(70, 380, 70, 20);

        forecast4TempLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        forecast4TempLabel.setForeground(new java.awt.Color(255, 255, 255));
        forecast4TempLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        forecast4TempLabel.setText(forecast.getHigh() + "°C/" + forecast.getLow()+ "°C");
        forecast4TempLabel.setToolTipText(forecast.getForecastSentence());
        add(forecast4TempLabel);
        forecast4TempLabel.setBounds(140, 380, 80, 20);

        forecast4ConditionLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        forecast4ConditionLabel.setForeground(new java.awt.Color(255, 255, 255));
        forecast4ConditionLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        forecast4ConditionLabel.setIcon(forecast.getIcon());
        forecast4ConditionLabel.setText(forecast.getText());
        forecast4ConditionLabel.setToolTipText(forecast.getForecastSentence());
        add(forecast4ConditionLabel);
        forecast4ConditionLabel.setBounds(220, 380, 110, 20);

        forecast = forecastList.removeFirst();
        forecast5DayLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        forecast5DayLabel.setForeground(new java.awt.Color(255, 255, 255));
        forecast5DayLabel.setText(forecast.getDay());
        forecast5DayLabel.setToolTipText(forecast.getForecastSentence());
        add(forecast5DayLabel);
        forecast5DayLabel.setBounds(70, 410, 70, 20);

        forecast5TempLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        forecast5TempLabel.setForeground(new java.awt.Color(255, 255, 255));
        forecast5TempLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        forecast5TempLabel.setText(forecast.getHigh() + "°C/" + forecast.getLow()+ "°C");
        forecast5TempLabel.setToolTipText(forecast.getForecastSentence());
        add(forecast5TempLabel);
        forecast5TempLabel.setBounds(140, 410, 80, 20);

        forecast5ConditionLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        forecast5ConditionLabel.setForeground(new java.awt.Color(255, 255, 255));
        forecast5ConditionLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        forecast5ConditionLabel.setIcon(forecast.getIcon());
        forecast5ConditionLabel.setText(forecast.getText());
        forecast5ConditionLabel.setToolTipText(forecast.getForecastSentence());
        add(forecast5ConditionLabel);
        forecast5ConditionLabel.setBounds(220, 410, 110, 20);

        forecast = forecastList.removeFirst();
        forecast6DayLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        forecast6DayLabel.setForeground(new java.awt.Color(255, 255, 255));
        forecast6DayLabel.setToolTipText(forecast.getForecastSentence());
        forecast6DayLabel.setText(forecast.getDay());
        add(forecast6DayLabel);
        forecast6DayLabel.setBounds(70, 440, 70, 20);

        forecast6TempLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        forecast6TempLabel.setForeground(new java.awt.Color(255, 255, 255));
        forecast6TempLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        forecast6TempLabel.setToolTipText(forecast.getForecastSentence());
        forecast6TempLabel.setText(forecast.getHigh() + "°C/" + forecast.getLow()+ "°C");
        add(forecast6TempLabel);
        forecast6TempLabel.setBounds(140, 440, 80, 20);

        forecast6ConditionLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        forecast6ConditionLabel.setForeground(new java.awt.Color(255, 255, 255));
        forecast6ConditionLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        forecast6ConditionLabel.setIcon(forecast.getIcon());
        forecast6ConditionLabel.setToolTipText(forecast.getForecastSentence());
        forecast6ConditionLabel.setText(forecast.getText());
        add(forecast6ConditionLabel);
        forecast6ConditionLabel.setBounds(220, 440, 110, 20);

        forecast = forecastList.removeFirst();
        forecast7DayLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        forecast7DayLabel.setForeground(new java.awt.Color(255, 255, 255));
        forecast7DayLabel.setToolTipText(forecast.getForecastSentence());
        forecast7DayLabel.setText(forecast.getDay());
        add(forecast7DayLabel);
        forecast7DayLabel.setBounds(70, 470, 70, 20);

        forecast7TempLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        forecast7TempLabel.setForeground(new java.awt.Color(255, 255, 255));
        forecast7TempLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        forecast7TempLabel.setText(forecast.getHigh() + "°C/" + forecast.getLow()+ "°C");
        forecast7TempLabel.setToolTipText(forecast.getForecastSentence());
        add(forecast7TempLabel);
        forecast7TempLabel.setBounds(140, 470, 80, 20);

        forecast7ConditionLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        forecast7ConditionLabel.setForeground(new java.awt.Color(255, 255, 255));
        forecast7ConditionLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        forecast7ConditionLabel.setIcon(forecast.getIcon());
        forecast7ConditionLabel.setToolTipText(forecast.getForecastSentence());
        forecast7ConditionLabel.setText(forecast.getText());
        add(forecast7ConditionLabel);
        forecast7ConditionLabel.setBounds(220, 470, 110, 20);

        currentTemperatureLabel.setBackground(new java.awt.Color(0, 0, 0));
        currentTemperatureLabel.setFont(new java.awt.Font("Segoe UI", 0, 44)); // NOI18N
        currentTemperatureLabel.setForeground(new java.awt.Color(255, 255, 255));
        currentTemperatureLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        currentTemperatureLabel.setText(condition.getTemperature() + "° C");
        currentTemperatureLabel.setToolTipText("Current Temperature in " + location.getCityName() + " is " + condition.getTemperature() + "°C");
        add(currentTemperatureLabel);
        currentTemperatureLabel.setBounds(200, 70, 130, 100);
        currentConditionIconLabel.setIcon(condition.getIcon());
        currentConditionIconLabel.setToolTipText(condition.getText());
        add(currentConditionIconLabel);
        currentConditionIconLabel.setBounds(70, 70, 128, 128);

        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/back.png"))); // NOI18N
        backButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        backButton.setToolTipText("Press this button to go back!");
        backButton.setMaximumSize(new java.awt.Dimension(48, 24));
        backButton.setMinimumSize(new java.awt.Dimension(48, 24));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton);
        backButton.setBounds(20, 20, 40, 30);

        dateLabel.setBackground(new java.awt.Color(0, 0, 0));
        dateLabel.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(243, 229, 245));
        dateLabel.setToolTipText(currentObservation.getDate());
        dateLabel.setText(currentObservation.getDate());
        add(dateLabel);
        dateLabel.setBounds(70, 40, 270, 10);

        locationNameLabel.setBackground(new java.awt.Color(0, 0, 0));
        locationNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        locationNameLabel.setForeground(new java.awt.Color(243, 229, 245));
        locationNameLabel.setText(location.getCityName() + ", " + location.getCountry());
        locationNameLabel.setToolTipText("Weather data for " + location.getCityName() + ", " + location.getCountry());
        add(locationNameLabel);
        locationNameLabel.setBounds(70, 10, 260, 30);

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.png"))); // NOI18N
        add(backgroundLabel);
        backgroundLabel.setBounds(-240, 0, 680, 630);
    }// </editor-fold>

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        showHome();
    }

    private void showHome()
    {
        JPanel prevPage = app.getPreviousPage();
        app.changeCurrentPage(prevPage, false);
    }

    // Variables declaration - do not modify
    private javax.swing.JButton backButton;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JLabel currentConditionIconLabel;
    private javax.swing.JLabel currentConditionLabel;
    private javax.swing.JLabel currentHumidityLabel;
    private javax.swing.JLabel currentTemperatureLabel;
    private javax.swing.JLabel currentWindLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel forecast1ConditionLabel;
    private javax.swing.JLabel forecast1DayLabel;
    private javax.swing.JLabel forecast1TempLabel;
    private javax.swing.JLabel forecast2ConditionLabel;
    private javax.swing.JLabel forecast2DayLabel;
    private javax.swing.JLabel forecast2TempLabel;
    private javax.swing.JLabel forecast3ConditionLabel;
    private javax.swing.JLabel forecast3DayLabel;
    private javax.swing.JLabel forecast3TempLabel;
    private javax.swing.JLabel forecast4ConditionLabel;
    private javax.swing.JLabel forecast4DayLabel;
    private javax.swing.JLabel forecast4TempLabel;
    private javax.swing.JLabel forecast5ConditionLabel;
    private javax.swing.JLabel forecast5DayLabel;
    private javax.swing.JLabel forecast5TempLabel;
    private javax.swing.JLabel forecast6ConditionLabel;
    private javax.swing.JLabel forecast6DayLabel;
    private javax.swing.JLabel forecast6TempLabel;
    private javax.swing.JLabel forecast7ConditionLabel;
    private javax.swing.JLabel forecast7DayLabel;
    private javax.swing.JLabel forecast7TempLabel;
    private javax.swing.JLabel forecast8ConditionLabel;
    private javax.swing.JLabel forecast8DayLabel;
    private javax.swing.JLabel forecast8TempLabel;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JLabel locationNameLabel;
    private javax.swing.JLabel sunriseLabel;
    private javax.swing.JLabel sunsetLabel;
    // End of variables declaration
}
