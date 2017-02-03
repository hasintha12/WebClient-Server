package dist3; /**
 * Created by hasintha on 03/02/2017.
 */
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 *
 * @author Amaya
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface ReceiverWebService {

   // @WebMethod String getHelloWorldAsString(String name);

    @WebMethod void receiveMessage(String message);
}
