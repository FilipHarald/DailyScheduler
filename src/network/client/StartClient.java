package network.client;

import network.client.controllers.ClientController;
import network.client.GUI.LoginGUI;

public class StartClient {

	public static void main(String[] args) {
		ClientController clientController = new ClientController(null, 0);
		clientController.startApplication();
	}
}
