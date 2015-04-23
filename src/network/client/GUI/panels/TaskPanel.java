package network.client.GUI.panels;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import network.client.controllers.TaskController;
import entities.Task;

public class TaskPanel extends JPanel implements ActionListener {
	private TaskController taskC;
	
	//For create new task:
	private JButton btnCreateNewTask = new JButton ("New Task");
	private JPanel newTaskPanel = new JPanel();
	private JScrollPane subTaskScroll = new JScrollPane();
	private JButton saveTask = new JButton("Save");
	private JButton btnAddSubTask = new JButton("Add subtask");
	
	//For edit task:
	private JButton btnEditTask = new JButton("Edit Task");
	private JPanel editTaskPanel = new JPanel();
	private JButton editTask = new JButton("Save changes");
	
	//For delete task:
	private JButton btnDeleteTask = new JButton ("Delete Task");
	private JPanel deleteTaskPanel = new JPanel();
	private JButton deleteTask = new JButton("Delete task");
	
	//For add subtask:
	private JButton saveSubTask = new JButton("Save subtask");
	private JPanel addSubTaskPanel = new JPanel();
	private JLabel descriptionLabel = new JLabel ("Description");
	
	
	private JList <String> listCompletedTask = new JList ();
	private JList<String> listIncompletedTask = new JList();
	
	private JTextArea textDescription = new JTextArea();
	private JTextArea descriptionArea = new JTextArea();
	
	private JTextField titleField = new JTextField(15);
	
	private JLabel titleLabel = new JLabel("Title");

	private JButton btnCancel = new JButton ("Cancel");
	

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
		btnAddSubTask.addActionListener(this);
		
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
			
			descriptionArea.setBounds(100,100,280,180);
			subTaskScroll.setBounds(100, 300, 200, 80);
			
			saveTask.setBounds(220,420,80,25);
			btnAddSubTask.setBounds(100, 420, 120, 25);
			btnCancel.setBounds(300, 420, 80, 25);
			
			newTaskPanel.add(titleLabel);
			newTaskPanel.add(titleField);
			newTaskPanel.add(descriptionArea);
			newTaskPanel.add(subTaskScroll);
			newTaskPanel.add(saveTask);
			newTaskPanel.add(btnAddSubTask);
			newTaskPanel.add(btnCancel);
			
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
			btnCancel.setBounds(300, 420, 80, 25);
			
			editTaskPanel.add(titleLabel);
			editTaskPanel.add(titleField);
			editTaskPanel.add(descriptionArea);
			editTaskPanel.add(editTask);
			editTaskPanel.add(btnCancel);
			
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
			btnCancel.setBounds(300, 420, 80, 25);
			
			deleteTaskPanel.add(titleLabel);
			deleteTaskPanel.add(titleField);
			deleteTaskPanel.add(descriptionArea);
			deleteTaskPanel.add(deleteTask);
			deleteTaskPanel.add(btnCancel);
			
			deleteTaskFrame.add(deleteTaskPanel);
			deleteTaskFrame.pack();
			deleteTaskFrame.setLocationRelativeTo(null);
			deleteTaskFrame.setVisible(true);
    	}
    	if (e.getSource() == btnAddSubTask) {
    		
    		JFrame addSubTaskFrame = new JFrame("Add Subtask");
			addSubTaskFrame.setLayout(null);
			addSubTaskFrame.setPreferredSize(new Dimension(500, 500));
			
			addSubTaskPanel.setSize(500, 500);
			addSubTaskPanel.setLayout(null);
    		
    		descriptionArea.setBounds(100,100,280,180);
    		descriptionLabel.setBounds(20, 20, 280, 180);
    		saveSubTask.setBounds(100, 420, 120, 30);
    		btnCancel.setBounds(300, 420, 80, 25);
    		
    		addSubTaskPanel.add(descriptionArea);
    		addSubTaskPanel.add(descriptionLabel);
    		addSubTaskPanel.add(saveSubTask);
    		addSubTaskPanel.add(btnCancel);
    		
    		addSubTaskFrame.add(addSubTaskPanel);
			addSubTaskFrame.pack();
			addSubTaskFrame.setLocationRelativeTo(null);
			addSubTaskFrame.setVisible(true);
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
