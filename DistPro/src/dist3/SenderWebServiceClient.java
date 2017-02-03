package dist3; /**
 * Created by hasintha on 03/02/2017.
 */
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class SenderWebServiceClient {

    private static SenderWebServiceClient instance=null;

    private SenderWebServiceClient(){
    }

    public static SenderWebServiceClient getInstance(){
        if(instance==null){
            return new SenderWebServiceClient();
        }
        else{
            return instance;
        }
    }

    public static void testWebService(String ip, int port, String aString) {

        String urlString = "http://" + ip + ":" + port + "/ws/hsrfileservice?wsdl";
        try {
            URL url = new URL(urlString);

            QName qname = new QName("http://dist3/", "WSInterfaceImplService");

            Service service = Service.create(url, qname);

            ReceiverWebService hsrfileservice = service.getPort(ReceiverWebService.class);



        } catch (MalformedURLException ex) {
            System.out.println("MalformedURLException. Problem in url string");
        }
    }

    public void sendMessage(String message, String peerIp, int peerPort){
        String urlString = "http://" + peerIp + ":" + peerPort + "/ws/hsrfileservice?wsdl";

        try {
            URL url = new URL(urlString);

            QName qname = new QName("http://dist3/", "ReceiverWebServiceImplService");

            Service service = Service.create(url, qname);

            ReceiverWebService hsrfileservice = service.getPort(ReceiverWebService.class);

            System.out.println("Message Sent:"+message);
            hsrfileservice.receiveMessage(message);

        } catch (MalformedURLException ex) {
            System.out.println("MalformedURLException. Problem in url string");
        }
    }


}
