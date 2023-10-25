package enset.ma.n170423;

import enset.ma.n170423.ws.ClientService;
import jakarta.xml.ws.Endpoint;

public class ServerJWSClient {
    public static void main(String[] args) {
        String url = "http://0.0.0.0:9191/";
        Endpoint.publish(url, new ClientService());
        System.out.println("Web service deployed on : " + url);
    }
}
