import java.io.*;
import java.net.*;

public class Client{

	public static void main(String[] args) throws IOException{
		String line; // user input
		String server = "localhost"; // default server
		BufferedReader userData = new BufferedReader( new InputStreamReader(System.in));

		if(args.length > 1){
			System.err.println("usage: java TCPClient server_name");
			System.exit(1);
		} else if (args.length == 1) {
			server = args[0];
			System.out.println("server = " + server);
		}

		Socket sock = new Socket("localhost", 12345);

		DataOutputStream toServer = new DataOutputStream(sock.getOutputStream());	//Get input and output streams from the socket
		BufferedReader fromServer = new BufferedReader(new InputStreamReader(sock.getInputStream()));

		while((line = userData.readLine()) != null){     // read a line at a time


			toServer.writeBytes(line + '\n'); 			// send the line to the server  don't forget to add \n
			String result = fromServer.readLine();  	// read a one-line result
			System.out.println(result);					// print it


		}
		sock.close();










	}
}
