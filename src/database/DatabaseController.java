package database;

import java.sql.*;

import miscellaneous.*;

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
		String host = "jdbc:mysql://localhost/DailyScheduler";
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
	public User authenticateUser(UsernameAndPwdPair unP) throws SQLException {
		User usr = null;
		String query = String.format("SELECT * FROM User WHERE UserID = " + '"'
				+ "%s" + '"' + " and Password = " + '"' + "%s" + '"',
				unP.getUserId(), unP.getPassword());
		Statement statement = (Statement) connection.createStatement(
				java.sql.ResultSet.CONCUR_READ_ONLY,
				java.sql.ResultSet.TYPE_FORWARD_ONLY);
		ResultSet resultSet = statement.executeQuery(query);
		if (resultSet.isBeforeFirst()) {
			usr = (User) getEntity("User", unP.getUserId());
		}
		return usr;
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
					prepStatement.setInt(1, user.getId());
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
				java.sql.Date date = convertFromJavaDateToSQLDate(task
						.getDate());
				prepStatement = connection
						.prepareStatement("INSERT INTO Task (Description, Author, Date) values (?,?,?)");
				prepStatement.setDate(3, date);
				prepStatement.setInt(2, task.getAuthor());
				prepStatement.setString(1, task.getDescription());
				insertToTable(prepStatement);
			} else {
				java.sql.Date date = convertFromJavaDateToSQLDate(task
						.getDate());
				prepStatement = connection
						.prepareStatement(String
								.format("UPDATE Task set(Description, Author, Date) values (?,?,?) WHERE TaskID = %s",
										task.getId()));
				prepStatement.setDate(1, date);
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
				insertToTable(prepStatement);
			} else if (team.getName() != null){
				prepStatement = connection.prepareStatement(String.format(
						"UPDATE Team set Name='%s' WHERE TeamID = %s",
						team.getName(), team.getId()));
				updateToTable(prepStatement);
			}else{
				Integer userId = team.getManagers()[0];
				if (userId != null){					
					prepStatement = connection.prepareStatement(String.format(
							"UPDATE Team set Manager='%s' WHERE TeamID = %s",
							userId, team.getId()));
					updateToTable(prepStatement);
				}else{
					userId = team.getMembers()[0];
				}
				prepStatement = connection
						.prepareStatement("INSERT INTO `Member in` (User, Team) values (?,?)");
				prepStatement.setInt(1, userId);
				prepStatement.setInt(2, team.getId());
				insertToTable(prepStatement);
			}
			// ----------------Message-------------
		} else if (obj instanceof Message) {
			Message msg = (Message) obj;
			prepStatement = connection
					.prepareStatement("INSERT INTO Message (Title, Text, Author) values (?,?,?)");
			prepStatement.setString(1, msg.getTitle());
			prepStatement.setString(2, msg.getMessage());
			prepStatement.setInt(3, msg.getAuthorId());
			insertToTable(prepStatement);
		} // ------------Event---------------
		else if (obj instanceof Event) {
			Event event = (Event) obj;
			java.sql.Date date = convertFromJavaDateToSQLDate(event.getDate());
			if (event.getId() == 0) {
				prepStatement = connection
						.prepareStatement("INSERT INTO Event (Text, Date, User) values (?,?,?)");
				prepStatement.setString(1, event.getDescription());
				prepStatement.setDate(2, date);
				prepStatement.setInt(3, event.getAuthorID());
				insertToTable(prepStatement);
			} else {
				prepStatement = connection
						.prepareStatement(String
								.format("UPDATE Event set(Text, Date, User) values (?,?,?) WHERE EventID = %s",
										event.getId()));
				prepStatement.setString(1, event.getDescription());
				prepStatement.setDate(2, date);
				prepStatement.setInt(3, event.getAuthorID());
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
			deleteFromTable(prepStatement);
			if (user.isAdmin()) {
				prepStatement = connection.prepareStatement(String.format(
						"DELETE FROM Admin WHERE UserID = %s", user.getId()));
				deleteFromTable(prepStatement);
			}
			// ------------TASK-----------
		} else if (obj instanceof Task) {
			Task task = (Task) obj;
    			prepStatement = connection.prepareStatement(String.format(
    					"DELETE FROM Task WHERE TaskID = %s", task.getId()));
    			deleteFromTable(prepStatement);
			// ------------TEAM-----------
		} else if (obj instanceof Team) {
			Team team = (Team) obj;
			prepStatement = connection.prepareStatement(String.format(
					"DELETE FROM Team WHERE TeamID = %s", team.getId()));
			deleteFromTable(prepStatement);
		}
		// ------------TEAM-----------
		else if (obj instanceof Event) {
			Event event = (Event) obj;
			prepStatement = connection.prepareStatement(String.format(
					"DELETE FROM Event WHERE EventID = %s", event.getId()));
			deleteFromTable(prepStatement);
		}
	}

	private void insertToTable(PreparedStatement statement) {
		try {
			statement.executeUpdate();
			statement.close();
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void deleteFromTable(PreparedStatement statement) {
		try {
			statement.executeUpdate();
			statement.close();
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
		user = new User(resultSet.getString(2), true,
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

	private Message getMessage(int entityId, ResultSet resultSet)
			throws SQLException {
		return new Message(resultSet.getString(2), resultSet.getString(3),
				null, resultSet.getInt(1), resultSet.getInt(4));
	}

	private Event getEvent(int entityType, ResultSet resultSet)
			throws SQLException {
		return new Event(resultSet.getString(2), resultSet.getInt(4),
				resultSet.getDate(3), resultSet.getInt(1));
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

		if (!resultSet.next()) {
			return obj;
		}
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

	public Updater getUpdater(int userId) throws SQLException {
		Updater updater = new Updater();
		Statement statement = (Statement) connection.createStatement();
		String sqlQuery = "select * from Recipients inner join Message where Recipients.Message = Message.MessageID and Recipients.Recipient = "
				+ userId;
		statement.executeQuery(sqlQuery);
		ResultSet resultSet = statement.getResultSet();
		while (resultSet.next()) {
			updater.addMessage(new Message(resultSet.getString(4), resultSet
					.getString(5), null, resultSet.getInt(3), resultSet
					.getInt(6)));
		}

		statement = (Statement) connection.createStatement();
		sqlQuery = "SELECT * FROM Event";
		statement.executeQuery(sqlQuery);
		resultSet = statement.getResultSet();
		while (resultSet.next()) {
			updater.addEvent(new Event(resultSet.getString(2), resultSet
					.getInt(4), resultSet.getDate(3), resultSet.getInt(1)));
		}
		statement = (Statement) connection.createStatement();
		sqlQuery = "SELECT * FROM User";
		statement.executeQuery(sqlQuery);
		resultSet = statement.getResultSet();
		while (resultSet.next()) {
			updater.addUser(new User(resultSet.getString(2), false, null, resultSet.getInt(1)));
		}

		statement = (Statement) connection.createStatement();
		sqlQuery = "SELECT * FROM Team";
		statement.executeQuery(sqlQuery);
		resultSet = statement.getResultSet();
		while (resultSet.next()) {
			updater.addTeam(new Team(resultSet.getInt(1), resultSet.getString(2)));
		}


		statement = (Statement) connection.createStatement();
		sqlQuery = "SELECT * FROM Task inner join Team, `Member in` where Team.Manager = Task.Author and `Member in`.Team = Team.TeamID and `Member in`.User = "
				+ userId;
		statement.executeQuery(sqlQuery);
		resultSet = statement.getResultSet();
		while (resultSet.next()) {
			Statement stmt = (Statement) connection.createStatement();
			String query = "select count(*) from Subtask where Task = "
					+ resultSet.getInt(1);
			stmt.executeQuery(query);
			ResultSet rs = stmt.getResultSet();
			rs.next();
			String[] subTasks = new String[rs.getInt(1)];
			System.out.println(rs.getInt(1));

			stmt = (Statement) connection.createStatement();
			query = "select * from Subtask where Task = " + resultSet.getInt(1);
			stmt.executeQuery(query);
			rs = stmt.getResultSet();
			int counter = 0;
			while (rs.next()) {
				subTasks[counter++] = rs.getString(2);
			}
			Task task = new Task(resultSet.getInt(4), resultSet.getString(2),
					subTasks, resultSet.getDate(3), resultSet.getInt(1));

			rs.beforeFirst();
			counter = 0;
			while (rs.next()) {
				task.completeSubTask(counter++, rs.getInt(3));
			}
			updater.addTask(task);
		}
		return updater;
	}

	public static java.sql.Date convertFromJavaDateToSQLDate(
			java.util.Date javaDate) {
		java.sql.Date sqlDate = null;
		if (javaDate != null) {
			sqlDate = new Date(javaDate.getTime());
		}
		return sqlDate;
	}
}
