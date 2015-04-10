
package network.client.GUI.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * The class creates a panel with new messages for the programs user.
 * @author Fredrik Nörell
 *
 */
public class MessagePanel extends JPanel  {
	
	/*
	 * Class variables
	 */
	private JButton newMessage = new JButton("New Message");
	private JButton edit = new JButton ("Edit");
	private JButton delete = new JButton ("Delete");
	private JPanel textPanel = new JPanel();
	private JPanel buttonsPanel= new JPanel();
	private JTextArea txt = new JTextArea();
	

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
		buttonsPanel.add(newMessage, BorderLayout.NORTH);
		buttonsPanel.add(delete, BorderLayout.CENTER);
		buttonsPanel.add(edit, BorderLayout.SOUTH);
		
		textPanel.add(txt,BorderLayout.CENTER);
		
		/*
		 * Preferred size for the textarea where the selected message will be displayed.
		 */
		txt.setPreferredSize(new Dimension(300,300));
		
		
		/*
		 * Adding the panels to the MessagePanel created by ApplicationGUI
		 */
		listeners();
		add(buttonsPanel, BorderLayout.WEST);
		add(textPanel, BorderLayout.CENTER);
		
		
		
		
		
	}
	
	/**
	 * Listener for the JButtons in the buttonsPanel.
	 */
	public void listeners(){
		ButtonListener buttlist = new ButtonListener();
		newMessage.addActionListener(buttlist);
		
	}
	/**
	 * Private class containing the ActionListener for the method ButtonListener.
	 * @author Fredrik Nörell
	 *
	 */
	private class ButtonListener implements ActionListener{

		/**
		 * Method for the performed actions by the user.
		 */
		public void actionPerformed(ActionEvent e) {
			if(newMessage.isSelected()){
			JFrame newMessageFrame = new JFrame("New Message");
			}
		}
		
	}
}
