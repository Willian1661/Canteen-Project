package dbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {

	public InsertData() {
	};

	public void insertData(String table, String col1, String col2) {

		Connection con = DbConnection.connect();
		PreparedStatement ps = null;

		try {
			String sql = "INSERT INTO " + table + " VALUES(?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, col1);
			ps.setString(2, col2);
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

}
