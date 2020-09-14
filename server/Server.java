import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Vector;

public class Server {
    private final ServerSocket serverSocket;
    private final Vector<Clients> List = new Vector<>();
    public Server(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    private void serverIsWaiting() throws IOException {
        while (true) {
            Socket socket = serverSocket.accept();
            Clients newClients = new Clients(socket);
            newClients.start();
            List.add(newClients);
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(1408);
        System.out.println("Server is online.....");
        server.serverIsWaiting();
    }

    public class Clients extends Thread {
        private final Socket socket;
        //private String userName = null;
        private DataInputStream dataInputStream;
        private DataOutputStream dataOutputStream;

        public Clients(Socket socket) throws IOException {
            this.socket = socket;
            this.dataInputStream = new DataInputStream(socket.getInputStream());
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
        }

        public void sendMessage(String Message) {
            try {
                dataOutputStream.writeUTF(Message);
            } catch (IOException e) {
                return;
            }
        }
        
        public void sendToTheOther(String message){
            for (Clients clientLoop : List) {
                try {
                    if (!clientLoop.equals(this)) {
                        DataOutputStream newDataOutputStream = new DataOutputStream(clientLoop.socket.getOutputStream());
                        newDataOutputStream.writeUTF(message);
                        System.out.println(message);
                    }
                } catch (Exception e) {
                    List.remove(clientLoop);
                }
            }
        }
        @Override
        public void run() {
            synchronized (this) {
                try {

                    while (true) {
                        try {
                            String message ="";
                            while (true) {
                                try {
                                    message= dataInputStream.readUTF();
                                    break;
                                } catch (EOFException e) {
                                    
                                }
                            }
                            
                            // if (userName == null) {
                            //     userName = message;
                            //     System.out.println(userName + " has join zoom");
                            //     //sendMessage("hamanochiharu728");
                            // } else {
                                System.err.println(message);
                                sendToTheOther(message);
                            // }
                        } catch (SocketException e) {
                            System.err.println(" has left the zoom !");
                            this.socket.close();
                            List.remove(this);
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

}