import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Base64;
import java.util.PrimitiveIterator;

public class API {

    private static HttpURLConnection connection;
    Credential credential;
    private int responseCode;

    public API(Credential userCredential) {
        this.credential = userCredential;
    }


    public StringBuffer connectionAPI(String path) {



            BufferedReader reader;
            String line;
            StringBuffer responseContent = new StringBuffer();

            try {

                this.responseCode = connectoionCreation(path);


                if (this.responseCode > 299) {
                    reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                    while ((line = reader.readLine()) != null) {
                        responseContent.append(line);
                    }
                    reader.close();
                } else {
                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    while ((line = reader.readLine()) != null) {
                        responseContent.append(line);
                    }
                    reader.close();
                }




            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

            connection.disconnect();
        }
        return responseContent;
    }

     int connectoionCreation(String path) throws IOException {
        String subDomain = credential.getSubDomain();
        String email = credential.getEmail();
        String password = credential.getPassword();
        String apiUrl = "https://" + subDomain + ".zendesk.com/api/v2/";
        URL url = new URL(apiUrl + path);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Accept", "application/json");
        // Encoding the basic auth
        String basicAuth = email + ":" + password;
        String basicAuthEncode = Base64.getEncoder().encodeToString(basicAuth.getBytes());
        connection.setRequestProperty("Authorization", "Basic  " + basicAuthEncode);
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        int statusCode  = connection.getResponseCode();


        return statusCode;
    }
}


