package pl.oskarpolak.weatherapp;


import pl.oskarpolak.weatherapp.service.WeatherService;

import java.util.Scanner;

/**
 * Created by Lenovo on 21.08.2017.
 */
public class AppStarter {
    public static void main(String[] args) {
        new AppStarter().start();
    }

    private WeatherService weatherService = WeatherService.getService();
    private Scanner scanner;
    public AppStarter() {
        scanner = new Scanner(System.in);
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
}
