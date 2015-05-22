package network.client.GUI.panels;

import entities.Message;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.*;

import com.sun.glass.events.WindowEvent;

import network.client.controllers.MessageController;

/**
 * The class creates a panel with new messages for the programs user.
 * 
 * @author Fredrik Nörell
 *
 */
public class MessagePanel extends JPanel implements ActionListener {

	private MessageController mc;

	/*
	 * Class variables
	 */
	private JButton newMessageButton = new JButton("New Message");
	private JButton editMessageButton = new JButton("Edit");
	private JButton deleteMessageButton = new JButton("Delete");
	private JPanel buttonsPanel = new JPanel();
	private JList messageList = new JList();

	private JPanel newMessagePanel = new JPanel();
	private JTextField titleField = new JTextField(15);
	private JTextField recipientField = new JTextField(15);
	private JTextArea messageArea = new JTextArea();
	private JLabel titleLabel = new JLabel("Title");
	private JLabel recipientLabel = new JLabel("Recipient");
	private JButton sendNewMessage = new JButton("Send");
	private JPanel alternativeClose = new JPanel();

	private JPanel confirmNewMessagePanel = new JPanel();
	private JLabel confirmSendLabel = new JLabel();
	private JButton confirmSendButtonYes = new JButton("Yes");
	private JButton confirmSendButtonNo = new JButton("No");

	private JPanel editMessagePanel = new JPanel();
	private JButton editMessage = new JButton("Save");
	private JOptionPane editCancelEditMessage = new JOptionPane();

	/**
	 * Constructor
	 */
	public MessagePanel(MessageController mc) {
		super();
		this.mc = mc;
		setBorder(BorderFactory.createTitledBorder("Message view"));
		buttonsPanel.setLayout(new BorderLayout());
		buttonsPanel.add(newMessageButton, BorderLayout.NORTH);
		buttonsPanel.add(deleteMessageButton, BorderLayout.CENTER);
		buttonsPanel.add(editMessageButton, BorderLayout.SOUTH);

		messageList.setPreferredSize(new Dimension(400, 400));

		add(buttonsPanel, BorderLayout.WEST);
		add(messageList, BorderLayout.CENTER);
		listeners();
	}

	public void messageList(){
		JPanel messageListPanel = new JPanel(new BorderLayout());
		JScrollPane scrollerCompletedTask = new JScrollPane(messageArea);
		messageListPanel.setSize(700, 300);
		messageListPanel.setPreferredSize(new Dimension(700, 300));
		messageListPanel.add(messageArea, BorderLayout.CENTER);

		add(messageListPanel, BorderLayout.SOUTH);
	}

	/**
	 * Listener for the JButtons in the buttonsPanel.
	 */
	public void listeners() {

		newMessageButton.addActionListener(this);
		deleteMessageButton.addActionListener(this);
		editMessageButton.addActionListener(this);

		sendNewMessage.addActionListener(this);
		editMessage.addActionListener(this);
	}

	/**
	 * Actionlistener for the Listener.
	 */
	public void actionPerformed(ActionEvent e) {
		/*
		 * Listener for a new message.
		 */
		if (e.getSource() == newMessageButton) {
			JFrame newMessageFrame = new JFrame("New Message");
			newMessageFrame.setLayout(null);
			newMessageFrame.setPreferredSize(new Dimension(500, 500));

			newMessagePanel.setSize(500, 500);
			newMessagePanel.setLayout(null);

			recipientLabel.setBounds(100, 50, 120, 20);
			recipientField.setBounds(200, 50, 120, 20);

			titleLabel.setBounds(100, 70, 120, 20);
			titleField.setBounds(200, 70, 120, 20);

			messageArea.setBounds(100, 100, 280, 300);

			sendNewMessage.setBounds(100, 420, 80, 25);

			newMessagePanel.add(titleLabel);
			newMessagePanel.add(recipientLabel);
			newMessagePanel.add(titleField);
			newMessagePanel.add(recipientField);
			newMessagePanel.add(messageArea);
			newMessagePanel.add(sendNewMessage);

			newMessageFrame.add(newMessagePanel);
			newMessageFrame.pack();
			newMessageFrame.setLocationRelativeTo(null);
			newMessageFrame.setVisible(true);
			newMessageFrame
			.setDefaultCloseOperation(JFrame.ABORT);

			/*
			 * Listener for edit message.
			 */
		} else if (e.getSource() == editMessageButton) {
			JFrame editMessageFrame = new JFrame("Edit Message");
			editMessageFrame.setLayout(null);
			editMessageFrame.setPreferredSize(new Dimension(500, 500));

			editMessagePanel.setSize(500, 500);
			editMessagePanel.setLayout(null);

			recipientLabel.setBounds(100, 50, 120, 20);
			recipientField.setBounds(200, 50, 120, 20);

			titleLabel.setBounds(100, 70, 120, 20);
			titleField.setBounds(200, 70, 120, 20);

			messageArea.setBounds(100, 100, 280, 300);

			editMessage.setBounds(100, 420, 80, 25);

			editMessagePanel.add(titleLabel);
			editMessagePanel.add(recipientLabel);
			editMessagePanel.add(titleField);
			editMessagePanel.add(recipientField);
			editMessagePanel.add(messageArea);
			editMessagePanel.add(editMessage);

			editMessageFrame.add(editMessagePanel);
			editMessageFrame.pack();
			editMessageFrame.setLocationRelativeTo(null);
			editMessageFrame.setVisible(true);

			/*
			 * Listener for deleting message.
			 */
		} else if (e.getSource() == deleteMessageButton) {
			int n = JOptionPane.showConfirmDialog(this,
					"Are you sure you wish to delete this message?",
					"Deleting a message", JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {

			} else {
				System.out.println("chose option no!");
				
			}
			/*
			 * Listener for sending message
			 */
		} else if (e.getSource() == sendNewMessage) {

			int n = JOptionPane.showConfirmDialog(this,
					("Send to " + getRecipients()), "Confirm send Message",
					JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				mc.sendMessage(getTitle(), getMessage(), getRecipients());
			} else {
				/*
				 * Listener for alternative flow in send new message.
				 */
				System.out.println("chose option no!");
			}
			/*
			 * Listener for regular flow in send new message.
			 */
		} else if (e.getSource() == confirmSendButtonYes) {

		}

		/*
		 * Listener for confirm edit message.
		 */
		else if (e.getSource() == editMessage) {
			int n = JOptionPane.showConfirmDialog(this,
					("Do you wish to cancel the editing of the message X?"),
					"Confirm send Message", JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
			} else {
				/*
				 * Listener for alternative flow edit message.
				 */
				System.out.println("chose option no!");
			}
			/*
			 * Listener for alternative flow edit message.
			 */
		} else if (e.getSource() == confirmSendButtonYes) {

		}
	}

	/**
	 *  get title from textfield
	 * @return
	 */
	public String getTitle() {
		return titleField.getText();
	}

	/**
	 * get message from textarea
	 * @return
	 */
	public String getMessage() {
		return messageArea.getText();
	}

	/**
	 *  get recipients from textfield
	 * @return
	 */
	public int[] getRecipients() {
		String[] temp = recipientField.getText().split(",");
		int[] toBeReturned = new int[temp.length];
		int i = 0;
		for (String s : temp) {
			toBeReturned[i++] = Integer.parseInt(s);
		}
		return toBeReturned;
	}
	/**
	 * update List
	 * @param messages
	 */
	public void updateMessageList(LinkedList<Message> messages) {
		DefaultListModel model = new DefaultListModel();
		for (Message m : messages) {
			model.addElement(m);
		}
		messageList.setModel(model);
	}
}