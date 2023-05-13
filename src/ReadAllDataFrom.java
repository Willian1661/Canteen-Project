import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReadAllDataFrom {
	protected ReadAllDataFrom() {
	};

	protected void getAllDataFrom(String table) {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		SecureHash sh = new SecureHash();
		try {
			String sql = "SELECT * FROM " + table;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println("ALL users");

			while (rs.next()) {

				String id = rs.getString("ID");
				String name = rs.getString("Name");
				String contact = rs.getString("Contact");
				String registration = rs.getString("Registration");
				String passWord = sh.secureHash(rs.getString("PassWord"));

				System.out.print("\nID: " + id);
				System.out.print(" | ");
				System.out.print("Name: " + name);
				System.out.print(" | ");
				System.out.print("Contact: " + contact);
				System.out.print(" | ");
				System.out.print("Registration: " + registration);
				System.out.print(" | ");
				System.out.print("PassWord: " + passWord);
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
