package network.client.GUI.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalendarPanel extends JPanel implements ActionListener {

    private JFrame newEventFrame = new JFrame("New event");
    private JFrame editEventFrame = new JFrame("Edit event");

    private JButton btnAddEvent = new JButton("Add new event");
    private JButton btnEditEvent = new JButton("Edit event");
    private JButton btnDeleteEvent = new JButton("Delete");
    private JButton btnSaveEvent = new JButton("Save");

    private JLabel lblTitle = new JLabel("Title");
    private JLabel lblDate = new JLabel("Date");
    private JLabel lblDescription = new JLabel("Description");
    private JLabel lblParticipants = new JLabel("Participants");

    private JTextField tfTitle = new JTextField(15);
    private JTextField tfDate = new JTextField(15);
    private JTextArea taDescription = new JTextArea();
    private JTextArea taParticipants = new JTextArea();

    private JPanel buttonPanel = new JPanel();
    private JPanel newEventPanel = new JPanel();
    private JPanel editEventPanel = new JPanel();

    public CalendarPanel() {
        super();
        setBorder(BorderFactory.createTitledBorder("Calendar view"));

        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(btnAddEvent, BorderLayout.NORTH);
        buttonPanel.add(btnEditEvent, BorderLayout.CENTER);
        
        add(buttonPanel, BorderLayout.CENTER);

        newEventPanel.setLayout(new BorderLayout());
        newEventPanel.add(tfTitle, BorderLayout.NORTH);
        listeners();
    }

    public void listeners() {

        btnAddEvent.addActionListener(this);
        btnEditEvent.addActionListener(this);
        btnDeleteEvent.addActionListener(this);
        btnSaveEvent.addActionListener(this);

    }

    public void renderNewEvent() {
        newEventFrame.setLayout(null);
        newEventFrame.setMinimumSize(new Dimension(600, 600));

        newEventPanel.setSize(600, 600);
        newEventPanel.setLayout(null);

        lblTitle.setBounds(70, 50, 80, 20);
        tfTitle.setBounds(170, 50, 180, 20);

        lblDate.setBounds(70, 80, 80, 20);
        tfDate.setBounds(170, 80, 180, 20);

        lblDescription.setBounds(70, 20, 80, 200);
        taDescription.setBounds(170, 110, 280, 200);

        lblParticipants.setBounds(70, 290, 80, 100);
        taParticipants.setBounds(170, 330, 280, 100);

        btnSaveEvent.setBounds(175, 480, 100, 25);
        btnDeleteEvent.setBounds(340, 480, 100, 25);

        newEventPanel.add(lblTitle);
        newEventPanel.add(tfTitle);
        newEventPanel.add(lblDate);
        newEventPanel.add(tfDate);
        newEventPanel.add(lblDescription);
        newEventPanel.add(taDescription);
        newEventPanel.add(lblParticipants);
        newEventPanel.add(taParticipants);
        newEventPanel.add(btnSaveEvent);
        newEventPanel.add(btnDeleteEvent);

        newEventFrame.add(newEventPanel);
        newEventFrame.setLocationRelativeTo(null);
        newEventFrame.pack();
        newEventFrame.setVisible(true);

    }

    private void renderEditEvent() {
        editEventFrame.setLayout(null);
        editEventFrame.setMinimumSize(new Dimension(600, 600));

        editEventPanel.setSize(600, 600);
        editEventPanel.setLayout(null);

        lblTitle.setBounds(70, 50, 80, 20);
        tfTitle.setBounds(170, 50, 180, 20);

        lblDate.setBounds(70, 80, 80, 20);
        tfDate.setBounds(170, 80, 180, 20);

        lblDescription.setBounds(70, 20, 80, 200);
        taDescription.setBounds(170, 110, 280, 200);

        lblParticipants.setBounds(70, 290, 80, 100);
        taParticipants.setBounds(170, 330, 280, 100);

        btnSaveEvent.setBounds(175, 480, 100, 25);
        btnDeleteEvent.setBounds(340, 480, 100, 25);

        editEventPanel.add(lblTitle);
        editEventPanel.add(tfTitle);
        editEventPanel.add(lblDate);
        editEventPanel.add(tfDate);
        editEventPanel.add(lblDescription);
        editEventPanel.add(taDescription);
        editEventPanel.add(lblParticipants);
        editEventPanel.add(taParticipants);
        editEventPanel.add(btnSaveEvent);
        editEventPanel.add(btnDeleteEvent);

        editEventFrame.add(editEventPanel);
        editEventFrame.setLocationRelativeTo(null);
        editEventFrame.pack();
        editEventFrame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if ((button) == btnAddEvent) {
            renderNewEvent();
//            
        } else if ((button) == btnEditEvent) {
            //TODO: add display event
            renderEditEvent();

        } else if ((button) == btnDeleteEvent) {
            //JOptionPane.showMessageDialog(null, "Do you wish to delete event: " + tfTitle.getText() + "?");
            int delete = JOptionPane.showConfirmDialog(null, "Do you wish to delete event: " + tfTitle.getText() + "?", null, JOptionPane.YES_NO_OPTION);
            if (delete == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "The event has been deleted");
                newEventFrame.dispose();
                editEventFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "The event will not be deleted");
                
            }
            //TODO: delete event from database

        } else if ((button) == btnSaveEvent) {
            //TODO: save event to database
            

        }

    }

    public void displayEvent() {

    }

    //get description from textarea
    public String getDescription() {
        return taDescription.getText();
    }
}
