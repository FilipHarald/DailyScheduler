package network.client.GUI.panels;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class CalendarPanel extends JPanel {

	public CalendarPanel(){
		super();
		setBorder(BorderFactory.createTitledBorder("Calendar view"));
	}

    public void displayEvent() {
        
    }
    
    //get description from textarea
    public String getDescription(){
        return textDescription.getText();
    }
}
