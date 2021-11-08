package com.example.weather_app20.Retrofit;

import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("main")
    private Main main;

    @SerializedName("wind")
    private Main mainWind;

    @SerializedName("sys")
    private Main Sys;




    public Main getSys() {
        return Sys;
    }

    public void setSys(Main sys) {
        Sys = sys;
    }

    public Main getMainWind() {
        return mainWind;
    }

    public void setMainWind(Main mainWind) {
        this.mainWind = mainWind;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
