package network.client.GUI.panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MessagePanel extends JPanel  {
	
	private JButton newMessage = new JButton("New Message");
	private JButton edit = new JButton ("Edit");
	private JButton delete = new JButton ("Delete");
	private JPanel centerPanel = new JPanel();
//	private JOPtion;

	public MessagePanel(){
		super();
		setBorder(BorderFactory.createTitledBorder("Message view"));
		
		//Sizes
//		centerPanel.setSize(100,100);
		newMessage.setSize(30,60);
		edit.setSize(30,60);
		delete.setSize(30,60);
		
		//Adding
		listeners();
		add(newMessage);
		add(edit);
		add(delete);
		
		
		//settings
		setVisible(true);
	}
	
	public void listeners(){
		ButtonListener buttlist = new ButtonListener();
		newMessage.addActionListener(buttlist);
		
	}
	private class ButtonListener implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			
//			String actionString = e.getActionCommand();
			if(newMessage.isSelected()){
			JFrame newMessageFrame = new JFrame("New Message");
			}
		}
		
	}
}
