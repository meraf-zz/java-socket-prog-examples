import java.io.*;
import java.net.*;

public class Server implements Runnable{
	Socket conn;  // this is a per-thread copy of the client socket

	public Server(Socket sock){

		this.conn = sock;  // store the socket for the connection

	}

	public static void main(String[] args) throws IOException{

		ServerSocket svc = new ServerSocket(12345, 5); // listen on port 12345

		for(;;){
			Socket conn = svc.accept(); // get a connection from a client
			System.out.println("got a new connection");
			new Thread(new Server(conn)).start();
		    //svc.close(); // stop listening
		}


	}
	// The per-connection work is done in the thread

	public void run(){
		try{

			// get the input/output streams for the socket
			BufferedReader fromClient = new BufferedReader( new InputStreamReader(conn.getInputStream()));
			DataOutputStream toClient = new DataOutputStream(conn.getOutputStream());
			String line;

			while ((line = fromClient.readLine()) != null) { // while there's data from the client
					System.out.println("got line \"" + line + "\""); 	// show what we got
					String result = line.length() + ": " + line.toUpperCase() + '\n'; // do the work
					toClient.writeBytes(result); // send the result
		    }


			conn.close(); // close connection


		}catch (IOException e) {
			System.out.println(e);

		}
	}








}
