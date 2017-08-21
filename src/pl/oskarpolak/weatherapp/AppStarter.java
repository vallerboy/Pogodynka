package pl.oskarpolak.weatherapp;


import pl.oskarpolak.weatherapp.model.WeatherData;
import pl.oskarpolak.weatherapp.service.IWeatherObserver;
import pl.oskarpolak.weatherapp.service.WeatherService;

import javax.swing.*;
import java.util.Scanner;

/**
 * Created by Lenovo on 21.08.2017.
 */
public class AppStarter implements IWeatherObserver{
    public static void main(String[] args) {
        new AppStarter().start();
    }

    private WeatherService weatherService = WeatherService.getService();
    private Scanner scanner;
    public AppStarter() {
        scanner = new Scanner(System.in);
        weatherService.registerObserver(this);
    }

    public void start() {
        String response;
        do{
            System.out.print("Wpisz nazwę miasta: ");
            response = scanner.nextLine();

            if(response.equalsIgnoreCase("exit")){
                break;
            }

            weatherService.init(response);

        }while (true);
        System.out.println("Papa!");
    }

    @Override
    public void onWeatherUpdate(WeatherData data) {
        JOptionPane.showMessageDialog(null, "Temp to: " + data.getTemp());
    }
}
