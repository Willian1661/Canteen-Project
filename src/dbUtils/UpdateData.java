package dbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {
	public UpdateData() {
	};

	public UpdateData(String[] statement, String[] values) {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;

		try {
			String sql = String.format("UPDATE %s SET %s = \" %s \" WHERE %s IS ?",statement[0],statement[1],values[0],statement[2]);
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
