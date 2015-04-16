package network.client.GUI.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * The class creates a panel with new messages for the programs user.
 * @author Fredrik N�rell
 *
 */
public class MessagePanel extends JPanel implements ActionListener  {
	
	/*
	 * Class variables
	 */
	private JButton newMessageButton = new JButton("New Message");
	private JButton editMessageButton = new JButton ("Edit");
	private JButton deleteMessageButton = new JButton ("Delete");
	private JPanel textPanel = new JPanel();
	private JPanel buttonsPanel= new JPanel();
	private JTextArea txt = new JTextArea();
	
	private JPanel newMessagePanel = new JPanel();
	private JTextField titleField = new JTextField(15);
	private JTextField recipientField = new JTextField(15);
	private JTextArea messageArea = new JTextArea();
	private JLabel titleLabel = new JLabel("Title");
	private JLabel recipientLabel = new JLabel ("Recipient");
	private JButton sendNewMessage = new JButton("Send");
	
	private JPanel editMessagePanel = new JPanel();
	private JButton editMessage = new JButton("Edit");
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
		}else{
			if(e.getSource()==editMessageButton){
				JFrame editMessageFrame = new JFrame("Edit Message");
				editMessageFrame.setLayout(null);
				editMessageFrame.setPreferredSize(new Dimension(500, 500));
				
				newMessagePanel.setSize(500, 500);
				newMessagePanel.setLayout(null);
				
				recipientLabel.setBounds(100,50,120,20);
				recipientField.setBounds(200,50,120,20);
				
				titleLabel.setBounds(100,70,120,20);
				titleField.setBounds(200,70,120,20);
				
				messageArea.setBounds(100,100,280,300);
				
				sendNewMessage.setBounds(100,420,80,25);

				editMessagePanel.add(titleLabel);
				editMessagePanel.add(recipientLabel);
				editMessagePanel.add(titleField);
				editMessagePanel.add(recipientField);
				editMessagePanel.add(messageArea);
				editMessagePanel.add(sendNewMessage);
				
				
				
				editMessageFrame.add(newMessagePanel);
				editMessageFrame.pack();
				editMessageFrame.setLocationRelativeTo(null);
				editMessageFrame.setVisible(true);
			}else{
				if(e.getSource()==deleteMessageButton){
					JFrame deleteFrame = new JFrame("Delete Message");
					deleteFrame.setSize(500, 500);
					deleteFrame.setLocationRelativeTo(null);
					deleteFrame.setVisible(true);
//					deleteFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
	
}