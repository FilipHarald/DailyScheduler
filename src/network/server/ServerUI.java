package network.server;

import java.util.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class ServerUI extends JPanel implements ActionListener {
	private JButton btnExit = new JButton("Exit");
	private JTextPane conList = new JTextPane();
	private Date date;
	private SimpleDateFormat sim = new SimpleDateFormat("HH:mm:ss");
	JScrollPane chatScroll = new JScrollPane(conList);

	public ServerUI() {
		setPreferredSize(new Dimension(600, 400));
		setLayout(new BorderLayout());

		JPanel pnlCenter = new JPanel(new BorderLayout());
		JPanel pnlSouth = new JPanel(new GridLayout(1, 1));

		

		btnExit.setPreferredSize(new Dimension(25, 25));
		
		conList.setEditable(false);

		chatScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		pnlCenter.add(chatScroll);
		pnlSouth.add(conList);
		pnlSouth.add(btnExit);

		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);


		btnExit.addActionListener(this);

	}


	public void actionPerformed(ActionEvent e) {


		if (e.getSource() == btnExit) {
			//dispose();
		}
	}

}
