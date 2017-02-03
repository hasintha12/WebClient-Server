package dist3;
/**
 * Created by hasintha on 03/02/2017.
 */
import javax.xml.ws.Endpoint;

public class WSPublisher {

    private static WSPublisher instance=null;

    private WSPublisher(){

    }

    public static WSPublisher getInstance(){
        if(instance==null){
            return new WSPublisher();
        }
        else{
            return instance;
        }
    }

    public void publishWebService(String ip, int port) {
        Endpoint.publish("http://" + ip + ":" + port + "/wsh/hsrfileservice/ivan", new ReceiverWebServiceImpl());
    }

}

