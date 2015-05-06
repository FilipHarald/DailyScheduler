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
import miscellaneous.Updater;
import network.client.GUI.panels.MessagePanel;

/**
 *
 * @author Aya & Filip
 */
public class MessageController {
	private MessagePanel messagePanel;
        private Message message;
	private ClientController cc;
        private Updater up;

	public MessageController(ClientController cc) {
		messagePanel = new MessagePanel(this);
		this.cc = cc;
	}
	
	public void sendMessage(String title, String msg, int[] recipients) {
		cc.sendObject(new Message(title, msg, recipients, cc.getUserId()));
	}
        //add messages to the list to be displayed in the GUI
        public void updateMessageList(){
            up.addMessage(message);
            cc.refresh();
        }

	public void updatePanel(LinkedList<Message> messages) {
		messagePanel.updateMessageList(messages);
	}

	public MessagePanel getPanel() {
		return messagePanel;
	}
}
