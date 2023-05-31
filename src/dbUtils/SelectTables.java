package dbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectTables {
	public SelectTables() {
	};

	public SelectTables(String action, String statement) {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		SelectData gd = new SelectData();
		int lgth = 0;

		try {
			String sql = "SELECT " + statement
					+ " FROM sqlite_schema WHERE type IS 'table' AND Name NOT LIKE 'sqlite_%'";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			System.out.println("\nTABLES Name:");

			while (rs.next()) {

				switch (action) {
				case "get":
					gd.getData(rs.getString("Name") + "\n");
					break;
				case "return":
					gd.returnData(rs.getString("Name") + "\n");
					break;
				default:
					System.out.println("something went wrong");
				
				}

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
}
