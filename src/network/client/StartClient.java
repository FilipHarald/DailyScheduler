package network.client;

import network.client.controllers.ClientController;

public class StartClient {

	public static void main(String[] args) {
		ClientController clientController = new ClientController("localhost", 1234);
		clientController.startApplication();
	}
}
