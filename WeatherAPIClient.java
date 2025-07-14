import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/**
 * WeatherAPIClient.java
 *
 * This Java application fetches weather data from a public API and displays
 * the temperature, weather condition, and city name in a structured format.
 *
 * Dependencies:
 * - org.json (https://mvnrepository.com/artifact/org.json/json)
 *
 * Author: Mohit Kumar
 * Date: July 2025
 */

public class WeatherAPIClient {

    public static void main(String[] args) {
        try {
            String apiKey = "demo"; // Replace with a real API key if required
            String city = "London";
            String urlString = "https://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + city + "&aqi=no";

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP GET Request Failed with Error code : " + conn.getResponseCode());
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            reader.close();

            JSONObject obj = new JSONObject(json.toString());

            System.out.println("📍 Location: " + obj.getJSONObject("location").getString("name"));
            System.out.println("🌡️ Temperature (°C): " + obj.getJSONObject("current").getDouble("temp_c"));
            System.out.println("☁️ Condition: " + obj.getJSONObject("current").getJSONObject("condition").getString("text"));

            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}