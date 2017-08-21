package pl.oskarpolak.weatherapp.service;

import org.json.JSONObject;
import pl.oskarpolak.weatherapp.Config;
import pl.oskarpolak.weatherapp.Utils;

/**
 * Created by Lenovo on 21.08.2017.
 */
public class WeatherService {
    private static WeatherService INSTANCE = new WeatherService();
    public static WeatherService getService() {
        return INSTANCE;
    }

    private double temp;
    private int humidity;
    private int pressure;
    private int clouds;

    private WeatherService() {

    }

    public void init(String city){
      String text =  Utils.readWebsiteContext(Config.API_URL + city + "&appid=" + Config.APP_KEY);
      parseJsonFromString(text);
    }

    private void parseJsonFromString(String text) {
        JSONObject root = new JSONObject(text);
        JSONObject main = root.getJSONObject("main");

        temp = main.getDouble("temp");
        humidity = main.getInt("humidity");
        pressure = main.getInt("pressure");

        JSONObject cloudsObject = root.getJSONObject("clouds");
        clouds = cloudsObject.getInt("all");
        System.out.println("Temperatura: " + temp);
    }
}
