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
import java.sql.ResultSetMetaData;
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

import miscellaneous.Updater;
import miscellaneous.UsernameAndPwdPair;

import com.mysql.jdbc.Statement;

import entities.*;

/**
 * 
 * @author Henrik & Filip
 *
 */
public class DatabaseController {

	private static Connection connection;

	public DatabaseController() {
		try {
			connectToMySql();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Connects to the database.
	 * 
	 * @throws ClassNotFoundException
	 */
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

	/**
	 * Checks if the username and password combination exists in the database.
	 * 
	 * @param unP
	 * @return returns true if the combination exists.
	 * @throws SQLException
	 */
	public boolean authenticateUser(UsernameAndPwdPair unP) throws SQLException {
		String query = String.format("SELECT * FROM User WHERE ID = " + '"'
				+ "%s" + '"' + " and Password = " + '"' + "%s" + '"',
				unP.getUserId(), unP.getPassword());
		Statement statement = (Statement) connection.createStatement(
				java.sql.ResultSet.CONCUR_READ_ONLY,
				java.sql.ResultSet.TYPE_FORWARD_ONLY);
		ResultSet resultSet = statement.executeQuery(query);
		return resultSet.isBeforeFirst();

	}

	/**
	 * This method saves an entity to the proper databasetable depending on what
	 * class the object is. If the entity has ID==0 a new entity will be
	 * created. Otherwise the existing entities fields will be updated.
	 * 
	 * @param obj
	 *            the desired object that's going to be saved
	 * @throws SQLException
	 */
	public void saveEntity(Object obj) throws SQLException {
		PreparedStatement prepStatement;
		// ------------USER-----------
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
				prepStatement = connection
						.prepareStatement(String
								.format("UPDATE User set(Name, Password) values (?, ?) WHERE UserID = %s",
										user.getId()));
				prepStatement.setString(1, user.getName());
				prepStatement.setString(2, user.getPassword());
				updateToTable(prepStatement);
				if (user.isAdmin()) {
					prepStatement = connection
							.prepareStatement(String
									.format("UPDATE Admin set(User) values (?) WHERE UserID = %s",
											user.getId()));
					prepStatement.setBoolean(1, true);
					updateToTable(prepStatement);
				}
			}
			// ------------TASK------------
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
				prepStatement = connection
						.prepareStatement(String
								.format("UPDTAE Task set(Description, Author, Date) values (?,?,?) WHERE TaskID = %s",
										task.getId()));
				prepStatement.setDate(1, (Date) task.getDate());
				prepStatement.setInt(2, task.getAuthor());
				prepStatement.setString(3, task.getDescription());
				updateToTable(prepStatement);
			}
			// ------------TEAM----------------
		} else if (obj instanceof Team) {
			Team team = (Team) obj;
			if (team.getId() == 0) {
				prepStatement = connection
						.prepareStatement("INSERT INTO Team (Name) values (?)");
				prepStatement.setString(1, team.getName());
			} else {
				prepStatement = connection.prepareStatement(String.format(
						"UPDATE Team set(Name) values (?) WHERE TeamID = %s",
						team.getId()));
				prepStatement.setString(1, team.getName());
				updateToTable(prepStatement);
			}
		}
	}

	/**
	 * Deletes the entity with the same ID in the database.
	 * 
	 * @param obj
	 *            an object which is the same class and has the same ID as the
	 *            entity one wishes to delete
	 * @throws SQLException
	 */
	public void deleteEntity(Object obj) throws SQLException {
		PreparedStatement prepStatement;
		// ------------USER-----------
		if (obj instanceof User) {
			User user = (User) obj;
			prepStatement = connection.prepareStatement(String.format(
					"DELETE FROM User WHERE UserID = %s", user.getId()));
			prepStatement.setString(1, user.getName());
			prepStatement.setString(2, user.getPassword());
			deleteFromTable(prepStatement);
			if (user.isAdmin()) {
				prepStatement = connection.prepareStatement(String.format(
						"DELETE FROM Admin WHERE UserID = %s", user.getId()));
				prepStatement.setBoolean(1, true);
				deleteFromTable(prepStatement);
			}
			// ------------TASK-----------
		} else if (obj instanceof Task) {
			Task task = (Task) obj;
			prepStatement = connection.prepareStatement(String.format(
					"DELETE FROM Task WHERE TaskID = %s", task.getId()));
			prepStatement.setDate(1, (Date) task.getDate());
			prepStatement.setInt(2, task.getAuthor());
			prepStatement.setString(3, task.getDescription());
			deleteFromTable(prepStatement);
			// ------------TEAM-----------
		} else if (obj instanceof Team) {
			Team team = (Team) obj;
			prepStatement = connection.prepareStatement(String.format(
					"DELETE FROM Team WHERE TeamID = %s", team.getId()));
			prepStatement.setString(1, team.getName());
			deleteFromTable(prepStatement);
		}

	}

	private void insertToTable(PreparedStatement statement) {
		try {
			statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out
					.println("Something went wrong trying to insert the entity into the database");
			e.printStackTrace();
		}
	}

	private void updateToTable(PreparedStatement statement) {
		try {
			statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void deleteFromTable(PreparedStatement statement) {
		try {
			statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns an object from the database with the attributes of the the
	 * specific entityId
	 * 
	 * @param entityType
	 * @param entityId
	 * @return an object of the class specified by "entityType" and with
	 *         attributes specific for entityId
	 * @throws SQLException
	 */

	private User getUser(int entityId, ResultSet resultSet) throws SQLException {

		User user = null;
		Statement stmtUser = (Statement) connection.createStatement();
		String adminQuery = "SELECT * FROM Admin WHERE User = " + entityId;
		stmtUser.executeQuery(adminQuery);
		boolean isAdmin = stmtUser.getResultSet().isBeforeFirst();
		user = new User(resultSet.getString(2), isAdmin,
				resultSet.getString(3), resultSet.getInt(1));
		return user;
	}

	private Task getTask(int entityId, ResultSet resultSet) throws SQLException {

		Task task = null;
		Statement stmtTask = (Statement) connection.createStatement();
		String taskQuery = "SELECT * FROM Subtask WHERE Task = " + entityId;
		stmtTask.executeQuery(taskQuery);
		ResultSet subTaskResults = stmtTask.getResultSet();
		task = new Task(resultSet.getInt(1), resultSet.getString(2), null,
				resultSet.getDate(3), resultSet.getInt(4));
		int counter = 0;
		while (subTaskResults.next()) {
			task.addSubTask(subTaskResults.getString(2));
			task.completeSubTask(counter, subTaskResults.getInt(3));
		}
		return task;
	}

	private Team getTeam(int entityId, ResultSet resultSet) throws SQLException {
		return new Team(resultSet.getInt(1), resultSet.getString(2));
	}
	
	private Message getMessage (int entityId, ResultSet resultSet) throws SQLException{
		return new Message (resultSet.getString(2),resultSet.getString(3), null, resultSet.getInt(1));
	}
	
	private Event getEvent (int entityType, ResultSet resultSet) throws SQLException{
		return new Event (resultSet.getString(2), resultSet.getDate(3), resultSet.getInt(1));
	}

	public Object getEntity(String entityType, int entityId)
			throws SQLException {
		System.out.println(entityType + entityId);

		Statement statement = (Statement) connection.createStatement();
		String sqlQuery = String.format("SELECT * FROM %s WHERE " + entityType
				+ "ID = " + '"' + "%s" + '"', entityType, entityId);
		statement.executeQuery(sqlQuery);
		ResultSet resultSet = statement.getResultSet();
		Object obj = null;

		if (!resultSet.next())
			return obj;
		if (entityType.equals("User")) {
			obj = getUser(entityId, resultSet);
		} else if (entityType.equals("Task")) {
			obj = getTask(entityId, resultSet);
		} else if (entityType.equals("Team")) {
			obj = getTeam(entityId, resultSet);
		} else if (entityType.equals("Message")) {
			obj = getMessage(entityId, resultSet);
		} else if (entityType.equals("Event")) {
			obj = getEvent(entityId, resultSet);
		}
		return obj;
	}

	public Updater getUpdater(int userId) {
		Updater updater = new Updater();
		Statement statement = (Statement) connection.createStatement();
		String sqlQuery = "SELECT * FROM Recipients WHERE Recipient = " + userId; 
		statement.executeQuery(sqlQuery);
		ResultSet resultSet = statement.getResultSet();
		while(resultSet.next()){
			updater.addMessage(new Message(resultSet.getString(2), resultSet.getString(3), null, resultSet.getInt(1)));
		}
		
		statement = (Statement) connection.createStatement();
		sqlQuery = "SELECT * FROM Event"; 
		statement.executeQuery(sqlQuery);
		resultSet = statement.getResultSet();
		while(resultSet.next()){
			updater.addEvent(new Event(resultSet.getString(2), resultSet.getDate(3), null, resultSet.getInt(1)));
		}
		
		statement = (Statement) connection.createStatement();
		sqlQuery = "SELECT * FROM 'Member in' WHERE User = " + userId; 
		statement.executeQuery(sqlQuery);
		resultSet = statement.getResultSet();
		while(resultSet.next()){
			updater.addTask(new Task(userId, sqlQuery, null, null, userId, userId));
		}
		return updater;
	}
}
