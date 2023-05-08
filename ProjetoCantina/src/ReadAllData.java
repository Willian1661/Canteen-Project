import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReadAllData {
	protected ReadAllData() {};
	
	protected void getAllData(String table) {
	Connection con = DbConnection.connect();
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	try {
		String sql = "SELECT * FROM "+table;
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		System.out.println("ALL users");
		
		while(rs.next()) {
			
			String id = rs.getString("id");
			String name = rs.getString("name");
			String contact = rs.getString("contact");
			String wish = rs.getString("wish");
			
			System.out.print("\nid: " + id);
			System.out.print(" | ");
			System.out.print("name: " + name);
			System.out.print(" | ");
			System.out.print("contact: " + contact);
			System.out.print(" | ");
			System.out.print("wish: " + wish);
		}
	}catch(SQLException e) {
			System.out.println(e.toString());
		}finally{
			try {
				ps.close();
				rs.close();
				con.close();
			}catch(SQLException e) {
				System.out.println(e.toString());
			}
		}
	}
}
