package org.example;

import org.example.Weather.WeatherControll;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entry your request: ");
            String function = scanner.nextLine();
            if (function.equals("Q") || function.equals("Q")){
                System.out.println("Bye");
                break;
            }
            if (function.equals("help")){
                System.out.println("You can entry: " +
                        "\n" + "\t" + "show weather in 'city name'" +
                        "\n" + "\t" + "Now you can chose 'Almaty, Astana, Atyrau'");
            }else {
                WeatherControll weatherControll = new WeatherControll(function);
                weatherControll.getWeather();
            }
        }
    }
}