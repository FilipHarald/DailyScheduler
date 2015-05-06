package network.client;

import network.client.controllers.ClientController;
import network.client.GUI.LoginGUI;

public class StartClient {

	public static void main(String[] args) {
		ClientController clientController = new ClientController("10.1.18.38", 1234);
		clientController.startApplication();
	}
}
