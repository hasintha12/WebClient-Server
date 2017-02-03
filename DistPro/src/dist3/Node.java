package dist3;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by hasintha on 03/02/2017.
 */
public class Node implements Observer {
    private final String myIp;
    private final int myPort;
    private final String myName;
    private static Node instance = null;

    public static Node getInstance(String ip, int port, String name) {
        if (instance == null) {
            instance = new Node(ip, port, name);
        }
        return instance;
    }

    private Node(String ip, int port, String name) {
        this.myIp = ip;
        this.myPort = port;
        this.myName = name;

    }

    public void publishWebService(){
        System.out.println("Publishing my web service @"+myIp+":"+ myPort);
        WSPublisher.getInstance().publishWebService(myIp, myPort);

    }

    @Override
    public void update(Observable o, Object arg) {
        String incoming;
        incoming = (String) arg;
        System.out.println("Message received");
        System.out.println(incoming);
    }

    public void sendMessage(String message, String peerIp, int peerPort) {
        //System.out.println("sending message: " + message + " from:" + Config.MY_IP + ":" + Config.MY_PORT + " to:" + peerIp + ":" + peerPort);

            SenderWebServiceClient.getInstance().sendMessage(message, peerIp, peerPort);

    }
}
