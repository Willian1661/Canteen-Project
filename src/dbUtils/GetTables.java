package dbUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetTables {
	public GetTables() {
	};

	public static void getTables() {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		GetData gd = new GetData();
		int lgth = 0;
		try {
			String sql = "SELECT \n"
					+ "    Name\n"
					+ "FROM \n"
					+ "    sqlite_schema\n"
					+ "WHERE \n"
					+ "    type ='table' AND \n"
					+ "    name NOT LIKE 'sqlite_%';";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			System.out.println("\nTABLES Name:");

			while (rs.next()) {
				
				gd.getData(rs.getString("Name")+"\n");
				System.out.println();
				
				lgth++;
			}

			System.out.println("\nTABLES LENGTH: "+lgth);
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
