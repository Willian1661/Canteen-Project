package dbUtils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import security.SecureHash;

public class Table_info {

	public Table_info() {
	};

	public static void table_info(String table) {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		SecureHash sh = new SecureHash();
		SelectData gd = new SelectData();
		String columnName, columnContent;

		try {
			DatabaseMetaData metaData = con.getMetaData();
			String sql = "PRAGMA table_info("+table+")";
			ps = con.prepareStatement(sql);
			rs = metaData.getColumns(null, null, table, null);
			System.out.println("ALL users");
			while (rs.next()) {
				columnName = rs.getString("cid");
//				columnContent = ps.executeQuery().getString(columnName);
System.out.println(columnName);
//				if (columnName.equals("PassWord")) {
//					columnContent = sh.secureHash(columnContent);
//				}
//				gd.getData(columnName + ": " + columnContent + " | ");

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
