package database;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

import com.mysql.jdbc.Statement;

import entities.Team;
import entities.User;
import entities.Task;

public class Database {

	private static Connection connection;
	private User user;
	private Team team;
	private Task task;
	private DatabasGUI gui = new DatabasGUI();

	public Database() {
		try {
			connectToMySql();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Start connection to localhost
	public void connectToMySql() throws ClassNotFoundException {
		String host = "jdbc:mysql://localhost/test";
		String username = "root", password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(host, username, password);
			System.out.println("Connected to database");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void saveEntity(Object obj) throws SQLException {
		PreparedStatement prepStatement;

		if (obj instanceof User) {
			User user = (User) obj;
			if (user.getId() == 0) {
				prepStatement = connection
						.prepareStatement("INSERT INTO User (Name, Password) values (?, ?)");
				prepStatement.setString(1, user.getName());
				prepStatement.setString(2, user.getPassword());
				insertToTable(prepStatement);
				if (user.isAdmin()) {
					prepStatement = connection
							.prepareStatement("INSERT INTO Admin (User) values (?)");
					prepStatement.setBoolean(1, true);
					insertToTable(prepStatement);
				}
			} else {
				// updateTable("User", user.getId(), user.getName(),
				// user.getPassword());
			}
		} else if (obj instanceof Task) {
			Task task = (Task) obj;
			if (task.getId() == 0) {
				prepStatement = connection
						.prepareStatement("INSERT INTO Task (Description, Author, Date) values (?,?,?)");
				prepStatement.setDate(1, (Date) task.getDate());
				prepStatement.setInt(2, task.getAuthor());
				prepStatement.setString(3, task.getDescription());
				insertToTable(prepStatement);
			} else {
				// updateTable
			}
		} else if (obj instanceof Team) {
			if (task.getId() == 0) {
				Team team = (Team) obj;
				prepStatement = connection
						.prepareStatement("INSERT INTO Team (Name) values (?)");
				prepStatement.setString(1, team.getName());
			} else {
				// updateTable
			}
		}
	}

	private void insertToTable(PreparedStatement statement) {
		try {
			statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateEntity (Object obj, int currentID) throws SQLException{
		PreparedStatement prepStatement;
		
		if (obj instanceof User) {
			User user = (User) obj;
			if (user.getId() == currentID) {
				prepStatement = connection
						.prepareStatement("UPDATE User set(Name, Password) values (?, ?) WHERE UserID = currentID");
				prepStatement.setString(1, user.getName());
				prepStatement.setString(2, user.getPassword());
				updateToTable(prepStatement);
				if (user.isAdmin()) {
					prepStatement = connection
							.prepareStatement("UPDATE Admin set(User) values (?) WHERE UserID = curentID");
					prepStatement.setBoolean(1, true);
					updateToTable(prepStatement);
				}
			} 		
		} else if (obj instanceof Task) {
			Task task = (Task) obj;
			if (task.getId() == currentID) {
				prepStatement = connection
						.prepareStatement("UPDTAE Task set(Description, Author, Date) values (?,?,?) WHERE TaskID = currentID");
				prepStatement.setDate(1, (Date) task.getDate());
				prepStatement.setInt(2, task.getAuthor());
				prepStatement.setString(3, task.getDescription());
				updateToTable(prepStatement);
			}
		} else if (obj instanceof Team) {
			if (task.getId() == currentID) {
				Team team = (Team) obj;
				prepStatement = connection
						.prepareStatement("UPDATE Team set(Name) values (?) WHERE TeamID = currentID");
				prepStatement.setString(1, team.getName());
				updateToTable(prepStatement);
			}
				
		}
	
}

	private void updateToTable (PreparedStatement statement){
		try {
			statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void deleteEntity (Object obj, int currentID) throws SQLException{
		PreparedStatement prepStatement;
		
		if (obj instanceof User) {
			User user = (User) obj;
			if (user.getId() == currentID) {
				prepStatement = connection
						.prepareStatement("DELETE FROM User WHERE UserID = currentID");
				prepStatement.setString(1, user.getName());
				prepStatement.setString(2, user.getPassword());
				deleteFromTable(prepStatement);
				if (user.isAdmin()) {
					prepStatement = connection
							.prepareStatement("DELETE FROM Admin WHERE UserID = curentID");
					prepStatement.setBoolean(1, true);
					deleteFromTable(prepStatement);
				}
			} 		
		} else if (obj instanceof Task) {
			Task task = (Task) obj;
			if (task.getId() == currentID) {
				prepStatement = connection
						.prepareStatement("DELETE FROM Task WHERE TaskID = currentID");
				prepStatement.setDate(1, (Date) task.getDate());
				prepStatement.setInt(2, task.getAuthor());
				prepStatement.setString(3, task.getDescription());
				deleteFromTable(prepStatement);
			}
		} else if (obj instanceof Team) {
			if (task.getId() == currentID) {
				Team team = (Team) obj;
				prepStatement = connection
						.prepareStatement("DELETE FROM Team WHERE TeamID = currentID");
				prepStatement.setString(1, team.getName());
				deleteFromTable(prepStatement);
			}
				
		}
	
}
	
	private void deleteFromTable (PreparedStatement statement){
		try {
			statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

	// Get users table
	public static ResultSet getUsersResult(Connection connect1, String sql)
			throws Exception {
		Statement state = (Statement) connect1.createStatement(
				java.sql.ResultSet.CONCUR_READ_ONLY,
				java.sql.ResultSet.TYPE_FORWARD_ONLY);
		return state.executeQuery(sql);

	}

	public static ResultSet getUsers(Connection connect2, String tableName)
			throws Exception {
		String sqlStatement = String.format("select * from %s", tableName);
		return getUsersResult(connect2, sqlStatement);

	}

	// Get team table
	public static ResultSet getTeamResult(Connection connection, String sql)
			throws SQLException {
		Statement state = (Statement) connection.createStatement(
				java.sql.ResultSet.CONCUR_READ_ONLY,
				java.sql.ResultSet.TYPE_FORWARD_ONLY);
		return state.executeQuery(sql);
	}

	public static ResultSet getTeams(Connection connection) throws SQLException {
		return getTeamResult(connection, "select * from Teams");

	}

	// Get task table
	public static ResultSet getTaskResult(Connection connection, String sql)
			throws SQLException {
		Statement state = (Statement) connection.createStatement(
				java.sql.ResultSet.CONCUR_READ_ONLY,
				java.sql.ResultSet.TYPE_FORWARD_ONLY);
		return state.executeQuery(sql);
	}

	public static ResultSet getTask(Connection connection) throws SQLException {
		return getTeamResult(connection, "select * from Task");
	}

	// Shows the information stored in databases
	public void ShowResult() throws Exception {
		JOptionPane.showMessageDialog(null, "Visa information från databas");
		JOptionPane.showMessageDialog(null, "User" + "\n" + "Team" + "\n"
				+ "Task");
		String pane = JOptionPane.showInputDialog("");

		ResultSet rs = getUsers(connection, pane);
		while (rs.next()) {

			System.out.println(rs.getString(1) + ", " + rs.getString(2) + ", "
					+ rs.getString(3));

		}
		// if (pane.equals("User")){
		// ResultSet rs = getUsers(connect, "User");
		// while (rs.next()){
		// System.out.println( rs.getString(1)+ ", "+ rs.getString(2)+ ", "+
		// rs.getString(3));
		//
		// }
		// }else if (pane.equals("Team")){
		// ResultSet rs2 = getTeams (connect);
		// while (rs2.next()){
		// System.out.println(rs2.getString(1)+ ", "+ rs2.getString(2));
		// }
		//
		// } else if (pane.equals("Task")){
		// ResultSet rs3 = getTask(connect);
		// while (rs3.next()){
		// System.out.println (rs3.getString(1)+ ", "+ rs3.getString(2)+ ", "+
		// rs3.getString(3));
		// }
		//
		// }
	}

	// public void SaveResult (){
	//
	// JOptionPane.showMessageDialog(null, "Spara till databas");
	// JOptionPane.showMessageDialog(null, "User"+ "\n"+ "Team"+ "\n"+ "Task");
	// String pane = JOptionPane.showInputDialog("");
	// try {
	// saveEntity(new User ("Testa Karlsson", false, "1234", 0));
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// if (pane.equals("User")){
	// try {
	// sendToTableUser(gui.getid(), gui.getName(), gui.getTitle());
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// } else if (pane.equals("Team")){
	// try {
	// sendToTableTeams (gui.getid(), gui.getName());
	// } catch (SQLException e){
	// e.printStackTrace();
	// }
	//
	// }else if (pane.equals("Task")){
	// try {
	// sendToTableTask (gui.getid(), gui.getName(), gui.getTitle());
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }

}
