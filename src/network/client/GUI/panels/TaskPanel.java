package network.client.GUI.panels;
import java.awt.*;

import javax.swing.*;

public class TaskPanel extends JPanel {
	
	private JPanel labelpanel = new JPanel (new GridLayout(1,1));
	private JPanel labelinputpanel = new JPanel (new GridLayout(1,1));
	private JPanel labelcombobtnpanel = new JPanel (new GridLayout(1,1));

	
	public TaskPanel(){
		super();
		setLayout (new BorderLayout());
		setBorder(BorderFactory.createTitledBorder("Task view"));
		setPreferredSize (new Dimension (200, 10));

		AddLabels();
		AddButtons();
		AddTextArea();
		
	}
	
	public void AddButtons() {
		labelcombobtnpanel.setSize(1, 5);
		labelcombobtnpanel.setPreferredSize(new Dimension(1, 5));
		
		JButton btncreatenewtask = new JButton ("New Task");
		JButton btnedittask = new JButton("Edit Task");
		JButton btndeletetask = new JButton ("Delete Task");
		JComboBox comboincompletedtask = new JComboBox ();
		JComboBox combocompletedtask = new JComboBox ();
		
		labelcombobtnpanel.add(comboincompletedtask);
		labelcombobtnpanel.add(combocompletedtask);
		labelcombobtnpanel.add(btncreatenewtask);
		labelcombobtnpanel.add(btnedittask);
		labelcombobtnpanel.add(btndeletetask);
		
		add (labelcombobtnpanel, BorderLayout.CENTER);
	}
	
	public void AddLabels (){
		labelpanel.setSize(10, 100);
		labelpanel.setPreferredSize(new Dimension(10, 100));
		
		JLabel lblincomplete = new JLabel ("Incompleted task");
		JLabel lblcompletedtask = new JLabel ("Completed task");
		JComboBox comboincompletedtask = new JComboBox ();
		JComboBox combocompletedtask = new JComboBox ();
		
		labelpanel.add(lblincomplete);
		labelpanel.add(lblcompletedtask);
	
		add (labelpanel, BorderLayout.NORTH);
		
	}
	
	public void AddTextArea (){
		labelinputpanel.setSize(50, 250);
		labelinputpanel.setPreferredSize(new Dimension(50, 250));
		
		JTextArea textdescription = new JTextArea();
		labelinputpanel.add(textdescription);
		add (labelinputpanel, BorderLayout.SOUTH);
	}
	

	
	
}
