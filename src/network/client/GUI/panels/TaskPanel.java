package network.client.GUI.panels;
import java.awt.*;

import javax.swing.*;

public class TaskPanel extends JPanel {
	
	private JList listCompletedTask = new JList ();
	private JList listIncompletedTask = new JList();
	private JTextArea textDescription = new JTextArea();
	
	
	public TaskPanel(){
		super();
		setLayout (new BorderLayout());
		setBorder(BorderFactory.createTitledBorder("Task view"));
		AddTasks();
		AddButtons();
		AddTextArea();
		
	}
	
	public void AddTasks() {
		JPanel tasksPanel = new JPanel(new GridLayout(0, 2));
		tasksPanel.setPreferredSize(new Dimension(300, 200));
		JScrollPane scrollerCompletedTask = new JScrollPane (listCompletedTask);
		JScrollPane scrollerIncompletedTask = new JScrollPane (listIncompletedTask);
		tasksPanel.setBorder(BorderFactory.createTitledBorder(""));
		
		JPanel panelCompletedTask = new JPanel ();
		panelCompletedTask.setPreferredSize(new Dimension(200, 100));
		
		JLabel lblCompletedTask = new JLabel ("Completed tasks");
		
		panelCompletedTask.setBorder(BorderFactory.createTitledBorder(""));
		scrollerCompletedTask.setPreferredSize(new Dimension(200,100));

		panelCompletedTask.add(lblCompletedTask);
		panelCompletedTask.add(listCompletedTask);
		panelCompletedTask.add(scrollerCompletedTask);
		
		
		
		JPanel panelIncompletedTask = new JPanel ();
		scrollerIncompletedTask.setPreferredSize(new Dimension(200, 100));

		JLabel lblIncompleted = new JLabel ("Incompleted tasks");
		
		panelIncompletedTask.setBorder(BorderFactory.createTitledBorder(""));
		scrollerIncompletedTask.setPreferredSize(new Dimension(200,100));
	
		panelIncompletedTask.add(lblIncompleted);
		panelIncompletedTask.add(listIncompletedTask);
		panelIncompletedTask.add(scrollerIncompletedTask);
		
		tasksPanel.add (panelIncompletedTask);
		tasksPanel.add(panelCompletedTask);
		
		add (tasksPanel, BorderLayout.NORTH);
	}
	
	public void AddButtons() {
		JPanel labelBtnPanel = new JPanel ();
		labelBtnPanel.setPreferredSize(new Dimension(5,5));
	
		
		JButton btnCreateNewTask = new JButton ("New Task");
		JButton btnEditTask = new JButton("Edit Task");
		JButton btnDeleteTask = new JButton ("Delete Task");

		labelBtnPanel.add(btnCreateNewTask);
		labelBtnPanel.add(btnEditTask);
		labelBtnPanel.add(btnDeleteTask);
		
		add (labelBtnPanel, BorderLayout.CENTER);
	}

	
	public void AddTextArea (){
		JPanel labelInputPanel = new JPanel (new GridLayout(1,1));
		labelInputPanel.setSize(700, 300);
		labelInputPanel.setPreferredSize(new Dimension(700, 300));
		labelInputPanel.add(textDescription);
		
		add (labelInputPanel, BorderLayout.SOUTH);
	}

    public void displayTask() {
               
        
    }
    
    //get description from textarea
    public String getDescription() {
        return textDescription.getText();
    }
	

	
	
}
