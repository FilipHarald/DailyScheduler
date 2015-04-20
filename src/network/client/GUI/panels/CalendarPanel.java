package network.client.GUI.panels;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalendarPanel extends JPanel implements ActionListener {
    
    private JDateChooser jdcDate = new JDateChooser();
    
    private JFrame frmNewEvent = new JFrame("New event");
    private JFrame frmEditEvent = new JFrame("Edit event");
    private JFrame frmSearchEvent = new JFrame("Search event"); 

    private JButton btnAddEvent = new JButton("Add new event");
    private JButton btnEditEvent = new JButton("Edit event");
    private JButton btnDeleteEvent = new JButton("Delete");
    private JButton btnSaveEvent = new JButton("Save");
    private JButton btnSearch = new JButton ("Search");

    private JLabel lblTitle = new JLabel("Title");
    private JLabel lblDate = new JLabel("Date");
    private JLabel lblDescription = new JLabel("Description");
    private JLabel lblParticipants = new JLabel("Participants");
    private JLabel lblSearch = new JLabel("Type the eventID you wish to search for");
    
    private JTextField tfTitle = new JTextField(15);
    private JTextField tfDate = new JTextField(15);
    private JTextField tfSearch = new JTextField(15);
    private JTextArea taDescription = new JTextArea();
    private JTextArea taParticipants = new JTextArea();

    private JPanel pnlButton = new JPanel();
    private JPanel pnlNewEvent = new JPanel();
    private JPanel pnlEditEvent = new JPanel();
    private JPanel pnlSearchEvent = new JPanel();

    public CalendarPanel() {
        super();
        setBorder(BorderFactory.createTitledBorder("Calendar view"));

        pnlButton.setLayout(new BorderLayout());
        pnlButton.add(btnAddEvent, BorderLayout.NORTH);
        pnlButton.add(btnEditEvent, BorderLayout.CENTER);
        
        add(pnlButton, BorderLayout.CENTER);

        pnlNewEvent.setLayout(new BorderLayout());
        pnlNewEvent.add(tfTitle, BorderLayout.NORTH);
        listeners();
    }

    public void listeners() {

        btnAddEvent.addActionListener(this);
        btnEditEvent.addActionListener(this);
        btnDeleteEvent.addActionListener(this);
        btnSaveEvent.addActionListener(this);

    }

    private void renderNewEvent() {
        frmNewEvent.setLayout(null);
        frmNewEvent.setMinimumSize(new Dimension(600, 600));

        pnlNewEvent.setSize(600, 600);
        pnlNewEvent.setLayout(null);

        lblTitle.setBounds(70, 50, 80, 20);
        tfTitle.setBounds(170, 50, 180, 20);

        lblDate.setBounds(70, 80, 80, 20);
        jdcDate.setBounds(170, 80, 180, 20);

        lblDescription.setBounds(70, 20, 80, 200);
        taDescription.setBounds(170, 110, 280, 200);

        lblParticipants.setBounds(70, 290, 80, 100);
        taParticipants.setBounds(170, 330, 280, 100);

        btnSaveEvent.setBounds(175, 480, 100, 25);

        pnlNewEvent.add(lblTitle);
        pnlNewEvent.add(tfTitle);
        pnlNewEvent.add(lblDate);
        pnlNewEvent.add(jdcDate);
        pnlNewEvent.add(lblDescription);
        pnlNewEvent.add(taDescription);
        pnlNewEvent.add(lblParticipants);
        pnlNewEvent.add(taParticipants);
        pnlNewEvent.add(btnSaveEvent);

        frmNewEvent.add(pnlNewEvent);
        frmNewEvent.setLocationRelativeTo(null);
        frmNewEvent.pack();
        frmNewEvent.setVisible(true);

    }

    private void renderEditEvent() {
        frmEditEvent.setLayout(null);
        frmEditEvent.setMinimumSize(new Dimension(600, 600));

        pnlEditEvent.setSize(600, 600);
        pnlEditEvent.setLayout(null);

        lblTitle.setBounds(70, 50, 80, 20);
        tfTitle.setBounds(170, 50, 180, 20);

        lblDate.setBounds(70, 80, 80, 20);
        jdcDate.setBounds(170, 80, 180, 20);

        lblDescription.setBounds(70, 20, 80, 200);
        taDescription.setBounds(170, 110, 280, 200);

        lblParticipants.setBounds(70, 290, 80, 100);
        taParticipants.setBounds(170, 330, 280, 100);

        btnSaveEvent.setBounds(175, 480, 100, 25);
        btnDeleteEvent.setBounds(340, 480, 100, 25);
        
        pnlEditEvent.add(lblTitle);
        pnlEditEvent.add(tfTitle);
        pnlEditEvent.add(lblDate);
        pnlEditEvent.add(jdcDate);
        pnlEditEvent.add(lblDescription);
        pnlEditEvent.add(taDescription);
        pnlEditEvent.add(lblParticipants);
        pnlEditEvent.add(taParticipants);
        pnlEditEvent.add(btnSaveEvent);
        pnlEditEvent.add(btnDeleteEvent);
        
        frmEditEvent.add(pnlEditEvent);
        frmEditEvent.setLocationRelativeTo(null);
        frmEditEvent.pack();
        frmEditEvent.setVisible(true);

    }
    
    private void renderSearchEvent(){
        frmSearchEvent.setLayout(null);
        frmSearchEvent.setMinimumSize(new Dimension(600, 300));
        
        pnlSearchEvent.setLayout(null);
        pnlSearchEvent.setSize(600, 300);
        
        lblSearch.setBounds(150, 50, 300, 30);
        tfSearch.setBounds(100, 80, 350, 30);
        
        pnlSearchEvent.add(lblSearch);
        pnlSearchEvent.add(tfSearch);
        
        frmSearchEvent.add(pnlSearchEvent);
        frmSearchEvent.setLocationRelativeTo(null);
        frmSearchEvent.pack();
        frmSearchEvent.setVisible(true);
        
    }
    
    
    
    private void clearFields(){
        tfTitle.setText(null);
        jdcDate.setDate(null);
        taDescription.setText(null);
        taParticipants.setText(null);
        
    }
    private void setLabels(){
        lblTitle.setText("Title");
        lblDate.setText("Date");
        lblDescription.setText("Description");
        lblParticipants.setText("Participants");
                
    }
    
    private boolean isEmpty(){
        boolean isEmpty = false;
        
        if(tfTitle.getText().trim().isEmpty()){
            lblTitle.setText("Title *");
            isEmpty= true;
            
        } 
        if (jdcDate.getDate() == null){
            lblDate.setText("Date *");
            isEmpty= true;
            
        }
        if(taDescription.getText().trim().isEmpty()){
            lblDescription.setText("Description *");
            isEmpty= true;
            
        }
        
        if(taParticipants.getText().trim().isEmpty()){
            lblParticipants.setText("Participants *");
            isEmpty= true;
        }
        
        return isEmpty;
        
    } 

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if ((button) == btnAddEvent) {
            setLabels();
            clearFields();
            renderNewEvent();
                    
        } else if ((button) == btnEditEvent) {
            //TODO: add display event
            renderSearchEvent();
            setLabels();
            clearFields();
            renderEditEvent();

        } else if ((button) == btnDeleteEvent) {
            //JOptionPane.showMessageDialog(null, "Do you wish to delete event: " + tfTitle.getText() + "?");
            int delete = JOptionPane.showConfirmDialog(null, "Do you wish to delete event: " + tfTitle.getText() + "?", null, JOptionPane.YES_NO_OPTION);
            if (delete == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "The event has been deleted");
                //TODO: delete event from database
                frmNewEvent.dispose();
                frmEditEvent.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "The event will not be deleted");
                
            }
            

        } else if ((button) == btnSaveEvent) {
            setLabels();
            if(isEmpty() == true){
                JOptionPane.showMessageDialog(null, "Please fill in all of the fields marked with an astrerisk");
            } else {
                //TODO: save event to database
                frmNewEvent.dispose();
                frmEditEvent.dispose();
            }
            
            
           
            

        }

    }

    public void displayEvent() {

    }

    //get description from textarea
    public String getDescription() {
        return taDescription.getText();
    }
}
