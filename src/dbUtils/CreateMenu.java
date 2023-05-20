package dbUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CreateMenu {
	public CreateMenu() {
	};

	public static void createMenu(String canteenName) {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "CREATE TABLE ordersMenu_" + canteenName + "(\n" 
					+ "ID INTEGER PRIMARY KEY AUTOINCREMENT,\n"
					+ "Canteen_ID INTEGER NOT NULL,\n" 
					+ "Name TEXT NOT NULL,\n" 
					+ "Value INTEGER,\n"
					+ "FOREIGN KEY (Canteen_ID) REFERENCES canteens(ID)\n" 
					+ ");";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
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
