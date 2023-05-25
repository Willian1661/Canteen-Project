package dbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {
	public UpdateData() {
	};

	public static void updateData(String[] statement, String[] values) {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;

		try {
			String sql = "UPDATE " + statement[0] + " SET " + statement[1] + " = \"" + values[0] + "\" WHERE "+ statement[2] + " IS ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, values[1]);
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

}
