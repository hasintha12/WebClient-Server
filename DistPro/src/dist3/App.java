package dist3;

/**
 * Created by hasintha on 03/02/2017.
 */
public class App {
    public static void main(String[] args ){

       Node nde=Node.getInstance(Config.MY_IP, Config.MY_PORT, Config.MY_NAME);
        nde.publishWebService();
        //nde.sendMessage("hasintha",Config.MY_IP,Config.MY_PORT);
    }
}
