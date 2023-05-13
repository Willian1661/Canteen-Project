import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

	public static void main(String[] args) {
//		DbConnection.connect();

//		readAllData();

//		readSpecificRow({'*'});

//		insertData("jose", "jose@gmail.com");

//		updateData();

//		getNumberOfUsers();
//		ReadAllDataFrom rad = new ReadAllDataFrom();
//		rad.getAllDataFrom("users");
//
//		GetTablesLenth gtl = new GetTablesLenth();
//		gtl.getTablesLenth();
	}

	private static void readSpecificRow(String[] args) {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT " + args[0] + " FROM users WHERE " + args[1] + " = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, args[2]);
			rs = ps.executeQuery();

			String column = rs.getString("id");
			String column2 = rs.getString("name");
			System.out.println("id: " + column + "\n" + "name: " + column2);

		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
	}

	private static void insertData(String name, String email) {

		Connection con = DbConnection.connect();
		PreparedStatement ps = null;

		try {
			String sql = "INSERT INTO users VALUES(?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.execute();
			System.out.println("Data has been inserted");

		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
	}

	private static void updateData() {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;

		try {
			String sql = "UPDATE users set name = ? WHERE email = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, "Lucas@gmail.com");
			ps.setString(2, "Lucas");
			ps.execute();
			System.out.println("Data has been executed");

		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
	}

	private static void deleteRow() {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;

		try {
			String sql = "DELETE from users WHERE email = ? ";
			ps = con.prepareStatement(sql);
			ps.setString(1, "Lucas@gmail.com");
			ps.execute();
			System.out.println("Data has been deleted!");
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
	}

	private static void getNumberOfUsers() {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT count(name) FROM users";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			int size = rs.getInt(1);
			System.out.println("You have " + size + " users.");
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				ps.close();
				rs.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
	}

}