package Client;
import java.io.*;
import java.net.*;

public class Client{
String nomeServer ="nomeServer";
int portaServer = 6789;
DataInputStream in;
DataOutputStream out;

public Socket connetti() {
    System.out.println("2 CLIENT partito in esecuzione ");

    try
    {
        tastiera = new BufferedReader(new InputStreamReader(System.in));

        mioSocket = new Socket(nomeServer, portaServer);

        outVersoServer = new DataOutputStream(mioSocket.getOutputStream());
        inDalServer = new BufferedReader(new InputStreamReader(mioSocket.getInputStream()));

    }
    catch(UnknownHostException e)
    {
        System.err.println("Host Sconosciuto");
    }

    catch(Exception e)
    {
        System.out.println(e.getMessage());
        System.out.println("Errore Durante La Connessione");
        System.exit(1);
    }

    return mioSocket;
}
public void Comunica()

{
    try
    {
        System.out.println("4... Inserisci la stringa da trasmettere al server " + '\n');
        stringUtente = tastiera.readLine();

        System.out.println("5... Invio la stringa al server e attendo");
        outVersoServer.writeBytes(stringUtente + '\n');

        stringRicevutaDalServer = inDalServer.readLine();
        System.out.println("7 ... risposta dal server "+'\n'+stringRicevutaDalServer);
        

        if(stringUtente.equals("FINE")){
        System.out.println("8 CLIENT: termina elaborazione e chiude connessione");
        mioSocket.close();
        break;
        }
    }

    catch(Exception e)
    {
        System.out.println(e.getMessage());
        System.out.println("Errore Durante La Connessione");
        System.exit(1);
    }
}


}