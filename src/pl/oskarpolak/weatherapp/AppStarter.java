package pl.oskarpolak.weatherapp;


import pl.oskarpolak.weatherapp.service.WeatherService;

/**
 * Created by Lenovo on 21.08.2017.
 */
public class AppStarter {
    public static void main(String[] args) {
        new AppStarter();
    }

    WeatherService weatherService = WeatherService.getService();

    public AppStarter() {
        weatherService.init("Cracow");
    }
}
