package com.azain.weatherapp.location;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class LocationInfo {
    private static final String STRING_URL = "http://checkip.amazonaws.com";

    public static String getIp() {
        BufferedReader in = null;
        URL whatismyip = null;
        String ip = null;
        try {
            whatismyip = new URL(STRING_URL);

            in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));
            ip = in.readLine();

            return ip;
        } catch (Exception ex) {
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ip;
    }
}
