package enset.ma.n170423.ws;

import enset.ma.n170423.entities.Client;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.Date;
import java.util.List;

@WebService(serviceName="ClientWS")
public class ClientService {
    @WebMethod
    public List<Client> listClients() {
        return List.of(
                new Client(null, "something", "something@gmail.com", "somethingSonmething", null),
                new Client(null, "something", "something@gmail.com", "somethingSonmething", null),
                new Client(null, "something", "something@gmail.com", "somethingSonmething", null),
                new Client(null, "something", "something@gmail.com", "somethingSonmething", null),
                new Client(null, "something", "something@gmail.com", "somethingSonmething", null),
                new Client(null, "something", "something@gmail.com", "somethingSonmething", null),
                new Client(null, "something", "something@gmail.com", "somethingSonmething", null)
        );
    }
}
