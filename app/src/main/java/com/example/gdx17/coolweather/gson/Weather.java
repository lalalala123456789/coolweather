package com.example.gdx17.coolweather.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by gdx17 on 2022/5/26.
 */

public class Weather {
    public String status;
    public Basic basic;
    public AQI aqi;
    public Suggestion suggestion;
    public Now now;

    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;
}
