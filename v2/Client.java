import java.io.*;
import java.net.*;

public class Client{

	public static void main(String[] args) throws IOException{
		String line; // user input
		BufferedReader userData = new BufferedReader( new InputStreamReader(System.in));
		// InputStreamReader > for converting bytes to character
		// BufferedReader > for reading a line


		Socket sock = new Socket("localhost", 12345);  // create, bind, connect socket( all in once)


		DataOutputStream toServer = new DataOutputStream(sock.getOutputStream());	//Get input and output streams from the socket
		BufferedReader fromServer = new BufferedReader(new InputStreamReader(sock.getInputStream()));

		line = userData.readLine(); 			// read a line from the user
		System.out.println("we got: \"" + line+ '"');
		toServer.writeBytes(line + '\n'); // send the line to the server  don't forget to add \n
		String result = fromServer.readLine();  // read a one-line result
		System.out.println(result);				// print it
		sock.close();









	}
}
