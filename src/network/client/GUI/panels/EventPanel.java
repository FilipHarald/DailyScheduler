package network.client.GUI.panels;

import com.toedter.calendar.JDateChooser;
import entities.Event;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import javax.swing.*;
import miscellaneous.UsernameAndPwdPair;
import network.client.controllers.ClientController;
import network.client.controllers.EventController;

/**
 *
 * @author Aya
 */
public class EventPanel extends JPanel implements ActionListener {

    private EventController ec;
    private UsernameAndPwdPair unP;
    private Event event;

    //initialize JComponents
    private JDateChooser jdcDate = new JDateChooser();

    private JList lstEvents = new JList();

    private JScrollPane jspList = new JScrollPane(lstEvents);

    private JFrame frmNewEvent = new JFrame("New event");
    private JFrame frmEditEvent = new JFrame("Edit event");
    private JFrame frmSearchEvent = new JFrame("Search event");

    private JButton btnAddEvent = new JButton("Add new event");
    private JButton btnEditEvent = new JButton("Edit event");
    private JButton btnDeleteEvent = new JButton("Delete");
    private JButton btnSaveEvent = new JButton("Save");
    private JButton btnSearch = new JButton("Search");

    private JLabel lblDescription = new JLabel("Title");
    private JLabel lblDate = new JLabel("Date");
    private JLabel lblSearch = new JLabel("Type the eventID you wish to search for");

    private JTextField tfDescription = new JTextField(15);
    private JTextField tfDate = new JTextField(15);

    private JPanel pnlButton = new JPanel();
    private JPanel pnlNewEvent = new JPanel();
    private JPanel pnlEditEvent = new JPanel();
    private JPanel pnlSearchEvent = new JPanel();

    /**
     * constructor: set layout and add panel
     * @param ec 
     */
        public EventPanel(EventController ec) {
        super();
        this.ec = ec;
        setBorder(BorderFactory.createTitledBorder("Event view"));

        pnlButton.setLayout(new BorderLayout());
        pnlButton.add(btnAddEvent, BorderLayout.NORTH);
        pnlButton.add(btnEditEvent, BorderLayout.CENTER);

        add(pnlButton, BorderLayout.CENTER);

        pnlNewEvent.setLayout(new BorderLayout());
        pnlNewEvent.add(tfDescription, BorderLayout.NORTH);
        listeners();
    }

    
     //add listeners to buttons/list
        public void listeners() {

        btnAddEvent.addActionListener(this);
        btnEditEvent.addActionListener(this);
        btnDeleteEvent.addActionListener(this);
        btnSaveEvent.addActionListener(this);
        btnSearch.addActionListener(this);
        lstEvents.addMouseListener(mouseEvent);

    }

    //render frame for new event
    private void renderNewEvent() {
        frmNewEvent.setLayout(null);
        frmNewEvent.setMinimumSize(new Dimension(450, 250));

        pnlNewEvent.setSize(450, 250);
        pnlNewEvent.setLayout(null);

        lblDescription.setBounds(80, 50, 80, 20);
        tfDescription.setBounds(140, 50, 220, 20);

        lblDate.setBounds(80, 80, 80, 20);
        jdcDate.setBounds(140, 80, 220, 20);

        btnSaveEvent.setBounds(140, 150, 100, 25);

        pnlNewEvent.add(lblDescription);
        pnlNewEvent.add(tfDescription);
        pnlNewEvent.add(lblDate);
        pnlNewEvent.add(jdcDate);

        pnlNewEvent.add(btnSaveEvent);

        frmNewEvent.add(pnlNewEvent);
        frmNewEvent.setLocationRelativeTo(null);
        frmNewEvent.pack();
        frmNewEvent.setVisible(true);

    }

    //render frame for edit event
    private void renderEditEvent() {
        frmEditEvent.setLayout(null);
        frmEditEvent.setMinimumSize(new Dimension(450, 250));

        pnlEditEvent.setSize(450, 250);
        pnlEditEvent.setLayout(null);

        lblDescription.setBounds(80, 50, 80, 20);
        tfDescription.setBounds(140, 50, 220, 20);

        lblDate.setBounds(80, 80, 80, 20);
        jdcDate.setBounds(140, 80, 220, 20);

        btnSaveEvent.setBounds(140, 150, 100, 25);

        pnlEditEvent.add(lblDescription);
        pnlEditEvent.add(tfDescription);
        pnlEditEvent.add(lblDate);
        pnlEditEvent.add(jdcDate);

        pnlEditEvent.add(btnSaveEvent);

        frmEditEvent.add(pnlEditEvent);
        frmEditEvent.setLocationRelativeTo(null);
        frmEditEvent.pack();
        frmEditEvent.setVisible(true);

    }

