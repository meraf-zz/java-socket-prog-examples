import java.io.*;
import java.net.*;

public class Server{
	public static void main(String[] args) throws IOException{

		ServerSocket svc = new ServerSocket(12345, 5); // listen on port 12345


		Socket conn = svc.accept(); // wait for a connection

		// get the input/output streams for the socket
		BufferedReader fromClient = new BufferedReader( new InputStreamReader(conn.getInputStream()));
		DataOutputStream toClient = new DataOutputStream(conn.getOutputStream());

		String line = fromClient.readLine(); 				// read the data from the client
		System.out.println("got line \"" + line + "\""); 	// show what we got

		String result = line.length() + ": " + line.toUpperCase() + '\n'; // do the work

		toClient.writeBytes(result); // send the result

		System.out.println("server exiting\n");
		conn.close(); // close connection
		svc.close(); // stop listening  //server exiting



	}






}
