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

public class MessagePanel extends JPanel  {
	
	private JButton newMessage = new JButton("New Message");
	private JButton edit = new JButton ("Edit");
	private JButton delete = new JButton ("Delete");
	private JPanel textPanel = new JPanel();
	private JPanel buttonsPanel= new JPanel();
	private JTextArea txt = new JTextArea();
//	private String[] theOptions = new String[]{"A", "B", "C"};
//	private JComboBox theBox  = new JComboBox(theOptions);
	

	
	public MessagePanel(){
		super();
		
		setBorder(BorderFactory.createTitledBorder("Message view"));
		
		//Sizes
		
		txt.setPreferredSize(new Dimension(300,300));
		
		buttonsPanel.setLayout(new BorderLayout());
		
		
		
		buttonsPanel.add(newMessage, BorderLayout.NORTH);
		buttonsPanel.add(delete, BorderLayout.CENTER);
		buttonsPanel.add(edit, BorderLayout.SOUTH);
		
		textPanel.add(txt,BorderLayout.CENTER);
		
		
		//Adding
		listeners();
		add(buttonsPanel, BorderLayout.WEST);
		add(textPanel, BorderLayout.CENTER);
		
		
		
		
		
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
