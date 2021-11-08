package com.example.weather_app20.Retrofit;

import com.google.gson.annotations.SerializedName;

public class Main {
    @SerializedName("temp")
    String temp;

    @SerializedName("humidity")
    String humidity;

    @SerializedName("feels_like")
    String feels_like;

    @SerializedName("temp_max")
    String temp_max;

    @SerializedName("temp_min")
    String temp_min;

    @SerializedName("speed")
    String speed;

    @SerializedName("country")
    String country;

    @SerializedName("icon")
    String icon;


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(String temp_max) {
        this.temp_max = temp_max;
    }

    public String getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(String temp_min) {
        this.temp_min = temp_min;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(String feels_like) {
        this.feels_like = feels_like;
    }
}
