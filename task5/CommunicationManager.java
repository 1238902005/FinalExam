package finalexam.task5;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CommunicationManager {

    private final String endpoint;


    public CommunicationManager(String endpoint) {
        this.endpoint = endpoint;
    }


    public String sendUserMessage(String message) {
        try {

            HttpURLConnection connection = getHttpURLConnection(message);


            int responseCode = connection.getResponseCode();


            if (responseCode == HttpURLConnection.HTTP_OK) {
                return "Message sent successfully.";
            } else {
                return "Failed to send message. Response code: " + responseCode;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "An error occurred: " + e.getMessage();
        }
    }

    private HttpURLConnection getHttpURLConnection(String message) throws IOException {
        URL url = new URL(endpoint);


        HttpURLConnection connection = (HttpURLConnection) url.openConnection();


        connection.setRequestMethod("POST");


        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");

        connection.setDoOutput(true);


        String jsonInputString = "{\"message\": \"" + message + "\"}";


        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        return connection;
    }
}

