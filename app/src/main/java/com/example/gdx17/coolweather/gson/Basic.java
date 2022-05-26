package com.example.gdx17.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gdx17 on 2022/5/26.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;
    @SerializedName("id")
    public int weatherId;
    public Update update;
    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }
}
