package dbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadRow {
	public ReadRow() {
	};

	public void readRow(String col, String table, String col2, String info) {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		GetData gd = new GetData();

		try {
			String sql = "SELECT " + col + " FROM " + table + " WHERE " + col2 + " = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, info);
			rs = ps.executeQuery();

			if (rs.getString("ID") == null) {
				System.out.println("table or column not found");
			} else {
				gd.getData("ID: " + rs.getString("ID"), " | Name: " + rs.getString("Name"),
						" | Contact: " + rs.getString("Contact"), " | Registration: " + rs.getString("Registration"),
						" | PassWord: " + rs.getString("PassWord"));
			}

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
}
