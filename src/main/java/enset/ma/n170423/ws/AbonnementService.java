package enset.ma.n170423.ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(serviceName="AbonnementWS")
public class AbonnementService {
    @WebMethod(operationName = "Something")
    public double something(@WebParam(name = "montant") double mt) {
        return mt * 11.3;
    }
}