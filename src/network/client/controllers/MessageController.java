/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network.client.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import entities.Message;
import network.client.GUI.panels.MessagePanel;

/**
 *
 * @author Aya & Filip
 */
public class MessageController {
	private MessagePanel messagePanel;
	private ClientController cc;

	public MessageController(ClientController cc) {
		messagePanel = new MessagePanel();
		this.cc = cc;
	}

	public void sendMessage(String name, String title, ArrayList<String> recipients, int id) {
		Message msg = new Message(name, title, recipients, id);
	}

	public void updatePanel(LinkedList<Message> messages) {
		messagePanel.updateMessageList(messages);
	}

	public MessagePanel getPanel() {
		return messagePanel;
	}

}
