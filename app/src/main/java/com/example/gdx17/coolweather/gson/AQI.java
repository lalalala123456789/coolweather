package com.example.gdx17.coolweather.gson;

/**
 * Created by gdx17 on 2022/5/26.
 */

public class AQI {
    public AQICity city;
    public class AQICity{
        public String aqi;
        public String pm25;
    }
}
