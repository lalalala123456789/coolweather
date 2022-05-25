package com.example.gdx17.coolweather.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by gdx17 on 2022/5/24.
 */

public class HttpUtil {
    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
