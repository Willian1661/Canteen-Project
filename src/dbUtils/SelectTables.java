package dbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectTables {
	public SelectTables() {
	};

	public static void getTables(String statement) {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		SelectData gd = new SelectData();
		int lgth = 0;
		try {
			String sql = "SELECT \n" + statement + "\n" + "FROM \n" + "sqlite_schema\n" + "WHERE \n"
					+ "    type ='table' AND \n" + "    name NOT LIKE 'sqlite_%';";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			System.out.println("\nTABLES Name:");

			while (rs.next()) {

				gd.returnData(rs.getString("Name") + "\n");

				lgth++;
			}

			System.out.println("\nTABLES LENGTH: " + lgth);
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

	public static void returnTables(String statement) {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		SelectData gd = new SelectData();
		try {
			String sql = "SELECT \n" + statement + "\n" + "FROM \n" + "sqlite_schema\n" + "WHERE \n"
					+ "    type ='table' AND \n" + "    name NOT LIKE 'sqlite_%';";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			System.out.println("\nTABLES Name:");

			while (rs.next()) { 

				gd.getData(rs.getString("Name")+"\n");
			}
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
