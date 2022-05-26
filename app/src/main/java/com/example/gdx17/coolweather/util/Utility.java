package com.example.gdx17.coolweather.util;

import android.text.TextUtils;
import android.webkit.WebView;

import com.example.gdx17.coolweather.db.City;
import com.example.gdx17.coolweather.db.County;
import com.example.gdx17.coolweather.db.Province;
import com.example.gdx17.coolweather.gson.Weather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gdx17 on 2022/5/24.
 */

public class Utility {
//    解析和处理服务器返回的省级数据
    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allProvinces=new JSONArray(response);
                for(int i=0;i<allProvinces.length();i++){
                    JSONObject provinceObject=allProvinces.getJSONObject(i);
                    Province province=new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            }catch(JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
//    解析和处理服务器返回的市级数据
    public static boolean handleCityResponse(String response,int povinceId){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allCities=new JSONArray(response);
                for(int i=0;i<allCities.length();i++){
                    JSONObject cityObject=allCities.getJSONObject(i);
                    City city=new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(povinceId);
                    city.save();
                }
                return true;
            }catch(JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
//    解析和处理服务器返回的县级数据
    public static boolean handleCountyResponse(String response,int cityId) {
        if (!TextUtils.isEmpty(response)) {
            try{
                JSONArray allCounty = new JSONArray(response);
                for (int i = 0; i < allCounty.length(); i++) {
                    JSONObject countyObject = allCounty.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            }catch(JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
//    将返回的JSON数据解析为Weather实体类
    public static Weather handleWeaterResponse(String response){
        try{
            JSONObject jsonObject=new JSONObject(response);
            JSONArray jsonArray=jsonObject.getJSONArray("HeWeather");
            String weatherContent=jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent, Weather.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

