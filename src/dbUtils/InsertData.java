package dbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import service.RemoveArrayElements;

public class InsertData {

	public InsertData() {
	};

	public void insertData(String[] values, String[] interrogation) {

		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		RemoveArrayElements rae = new RemoveArrayElements();
		String Interrogation = "";

		try {
			for (int i = 0; i < interrogation.length; i++) {
				// store how many values will have
				Interrogation += (interrogation[i] + ",");
			}

			String sql = "INSERT INTO " + values[0] + " VALUES(" + rae.removeLastChar(Interrogation) + ");";
			ps = con.prepareStatement(sql);

			for (int i = 1; i <= values.length-1; i++) {
				// set values in sort position
				ps.setString((i), values[i]);
				System.out.println("?position "+i+":"+" value: "+values[i]);

			}
			
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
