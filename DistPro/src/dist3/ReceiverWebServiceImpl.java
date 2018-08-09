package dist3;
/**
 * Created by hasintha on 03/02/2017.
 */
import java.util.Observable;
import javax.jws.WebService;
/**
 *
 * @author Amaya
 */


//Service Implementation
@WebService(endpointInterface = "dist3.ReceiverWebService")
public class ReceiverWebServiceImpl extends Observable implements ReceiverWebService {

    public ReceiverWebServiceImpl() {
        addObserver(Node.getInstance(Config.MY_IP, Config.MY_PORT, Config.MY_NAME));

    }

    @Override
    public void receiveMessage(String message){
        //System.out.println("Message received: "+message);

        setChanged();
        notifyObservers(message);
        clearChanged();

    }

}



