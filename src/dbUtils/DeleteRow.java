package dbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteRow {
	public DeleteRow() {
	};

	public static void deleteRow(String[] statement, String[] value) {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;

		try {
			String sql = "DELETE FROM "+statement[0]+" WHERE "+statement[1]+" = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, value[0]);
			ps.execute();
			System.out.println("Deleted Row!");
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
