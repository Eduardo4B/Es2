package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProgClient 
{
    public static void main( String[] args ) throws IOException
    {
        String nomeSever = "";     
        String portaServer = "";         
        
        System.out.println("Inserire indirizzo IP");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ipAddress = br.readLine();  
        
        System.out.println("Inserire Porta Server");        
        porta = br.readLine();  

        Client client = new Client(ipAddress, Integer.valueOf(porta));
        
        client.connetti();
        client.comunica();
    }
}