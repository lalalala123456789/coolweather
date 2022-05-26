package com.example.gdx17.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gdx17 on 2022/5/26.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More{
        @SerializedName("txt")
        public String info;
    }
}
