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
 * @author Fredrik N�rell
 *
 */
public class MessagePanel extends JPanel implements ActionListener  {

	private MessageController messageC;

	/*
	 * Class variables
	 */
	private JButton newMessageButton = new JButton("New Message");
	private JButton editMessageButton = new JButton ("Edit");
	private JButton deleteMessageButton = new JButton ("Delete");
	private JPanel textPanel = new JPanel();
	private JPanel buttonsPanel= new JPanel();
	final  DefaultListModel listModel = new DefaultListModel();
	private JList txt = new JList(listModel);
	
	private JPanel newMessagePanel = new JPanel();
	private JTextField titleField = new JTextField(15);
	private JTextField recipientField = new JTextField(15);
	private JTextArea messageArea = new JTextArea();
	private JLabel titleLabel = new JLabel("Title");
	private JLabel recipientLabel = new JLabel ("Recipient");
	private JButton sendNewMessage = new JButton("Send");

	private JPanel confirmNewMessagePanel = new JPanel();
	private JLabel confirmSendLabel = new JLabel();
	private JButton confirmSendButtonYes = new JButton("Yes");
	private JButton confirmSendButtonNo = new JButton("No");

	private JPanel editMessagePanel = new JPanel();
	private JButton editMessage = new JButton("Edit");

	private JPanel deleteMessagePanel = new JPanel();
	private JButton deleteMessageYes = new JButton ("Yes");
	private JButton deleteMessageNo = new JButton("No");
	private JLabel deleteMessageTitle = new JLabel("Do you wish to delete this message?");
	
//	private String titleText = new String() ;
//	private String messageText = new String();
//	private String resipientText = new String();
//	private Object[] messageObject ;
	

	/**
	 * Constructor
	 */
	public MessagePanel(){
		
		super();


		/*
		 * Borderlayout for the objects
		 */
		setBorder(BorderFactory.createTitledBorder("Message view"));

		buttonsPanel.setLayout(new BorderLayout());
		buttonsPanel.add(newMessageButton, BorderLayout.NORTH);
		buttonsPanel.add(deleteMessageButton, BorderLayout.CENTER);
		buttonsPanel.add(editMessageButton, BorderLayout.SOUTH);

		textPanel.add(txt,BorderLayout.CENTER);	
		txt.setPreferredSize(new Dimension(200,200));

		add(buttonsPanel, BorderLayout.WEST);
		add(textPanel, BorderLayout.CENTER);
		//		add(newMessagePanel);
		listeners();
	}



	/**
	 * Listener for the JButtons in the buttonsPanel.
	 */
	public void listeners(){

		newMessageButton.addActionListener(this);
		deleteMessageButton.addActionListener(this);
		editMessageButton.addActionListener(this);

		sendNewMessage.addActionListener(this);
		editMessage.addActionListener(this);
		deleteMessageYes.addActionListener(this);

		deleteMessageNo.addActionListener(this);
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
					JFrame deleteMessageFrame = new JFrame("Delete Message");
					deleteMessageFrame.setLayout(null);
					deleteMessageFrame.setPreferredSize(new Dimension(500,500));

					deleteMessagePanel.setSize(500,500);
					deleteMessagePanel.setLayout(null);

					deleteMessageTitle.setBounds(140,80,250,20);

					deleteMessageYes.setBounds(100,420,80,25);
					deleteMessageNo.setBounds(300,420,80,25);

					deleteMessagePanel.add(deleteMessageTitle);
					deleteMessagePanel.add(deleteMessageYes);
					deleteMessagePanel.add(deleteMessageNo);

					deleteMessageFrame.add(deleteMessagePanel);
					deleteMessageFrame.pack();
					deleteMessageFrame.setLocationRelativeTo(null);
					deleteMessageFrame.setVisible(true);
				}
			}
			if (e.getSource()==sendNewMessage){

				String resRecipient = recipientField.getText();
				int resRecipientLength=resRecipient.length();

				JFrame confirmMessageFrame = new JFrame("Confirm send Message");
				confirmMessageFrame.setLayout(null);
				confirmMessageFrame.setPreferredSize(new Dimension(500+resRecipientLength,500));


				confirmSendLabel.setText("Send to " + resRecipient);

				confirmNewMessagePanel.setSize(500+resRecipientLength,500 );
				confirmNewMessagePanel.setLayout(null);



				confirmSendLabel.setBounds(110,80,(150+resRecipientLength),20);
				confirmSendButtonYes.setBounds(100,420,80,25);
				confirmSendButtonNo.setBounds(300,420,80,25);


				confirmNewMessagePanel.add(confirmSendLabel);
				confirmNewMessagePanel.add(confirmSendButtonYes);
				confirmNewMessagePanel.add(confirmSendButtonNo);

				confirmMessageFrame.add(confirmNewMessagePanel);
				confirmMessageFrame.pack();
				confirmMessageFrame.setLocationRelativeTo(null);
				confirmMessageFrame.setVisible(true);

				if(e.getSource()==confirmSendButtonYes){

					
					
				String titleText = titleField.getText();
//					messageText = messageArea.getText();
//					resipientText = recipientField.getText();
					listModel.addElement(titleText);
					
					
					
				}
			}
		}
	}

	//get title from textfield
	public String getTitle() {
		return titleField.getText();
	}

	//get message from textarea
	public String getMessage() {
		return messageArea.getText();
	}

	//get recipients from textfield
	public String getRecipients() {
		return recipientField.getText();
	}

	//display the list of all the messages 
	public void messageListDisplay(Message msg){
//		txt.setText(messageC.displayMessageList(msg).toString());
	}

	//display information/content for a specific message
	public void displayMessage(Message msg) {



	}
	public void update(LinkedList<Message> messages){
		titleText = titleField.getText();
		
	}
}