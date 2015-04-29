package network.client.GUI.panels;

import entities.Message;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import network.client.controllers.MessageController;

/**
 * The class creates a panel with new messages for the programs user.
 * 
 * @author Fredrik N�rell
 *
 */
public class MessagePanel extends JPanel implements ActionListener {

	private MessageController messageC;

	/*
	 * Class variables
	 */
	private JButton newMessageButton = new JButton("New Message");
	private JButton editMessageButton = new JButton("Edit");
	private JButton deleteMessageButton = new JButton("Delete");
	private JPanel buttonsPanel = new JPanel();
	private DefaultListModel listModel = new DefaultListModel();
	private JList messageList = new JList(listModel);

	private JPanel newMessagePanel = new JPanel();
	private JTextField titleField = new JTextField(15);
	private JTextField recipientField = new JTextField(15);
	private JTextArea messageArea = new JTextArea();
	private JLabel titleLabel = new JLabel("Title");
	private JLabel recipientLabel = new JLabel("Recipient");
	private JButton sendNewMessage = new JButton("Send");

	private JPanel confirmNewMessagePanel = new JPanel();
	private JLabel confirmSendLabel = new JLabel();
	private JButton confirmSendButtonYes = new JButton("Yes");
	private JButton confirmSendButtonNo = new JButton("No");

	private JPanel editMessagePanel = new JPanel();
	private JButton editMessage = new JButton("Edit");

	// private String titleText = new String() ;
	// private String messageText = new String();
	// private String resipientText = new String();
	// private Object[] messageObject ;

	/**
	 * Constructor
	 */
	public MessagePanel() {
		super();
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

	/**
	 * Listener for the JButtons in the buttonsPanel.
	 */
	public void listeners() {

		newMessageButton.addActionListener(this);
		deleteMessageButton.addActionListener(this);
		editMessageButton.addActionListener(this);

		sendNewMessage.addActionListener(this);
		editMessage.addActionListener(this);

		confirmSendButtonYes.addActionListener(this);
		confirmSendButtonNo.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==newMessageButton){
			JFrame newMessageFrame = new JFrame("New Message");
			newMessageFrame.setLayout(null);
			newMessageFrame.setPreferredSize(new Dimension(500, 500));

			newMessagePanel.setSize(500, 500);
			newMessagePanel.setLayout(null);


			recipientLabel.setBounds(100,50,120,20);
			recipientField.setBounds(200,50,120,20);

			titleLabel.setBounds(100,70,120,20);
			titleField.setBounds(200,70,120,20);

			messageArea.setBounds(100,100,280,300);

			sendNewMessage.setBounds(100,420,80,25);

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


		}
		else{
			if(e.getSource()==editMessageButton){
				JFrame editMessageFrame = new JFrame("Edit Message");
				editMessageFrame.setLayout(null);
				editMessageFrame.setPreferredSize(new Dimension(500, 500));

				editMessagePanel.setSize(500, 500);
				editMessagePanel.setLayout(null);

				recipientLabel.setBounds(100,50,120,20);
				recipientField.setBounds(200,50,120,20);

				titleLabel.setBounds(100,70,120,20);
				titleField.setBounds(200,70,120,20);

				messageArea.setBounds(100,100,280,300);

				editMessage.setBounds(100,420,80,25);

				//Lägg till kod för att hämta information från gamla meddelanden, String -> getText osv
				//för att editera dem.

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
			}else{
				if(e.getSource()==deleteMessageButton){
					int n = JOptionPane.showConfirmDialog(
						    this,
						    "Are you sure you wish to delete this message?",
						    "Deleting a message",
						    JOptionPane.YES_NO_OPTION);
					if(n == JOptionPane.YES_OPTION){
				}else{
					System.out.println("chose option no!");
				}
			}
			if (e.getSource()==sendNewMessage){

				String resRecipient = recipientField.getText();
				int resRecipientLength=resRecipient.length();
				
				int n = JOptionPane.showConfirmDialog(
					    this,
					    ("Send to " + resRecipient),
					    "Confirm send Message",
					    JOptionPane.YES_NO_OPTION);
				if(n == JOptionPane.YES_OPTION){
			}else{
				System.out.println("chose option no!");
			}
				if(e.getSource()==confirmSendButtonYes){

					
					
				String titleText = titleField.getText();
//					messageText = messageArea.getText();
//					resipientText = recipientField.getText();
					listModel.addElement(titleText);
					
					
					
				}
			}
		}
		}
	}

	// get title from textfield
	public String getTitle() {
		return titleField.getText();
	}

	// get message from textarea
	public String getMessage() {
		return messageArea.getText();
	}

	// get recipients from textfield
	public String getRecipients() {
		return recipientField.getText();
	}

	// display the list of all the messages
	public void messageListDisplay(Message msg) {
		// txt.setText(messageC.displayMessageList(msg).toString());
	}

	// display information/content for a specific message
	public void displayMessage(Message msg) {

	}
	 public void update(LinkedList<Message> messages){
//	 titleText = titleField.getText();
	
	 }
}