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
 * @author Fredrik N�rell
 *
 */
public class MessagePanel extends JPanel implements ActionListener  {
	
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
		txt.setPreferredSize(new Dimension(300,300));
		
		add(buttonsPanel, BorderLayout.WEST);
		add(textPanel, BorderLayout.CENTER);
		listeners();
		}
	
	
	
	
	/**
	 * Listener for the JButtons in the buttonsPanel.
	 */
	public void listeners(){
		
		newMessage.addActionListener(this);
		delete.addActionListener(this);
		edit.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==newMessage){
			JFrame newMessageFrame = new JFrame("New Message");
			newMessageFrame.setSize(500, 500);
			newMessageFrame.setLocationRelativeTo(null);
			newMessageFrame.setVisible(true);
//			newMessageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}else{
			if(e.getSource()==edit){
				JFrame editFrame = new JFrame("Edit Message");
				editFrame.setSize(500, 500);
				editFrame.setLocationRelativeTo(null);
				editFrame.setVisible(true);
//				editFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}else{
				if(e.getSource()==delete){
					JFrame deleteFrame = new JFrame("Delete Message");
					deleteFrame.setSize(500, 500);
					deleteFrame.setLocationRelativeTo(null);
					deleteFrame.setVisible(true);
//					deleteFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				}
			}
		}
	}
	
}