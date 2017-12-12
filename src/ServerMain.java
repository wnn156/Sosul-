
// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import server.AbstractServer;
import server.ConnectionToClient;
import server.gui.ServerFrame;
import ProblemDomain.User;

import common.Message;

/**
 * This class overrides some of the methods in the abstract superclass in order
 * to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */
public class ServerMain extends AbstractServer {
	// Class variables *************************************************

	/**
	 * The default port to listen on.
	 */
	final public static int DEFAULT_PORT = 5555;

	/**
	 * 회占쏙옙占쏙옙 占쏙옙 占싸깍옙占쏙옙 占쌓쏙옙트占쏙옙 占쏙옙占쏙옙占쏙옙
	 */
	private Map<String, String> userInfo;

	// Constructors ****************************************************

	/**
	 * Constructs an instance of the echo server.
	 *
	 * @param port
	 *            The port number to connect on.
	 */
	public ServerMain(int port) {
		super(port);

		userInfo = new HashMap<String, String>();
		
		//receive id, password form userfile
		userInfo.put("123", "123");
	}

	// Instance methods ************************************************

	/**
	 * This method handles any messages received from the client.
	 *
	 * @param msg
	 *            The message received from the client.
	 * @param client
	 *            The connection from which the message originated.
	 * @throws IOException 
	 */
	public void handleMessageFromClient(Message msg, ConnectionToClient client) throws IOException {
		
		System.out.println("Get Message from " + client.getInetAddress());
		
		if (msg.getData() instanceof User) {
			User user = (User) msg.getData(); 
		
			switch(msg.getMode()) {
			case 'a':  // append (회占쏙옙占쏙옙 占쏙옙 占쏙옙)
				System.out.println(">> Success to register ID : " + user.getId());
				System.out.println(user);
				userInfo.put(user.getId(), user.getPassWord());
				client.sendToClient(new Message('s'));
				break;
			
			case 'c':  // check (占싸깍옙占쏙옙 占쏙옙 占쏙옙)
				String pw = userInfo.get(user.getPassWord());
				if (pw == null || !pw.equals(user.getPassWord())) {  // 占쏙옙占쏙옙占쏙옙占쏙옙 占십댐옙 ID占신놂옙 占쏙옙橘占싫ｏ옙占� 틀占쏙옙占쏙옙 占쏙옙
					System.out.println(">> Fail to join ID : " + user.getId());
					client.sendToClient(new Message('f'));
				}
				else {
					System.out.println(">> Success to join ID : " + user.getId());
					client.sendToClient(new Message('s'));
				}
				break;
			}
		}
	}

	/**
	 * This method overrides the one in the superclass. Called when the server
	 * starts listening for connections.
	 */
	protected void serverStarted() {
		System.out.println("Server listening for connections on port " + getPort());
	}

	/**
	 * This method overrides the one in the superclass. Called when the server
	 * stops listening for connections.
	 */
	protected void serverStopped() {
		System.out.println("Server has stopped listening for connections.");
	}

	// Class methods ***************************************************

	/**
	 * This method is responsible for the creation of the server instance (there
	 * is no UI in this phase).
	 *
	 * @param args[0]
	 *            The port number to listen on. Defaults to 5555 if no argument
	 *            is entered.
	 */
	public static void main(String[] args) {
		int port = 0; // Port to listen on
		
		try {
			port = Integer.parseInt(args[0]); // Get port from command line
		} catch (Throwable t) {
			port = DEFAULT_PORT; // Set port to 5555
		}

		ServerFrame sf = new ServerFrame();
			
		sf.startLogging();
		
		ServerMain sv = new ServerMain(port);
		
		try {
			sv.listen(); // Start listening for connections
		} catch (Exception ex) {
			System.out.println("ERROR - Could not listen for clients!");
		}
	}
}
// End of EchoServer class
