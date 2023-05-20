package dbUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import security.SecureHash;

public class ReadAllDataFrom {
	public ReadAllDataFrom() {
	};

	public static void getAllDataFrom(String table) {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		SecureHash sh = new SecureHash();
		GetData gd = new GetData();

		try {
			String sql = "SELECT * FROM " + table;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println("ALL users");

			while (rs.next()) {

				
				gd.getData("ID: "+rs.getString("ID"),
						" | Name: "+rs.getString("Name"),
						" | Contact: "+rs.getString("Contact"),
						" | Registration: "+rs.getString("Registration"),
						" | PassWord: "+rs.getString("PassWord")
						);
				
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