    //render frame for search event
    private void renderSearchEvent() {
        frmSearchEvent.setLayout(null);
        frmSearchEvent.setMinimumSize(new Dimension(500, 450));

        pnlSearchEvent.setLayout(null);
        pnlSearchEvent.setSize(500, 450);

        lblSearch.setBounds(120, 50, 300, 30);
        lstEvents.setPreferredSize(new Dimension(135, 90));
        
        jspList.setBounds(135, 90, 200, 250);
        btnSearch.setBounds(370, 90, 80, 30);
        btnDeleteEvent.setBounds(370, 130, 80, 30);

        pnlSearchEvent.add(lblSearch);
        pnlSearchEvent.add(jspList);
        pnlSearchEvent.add(btnSearch);
        pnlSearchEvent.add(btnDeleteEvent);

        frmSearchEvent.add(pnlSearchEvent);
        frmSearchEvent.setLocationRelativeTo(null);
        frmSearchEvent.pack();
        frmSearchEvent.setVisible(true);
        

    }

    //clear all fields in frame 
    private void clearFields() {
        tfDescription.setText(null);
        jdcDate.setDate(null);

    }

    //set all labels in frame
    private void setLabels() {
        lblDescription.setText("Title");
        lblDate.setText("Date");

    }

    //check if fields are empty, if so: set labels with an asterix
    private boolean isEmpty() {
        boolean isEmpty = false;

        if (tfDescription.getText().trim().isEmpty()) {
            lblDescription.setText("Title *");
            isEmpty = true;

        }
        if (jdcDate.getDate() == null) {
            lblDate.setText("Date *");
            isEmpty = true;

        }

        return isEmpty;

    }

    /**
     * deletes an event from the list and the database
     * @param obj the event to be deleted
     */
    public void deleteEvent(Event event) {

        int delete = JOptionPane.showConfirmDialog(null, "Do you wish to delete event: " + lstEvents.getSelectedValue().toString() + "?", null, JOptionPane.YES_NO_OPTION);
        if (delete == JOptionPane.YES_OPTION) {
            ec.deleteEvent(event);
            JOptionPane.showMessageDialog(null, "The event has been deleted");
        } else {
            JOptionPane.showMessageDialog(null, "The event will not be deleted");
        }
    }

    /**
     * get description from field
     * @return the String in the description textfield
     */
    public String getDescription() {
        return tfDescription.getText();
    }

    /**
     * get date from field
     * @return the date in the field
     */
        public Date getDate() {
        return jdcDate.getDate();
    }

    /**
     * set actions to buttons
     * @param e ActionEvent
     */
        public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        //button Add event
        if ((button) == btnAddEvent) {
            setLabels();
            clearFields();
            renderNewEvent();

        //button Edit event
        } else if ((button) == btnEditEvent) {
            renderSearchEvent();

            //button Search
        } else if ((button) == btnSearch) {
            //catch exceptions, nothing selected
            try {
                String s = (String) lstEvents.getSelectedValue().toString();

                frmSearchEvent.dispose();
                setLabels();
                clearFields();
                tfDescription.setText(s);
                renderEditEvent();
                displayEvent(event);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please select an event");
            }

        //button Delete
        } else if ((button) == btnDeleteEvent) {
            Event event = (Event) lstEvents.getSelectedValue();
            try {
                deleteEvent(event);
                
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            
        //button save
        } else if ((button) == btnSaveEvent) {
            setLabels();
            //if empty fields
            if (isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Please fill in all of the fields marked with an astrerisk");
            //save to database
            } else if (isEmpty() == false) {
                ec.sendEvent(getDescription(), getDate());
                frmNewEvent.dispose();
                frmEditEvent.dispose();
            }

        }

    }

    //set mouselistener
    MouseListener mouseEvent = new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            JList lstEvent = (JList) e.getSource();
            //if an event is selected with a doubleclick, render edit-frame
            if (e.getClickCount() == 2) {

                String selected = (String) lstEvent.getSelectedValue().toString();

                frmSearchEvent.dispose();
                setLabels();
                clearFields();
                tfDescription.setText(selected);
                renderEditEvent();
            }
        }
    };

    /**
     * display the event that has been selected in lstEvents in frmEditEvent
     * @param event the event in the database
     */
        public void displayEvent(Event event) {
        tfDescription.setText(event.getDescription());
        jdcDate.setDate(event.getDate());

    }

    /**
     * display the list of events available in DB in lstEvents
     * @param events the list of events available in the database
     */
        public void displayEventList(LinkedList<Event> events) {
        DefaultListModel model = new DefaultListModel();
        for (Event e : events) {
            model.addElement(e);
        }
        lstEvents.setModel(model);
    }

}
