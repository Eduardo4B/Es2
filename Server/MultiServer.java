package Server;

public class MultiServer{

public void start(){

    try{

        ServerSocket ServerSocket = new ServerSocket(6789);
        for(;;)
        {
            System.out.println("1 Server in attesa ...");
            Socket socket = ServerSocket.accept();
            System.out.println("3 Server socket "+ socket);
            ServerThread ServerThread = new ServerThread(socket);
            ServerThread.start();
        }
    }
    catch(Exception e){
        System.out.println(e.getMessage());
        System.out.println("Errore durante l'istanza del server !");
        System.exit(1);
    }
}

}