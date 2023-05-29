package dbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectCountTables {
	public SelectCountTables() {
	};

	public static void selectCountTables(String table, String value) {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT count("+value+") FROM "+table;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			int size = rs.getInt(1);
			System.out.println("You have " + size + " " +table);
			
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
