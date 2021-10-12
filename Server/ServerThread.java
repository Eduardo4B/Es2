package Server;

import java.io.*;
import java.net.*;

public class ServerThread extends Thread{
    String stringModificata = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;
    ServerSocket server = null;
    Socket client = null;
    String stringRicevuta = null;

    public ServerThread(Socket socket, ServerSocket server) {
        this.client = socket;
        this.server = server;
    }

  public void run(){
      try{
          comunica();
      }
      catch (Exception e){
          e.printStackTrace(System.out);
      }
  }

    public void comunica() throws Exception{

       inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream())); 
       outVersoClient = new DataOutputStream(client.getOutputStream()); 

        for (;;)
        {
            stringRicevuta = inDalClient.readLine(); 
            if (stringRicevuta.equals("STOP"))
            {
                outVersoClient.writeBytes(stringRicevuta + " (=> chiusura del server)" + '\n'); 
                server.close();
                break;
            }

            if (stringRicevuta == null || stringRicevuta.equals("STOP"))
            {
                outVersoClient.writeBytes(stringRicevuta + " (=> server in chiusura... )" + '\n'); 
               
                System.out.println("Echo sul sever in chiusura :" + stringRicevuta);
                client.close();

                break;
            }

            else
            {
               
                    outVersoClient.writeBytes(stringRicevuta + " (ricevuta e ritrasmessa)" + '\n');
                    System.out.println("6 Echo sul server :" + stringRicevuta);
               
            }
        }

        outVersoClient.close();
        inDalClient.close();
        System.out.println("9 Chiusura socket" + client);

        client.close();
    }
}
