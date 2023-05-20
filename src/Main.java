import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import dbUtils.CreateMenu;
import dbUtils.DbConnection;
import dbUtils.GetData;
import dbUtils.GetTables;
import dbUtils.ReadAllDataFrom;
import dbUtils.ReadRow;
import dbUtils.InsertData;

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
////
//		GetTables gtl = new GetTables();
//		gtl.getTablesLenth();
		
//		ReadRow rn = new ReadRow();
//		rn.readRow("*", "users", "ID", "2");

//		InsertData id = new InsertData();
//		id.insertData("table", "col1", "col2");
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