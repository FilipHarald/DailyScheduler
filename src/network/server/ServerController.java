package network.server;

public class ServerController {
	public final int port = 1234;
	private Server server = new Server(port, this);
}
