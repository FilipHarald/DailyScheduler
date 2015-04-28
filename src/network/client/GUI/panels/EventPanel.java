package network.client.GUI.panels;

import com.toedter.calendar.JDateChooser;
import entities.Event;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import network.client.controllers.EventController;

public class EventPanel extends JPanel implements ActionListener {

    private EventController ec;
    private Event event;

    private JDateChooser jdcDate = new JDateChooser();

    private JList lstEvents = new JList();

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
    private JLabel lblParticipants = new JLabel("Participants");
    private JLabel lblSearch = new JLabel("Type the eventID you wish to search for");

    private JTextField tfDescription = new JTextField(15);
    private JTextField tfDate = new JTextField(15);
    private JTextArea taParticipants = new JTextArea();

    private JPanel pnlButton = new JPanel();
    private JPanel pnlNewEvent = new JPanel();
    private JPanel pnlEditEvent = new JPanel();
    private JPanel pnlSearchEvent = new JPanel();

    public EventPanel() {
        super();
        setBorder(BorderFactory.createTitledBorder("Calendar view"));

        pnlButton.setLayout(new BorderLayout());
        pnlButton.add(btnAddEvent, BorderLayout.NORTH);
        pnlButton.add(btnEditEvent, BorderLayout.CENTER);

        add(pnlButton, BorderLayout.CENTER);

        pnlNewEvent.setLayout(new BorderLayout());
        pnlNewEvent.add(tfDescription, BorderLayout.NORTH);
        listeners();
    }

    public void listeners() {

        btnAddEvent.addActionListener(this);
        btnEditEvent.addActionListener(this);
        btnDeleteEvent.addActionListener(this);
        btnSaveEvent.addActionListener(this);
        btnSearch.addActionListener(this);
        lstEvents.addMouseListener(mouseEvent);

    }

    private void renderNewEvent() {
        frmNewEvent.setLayout(null);
        frmNewEvent.setMinimumSize(new Dimension(550, 350));

        pnlNewEvent.setSize(550, 350);
        pnlNewEvent.setLayout(null);

        lblDescription.setBounds(70, 50, 80, 20);
        tfDescription.setBounds(170, 50, 180, 20);

        lblDate.setBounds(70, 80, 80, 20);
        jdcDate.setBounds(170, 80, 180, 20);

        lblParticipants.setBounds(70, 80, 80, 100);
        taParticipants.setBounds(170, 120, 280, 100);

        btnSaveEvent.setBounds(175, 250, 100, 25);

        pnlNewEvent.add(lblDescription);
        pnlNewEvent.add(tfDescription);
        pnlNewEvent.add(lblDate);
        pnlNewEvent.add(jdcDate);

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
        frmEditEvent.setMinimumSize(new Dimension(550, 350));

        pnlEditEvent.setSize(550, 350);
        pnlEditEvent.setLayout(null);

        lblDescription.setBounds(70, 50, 80, 20);
        tfDescription.setBounds(170, 50, 180, 20);

        lblDate.setBounds(70, 80, 80, 20);
        jdcDate.setBounds(170, 80, 180, 20);

        lblParticipants.setBounds(70, 80, 80, 100);
        taParticipants.setBounds(170, 120, 280, 100);

        btnSaveEvent.setBounds(175, 250, 100, 25);
        btnDeleteEvent.setBounds(340, 250, 100, 25);

        pnlEditEvent.add(lblDescription);
        pnlEditEvent.add(tfDescription);
        pnlEditEvent.add(lblDate);
        pnlEditEvent.add(jdcDate);

        pnlEditEvent.add(lblParticipants);
        pnlEditEvent.add(taParticipants);
        pnlEditEvent.add(btnSaveEvent);
        pnlEditEvent.add(btnDeleteEvent);

        frmEditEvent.add(pnlEditEvent);
        frmEditEvent.setLocationRelativeTo(null);
        frmEditEvent.pack();
        frmEditEvent.setVisible(true);

    }

    private void renderSearchEvent() {
        frmSearchEvent.setLayout(null);
        frmSearchEvent.setMinimumSize(new Dimension(500, 450));

        pnlSearchEvent.setLayout(null);
        pnlSearchEvent.setSize(500, 450);

        lblSearch.setBounds(120, 50, 300, 30);
        lstEvents.setBounds(135, 90, 200, 250);
        btnSearch.setBounds(370, 90, 80, 30);

        pnlSearchEvent.add(lblSearch);
        pnlSearchEvent.add(lstEvents);
        pnlSearchEvent.add(btnSearch);

        frmSearchEvent.add(pnlSearchEvent);
        frmSearchEvent.setLocationRelativeTo(null);
        frmSearchEvent.pack();
        frmSearchEvent.setVisible(true);

        displayEventList(event);

    }

    private void clearFields() {
        tfDescription.setText(null);
        jdcDate.setDate(null);
        taParticipants.setText(null);

    }

    private void setLabels() {
        lblDescription.setText("Title");
        lblDate.setText("Date");
        lblParticipants.setText("Participants");

    }

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

        if (taParticipants.getText().trim().isEmpty()) {
            lblParticipants.setText("Participants *");
            isEmpty = true;
        }

        return isEmpty;

    }

    public String getDescription() {
        return tfDescription.getText();
    }

    public Date getDate() {
        return jdcDate.getDate();
    }

    public String getParticipants() {
        return taParticipants.getText();
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

        } else if ((button) == btnSearch) {
            try {
                String s = (String) lstEvents.getSelectedValue().toString();

                frmSearchEvent.dispose();
                setLabels();
                clearFields();
                tfDescription.setText(s);
                renderEditEvent();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please select an event");
            }

        } else if ((button) == btnDeleteEvent) {
            //JOptionPane.showMessageDialog(null, "Do you wish to delete event: " + tfTitle.getText() + "?");
            int delete = JOptionPane.showConfirmDialog(null, "Do you wish to delete event: " + tfDescription.getText() + "?", null, JOptionPane.YES_NO_OPTION);
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
            if (isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Please fill in all of the fields marked with an astrerisk");
            } else {
                ec.createEvent();
                //TODO: save event to database
                frmNewEvent.dispose();
                frmEditEvent.dispose();
            }

        }

    }

    MouseListener mouseEvent = new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            JList lstEvent = (JList) e.getSource();
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

//    public void getTitle(){
//        
//    }
    public void displayEvent(Event event) {
        tfDescription.setText(event.getDescription());
        jdcDate.setDate(event.getDate());
        taParticipants.setText(event.getParticipants(null).toString());

    }

    public void displayEventList(Event event) {
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < 5; i++) {
            model.addElement(i);

        }
        lstEvents.setModel(model);
//        lstEvents.setModel((ListModel)ec.displayEventList(event));
    }

	public void update(LinkedList<Event> events) {
		
	}

}
