import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import dbUtils.CreateMenu;
import dbUtils.DbConnection;
import dbUtils.SelectData;
import dbUtils.SelectTables;
import dbUtils.SelectAllDataFrom;
import dbUtils.SelectRow;
import dbUtils.InsertData;
import dbUtils.UpdateData;
public class Main {

	public static void main(String[] args) {
		SelectAllDataFrom rad = new SelectAllDataFrom();
		SelectTables gtl = new SelectTables();
		SelectRow rn = new SelectRow();
		InsertData id = new InsertData();
		UpdateData ud = new UpdateData();
		
//		ud.updateData(new String[] {"usertest","texto","texto"},new String[] {"testfoo","testbar"});

		getNumberOfUsers();
		
//		rad.SelectAllDataFrom("users");

//		gtl.getTables();
		
//		rn.selectRow(new String[] {"*","users","ID","1"});

//		id.insertData(new String[] {"usertest","issofoo"},new String[] {"?"});
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