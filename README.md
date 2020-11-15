## [Version 1](https://github.com/fasilminale/java-socket-examples/tree/master/v1) : using tcp/ip

		– Client:
			1. Read a line of text from the user
			2. Send it to the server; wait for a response (single line)
			3. Print the response
		– Server
			1. Wait for a connection from a client
			2. Read a line of text
			3. Return a response that contains the length of the string and the string
			converted to uppercase
			4. Exit
## [Version 2](https://github.com/fasilminale/java-socket-examples/tree/master/v2) : We don’t want the server to exit

	– Instead, have it wait for another connection

	• Simple:
		– Create the ServerSocket
		– Then put everything else in a forever loop ( for(;;) )
		– Never close the ServerSocket
		• Now we can keep the server running and try running the
		client multiple times



## [Version 3](https://github.com/fasilminale/java-socket-examples/tree/master/v3) : let’s support multiple lines

	Instead of having the server close the connection when a
	single line of text is received, allow the client to read
	multiple lines of text

	– Each line is sent to the server; the response is read & printed
	– An end of file from the user signals the end of user input
	• This is typically control-D on Mac/Linux/Unix systems (see the stty
	command)

	# The server handles only one connection

		1. Run the server in one window
		2. Run the client in another window
			– Type a bunch of text
			– Each line produces a response from the server
		3. Run the client again in yet another window
			– Type a bunch of text
			– Nothing happens. There’s no connection to the server!
			– You have to exit the first client before this one can connect.
		4. We need to make the server multi-threaded


# [Version 4](https://github.com/fasilminale/java-socket-examples/tree/master/v4) : add multi-threading to the server
	- implement Runnable
	- new Thread(new Server(conn)).start();


# [Version 5](https://github.com/fasilminale/java-socket-examples/tree/master/v5) : Allow the client to specify the server name on the command line

	– If it’s missing, use “localhost”


