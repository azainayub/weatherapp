package com.azain.weatherapp.weathergui.pages;

import com.azain.weatherapp.location.CurrentLocation;
import com.azain.weatherapp.weather.Weather;
import com.azain.weatherapp.weatherdata.WeatherAPI;
import com.azain.weatherapp.weathergui.WeatherApplicationGUI;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.json.JSONException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Azain
 */

public class HomePage extends javax.swing.JPanel
{
    private WeatherApplicationGUI app;
    private CurrentLocation currentLocation;
    private String currentCity;
    public HomePage(WeatherApplicationGUI app)
    {
        try
        {
            this.currentLocation = new CurrentLocation();
            this.currentCity = currentLocation.getCityName();
        }
        catch (IOException | GeoIp2Exception e) {
            this.currentCity = "Unavailable!";
        }

        initComponents();
        this.app = app;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        weatherAppLogoLabel = new javax.swing.JLabel();
        centerPanel = new javax.swing.JPanel();
        currentLocationIcon = new javax.swing.JLabel();
        cityLocationIcon = new javax.swing.JLabel();
        totalTypedCharLabel = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        searchTextField = new javax.swing.JTextField();
        currentLocationButton = new javax.swing.JButton();
        focusBorder = new javax.swing.border.LineBorder(new java.awt.Color(171,71,188), 2, true);
        errorBorder = new javax.swing.border.LineBorder(new java.awt.Color(176, 0, 32), 2, true);

        setBackground(new java.awt.Color(74, 20, 140));
        setDoubleBuffered(false);
        setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        setMaximumSize(new java.awt.Dimension(400, 600));
        setMinimumSize(new java.awt.Dimension(400, 600));
        setName("Home Page"); // NOI18N
        setPreferredSize(new java.awt.Dimension(400, 600));
        setLayout(null);

        weatherAppLogoLabel.setIcon(new ImageIcon(getClass().getResource("/Logo/inner-logo.png"))); // NOI18N
        add(weatherAppLogoLabel);
        weatherAppLogoLabel.setBounds(100, 40, 200, 190);

        centerPanel.setBackground(new java.awt.Color(225, 190, 231));
        centerPanel.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        centerPanel.setMaximumSize(new java.awt.Dimension(400, 80));
        centerPanel.setMinimumSize(new java.awt.Dimension(400, 80));
        centerPanel.setPreferredSize(new java.awt.Dimension(400, 80));
        centerPanel.setLayout(null);

        cityLocationIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cityLocationIcon.setIcon(new ImageIcon(getClass().getResource("/Icons/citylocation.png"))); // NOI18N
        cityLocationIcon.setFocusTraversalPolicyProvider(true);
        centerPanel.add(cityLocationIcon);
        cityLocationIcon.setBounds(60, 20, 30, 30);

        totalTypedCharLabel.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        totalTypedCharLabel.setForeground(new java.awt.Color(186, 104, 200));
        totalTypedCharLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        totalTypedCharLabel.setText("0/20");
        centerPanel.add(totalTypedCharLabel);
        totalTypedCharLabel.setBounds(240, 20, 40, 30);

        searchButton.setBackground(new java.awt.Color(255, 255, 255));
        searchButton.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        searchButton.setForeground(new java.awt.Color(171, 71, 188));
        searchButton.setToolTipText("Click this button to get weather details for desired city!");
        searchButton.setIcon(new ImageIcon(getClass().getResource("/Icons/search.png"))); // NOI18N
        searchButton.setFocusPainted(false);
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        centerPanel.add(searchButton);
        searchButton.setBounds(290, 20, 40, 30);
        searchTextField.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        searchTextField.setForeground(new java.awt.Color(186, 104, 200));
        searchTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchTextField.setText("Type city name");
        searchTextField.setToolTipText("Type a city name then Press ENTER or click SEARCH button!");
        searchTextField.setBorder(null);
        searchTextField.setSelectedTextColor(new java.awt.Color(171, 71, 188));
        searchTextField.setSelectionColor(new java.awt.Color(243, 229, 245));
        searchTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchTextFieldFocusLost(evt);
            }
        });
        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });
        searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyTyped(evt);
            }
        });
        centerPanel.add(searchTextField);
        searchTextField.setBounds(60, 20, 230, 30);

        currentLocationIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        //If the current location is unavailable then button won't be enabled
        if(currentCity.contains("Unavailable")) {
            currentLocationIcon.setIcon(new ImageIcon(getClass().getResource("/Icons/locationdisabled.png")));
            currentLocationButton.setEnabled(false);
        }
        else {
            currentLocationIcon.setIcon(new ImageIcon(getClass().getResource("/Icons/location.png")));
            currentLocationButton.setEnabled(true);
        }
        centerPanel.add(currentLocationIcon);
        currentLocationIcon.setBounds(60, 50, 30, 30);

        currentLocationButton.setBackground(new java.awt.Color(255, 255, 255));
        currentLocationButton.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        currentLocationButton.setForeground(new java.awt.Color(171, 71, 188));
        currentLocationButton.setText("Use Current City: " + currentCity);
        currentLocationButton.setToolTipText("Click this button to get Weather Forecast for your current city: " + currentCity);
        currentLocationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentLocationButtonActionPerformed(evt);
            }
        });
        centerPanel.add(currentLocationButton);
        currentLocationButton.setBounds(60, 50, 270, 30);
        add(centerPanel);
        centerPanel.setBounds(0, 270, 400, 100);
    }

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt)
    {
        showWeather(searchTextField.getText());
    }

    private void searchTextFieldFocusGained(java.awt.event.FocusEvent evt) {
        if(searchTextField.getText().equalsIgnoreCase("Type city name"))
            searchTextField.setText("");

        updateTotalCharLabel();
        searchTextField.setBorder(focusBorder);
    }

    private void searchTextFieldFocusLost(java.awt.event.FocusEvent evt) {
        updateTotalCharLabel();
        searchTextField.setBorder(null);
    }

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        showWeather(searchTextField.getText());
    }

    private void currentLocationButtonActionPerformed(java.awt.event.ActionEvent evt) {
            showWeather(currentCity);
    }

    private void searchTextFieldKeyPressed(java.awt.event.KeyEvent evt) {
    }

    private void searchTextFieldKeyTyped(java.awt.event.KeyEvent evt) {
        updateTotalCharLabel();
        if (searchTextField.getText().length() >= 20){
            evt.consume();
            searchTextField.setBorder(errorBorder);
            totalTypedCharLabel.setForeground(new java.awt.Color(176, 0, 32));
        }
        else
            {
            searchTextField.setBorder(focusBorder);
            totalTypedCharLabel.setForeground(new java.awt.Color(186, 104, 200));
        }
    }

    private void showWeather(String location)
    {

        ImageIcon errorIcon = null;
        String errorMessage = null;
        String loadingMessage= null;

        app.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try
        {
            loadingMessage = "Loading weather data for " + location + "...";
            app.changeCurrentPage(new LoadingPage(loadingMessage), true);
            if(location.length() < 2)
            {
                errorIcon = new ImageIcon(getClass().getResource("/Icons/searchoff.png"));
                errorMessage = "Can't search, you have not entered any city name!";
            }
            else {
                WeatherAPI weatherAPI = new WeatherAPI();
                weather = weatherAPI.getWeatherData(location);
            }
        }

        catch (JSONException | IllegalArgumentException e)
        {
            errorIcon = new ImageIcon(getClass().getResource("/Icons/wronglocation.png"));
            errorMessage = location + " isn't a valid city name!";
        }

        catch (IOException | InterruptedException e)
        {
            errorIcon = new ImageIcon(getClass().getResource("/Icons/loadingfailed.png"));
            errorMessage = "Unable to load weather data!";
        }

        //If an error occurs while loading weather then error page will be shown
        if(errorIcon != null)
        {
            app.changeCurrentPage(new ErrorPage(errorMessage, errorIcon , app), false);
        }

        //If there is no error and weather data is loaded then weather data will be shown
        else
        {
            TimerTask task = new TimerTask() {
                public void run() {
                    app.changeCurrentPage(new WeatherPage(app, weather), false);
                }
            };
            Timer timer = new Timer("Timer");

            long delay = 10L;
            timer.schedule(task, delay);
        }

        app.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    private void updateTotalCharLabel()
    {
        int totalChar = searchTextField.getText().length();
        totalTypedCharLabel.setText(totalChar + "/20");
    }

    private Weather weather;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JLabel cityLocationIcon;
    private javax.swing.JLabel currentLocationIcon;
    private javax.swing.JButton currentLocationButton;
    private javax.swing.JButton searchButton;
    private javax.swing.border.LineBorder focusBorder;
    private javax.swing.border.LineBorder errorBorder;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JLabel totalTypedCharLabel;
    private javax.swing.JLabel weatherAppLogoLabel;
}
