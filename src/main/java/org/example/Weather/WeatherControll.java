package org.example.Weather;

import lombok.AllArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Date;

@AllArgsConstructor
public class WeatherControll {

    private String request;


    public void getWeather() throws IOException {

        String[] splitedReq = request.split("\\s");
        String link = "";

        if (splitedReq.length != 4) {
            System.out.println("Uncorrected statement!!!");
        } else {

            if (!splitedReq[0].equals("show") || !splitedReq[1].equals("weather") || !splitedReq[2].equals("in")) {
                System.out.println("Unknown function");
            } else {

                switch (splitedReq[3]) {
                    case "Almaty":
                        link = "https://www.gismeteo.kz/weather-almaty-5205/";
                        break;
                    case "Atyrau":
                        link = "https://www.gismeteo.kz/weather-atyrau-11945/";
                        break;
                    case "Astana":
                        link = "https://www.gismeteo.kz/weather-astana-5164/";
                }
//day
                Document doc = Jsoup.connect(link).get();
                Elements elements = doc.select("span.unit_temperature_c");
                Elements time = doc.select("div.day");
                for (Element element : elements) {
                    String dt = "";
                    for (Element element1 : time) {
                        dt = element1.text();
                        break;
                    }
                    String temperature = element.text(); // Получение текста из элемента
                    System.out.println("Now in " + splitedReq[3] + " " + dt + "\n" + "Temperature: " + temperature);
                    System.out.println("You can see more information here -> " + link);
                    return;
                }
            }
        }
    }
}
//show weather in Atyrau