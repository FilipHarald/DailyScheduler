package network.client.GUI.panels;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import network.client.controllers.TaskController;
import entities.Task;

public class TaskPanel extends JPanel implements ActionListener {
	private TaskController taskC;
	
	private JButton btnCreateNewTask = new JButton ("New Task");
	private JButton btnEditTask = new JButton("Edit Task");
	private JButton btnDeleteTask = new JButton ("Delete Task");
	
	private JList <String> listCompletedTask = new JList ();
	private JList<String> listIncompletedTask = new JList();
	
	private JTextArea textDescription = new JTextArea();
	private JTextArea descriptionArea = new JTextArea();
	
	private JTextField titleField = new JTextField(15);
	
	private JPanel newTaskPanel = new JPanel();
	private JPanel editTaskPanel = new JPanel();
	private JPanel deleteTaskPanel = new JPanel();
	
	private JLabel titleLabel = new JLabel("Title");
	
	private JButton saveTask = new JButton("Save");
	private JButton editTask = new JButton("Save changes");
	private JButton deleteTask = new JButton("Delete task");
	
	public TaskPanel(){
		super();
		setLayout (new BorderLayout());
		setBorder(BorderFactory.createTitledBorder("Task view"));
		AddTasks();
		AddButtons();
		AddTextArea();
		btnCreateNewTask.addActionListener(this);
		btnEditTask.addActionListener(this);
		btnDeleteTask.addActionListener(this);
		
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
	
		
//		JButton btnCreateNewTask = new JButton ("New Task");
//		JButton btnEditTask = new JButton("Edit Task");
//		JButton btnDeleteTask = new JButton ("Delete Task");

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

    public void actionPerformed (ActionEvent e){
    	if (e.getSource() == btnCreateNewTask) {
    		JFrame newTaskFrame = new JFrame("New Task");
			newTaskFrame.setLayout(null);
			newTaskFrame.setPreferredSize(new Dimension(500, 500));
			
			newTaskPanel.setSize(500, 500);
			newTaskPanel.setLayout(null);
			
			titleLabel.setBounds(100,70,120,20);
			titleField.setBounds(200,70,120,20);
			
			descriptionArea.setBounds(100,100,280,300);
			
			saveTask .setBounds(100,420,80,25);

			newTaskPanel.add(titleLabel);
			newTaskPanel.add(titleField);
			newTaskPanel.add(descriptionArea);
			newTaskPanel.add(saveTask);
			
			newTaskFrame.add(newTaskPanel);
			newTaskFrame.pack();
			newTaskFrame.setLocationRelativeTo(null);
			newTaskFrame.setVisible(true);
			
    	} else if (e.getSource() == btnEditTask){
    		JFrame editTaskFrame = new JFrame("Edit Task");
			editTaskFrame.setLayout(null);
			editTaskFrame.setPreferredSize(new Dimension(500, 500));
			
			editTaskPanel.setSize(500, 500);
			editTaskPanel  .setLayout(null);
			
			titleLabel.setBounds(100,70,120,20);
			titleField.setBounds(200,70,120,20);
			
			descriptionArea.setBounds(100,100,280,300);
			
			editTask.setBounds(100,420,120,30);

			editTaskPanel.add(titleLabel);
			editTaskPanel.add(titleField);
			editTaskPanel.add(descriptionArea);
			editTaskPanel.add(editTask);
			
			editTaskFrame.add(editTaskPanel);
			editTaskFrame.pack();
			editTaskFrame.setLocationRelativeTo(null);
			editTaskFrame.setVisible(true);
			
    	} else if (e.getSource() == btnDeleteTask){
    		JFrame deleteTaskFrame = new JFrame("Delete Task");
			deleteTaskFrame.setLayout(null);
			deleteTaskFrame.setPreferredSize(new Dimension(500, 500));
			
			deleteTaskPanel.setSize(500, 500);
			deleteTaskPanel.setLayout(null);
			
			titleLabel.setBounds(100,70,120,20);
			titleField.setBounds(200,70,120,20);
			
			descriptionArea.setBounds(100,100,280,300);
			
			deleteTask.setBounds(100,420,120,30);

			deleteTaskPanel.add(titleLabel);
			deleteTaskPanel.add(titleField);
			deleteTaskPanel.add(descriptionArea);
			deleteTaskPanel.add(deleteTask);
			
			deleteTaskFrame.add(deleteTaskPanel);
			deleteTaskFrame.pack();
			deleteTaskFrame.setLocationRelativeTo(null);
			deleteTaskFrame.setVisible(true);
    	}
    }

    public String getTitle(){
    	return titleField.getText();
    }
    
    //get description from textarea
    public String getDescription() {
        return textDescription.getText();
    }
    
    public void taskListDisplayIncompleted (Task task){
    	listIncompletedTask.setModel((ListModel) taskC.displayTaskList(task));
    }
    
    public void taskListDisplayCompleted (Task task){
    	listCompletedTask.setModel((ListModel) taskC.displayTaskList(task));
    }
    
    public void displayTask (Task task){
    	
    }

	
	
}
