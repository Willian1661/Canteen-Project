package dbUtils;

import java.sql.*;
import security.SecureHash;
import view.Base;

public class SelectAllDataFrom extends Base {

	public SelectAllDataFrom(String table) {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSet rsMeta = null;
		SecureHash sh = new SecureHash();
		SelectData gd = new SelectData();
		String columnName, columnContent;
		String tablesName = null;

		switch (table) {
		case "*":
			try {
				DatabaseMetaData metaData = con.getMetaData();
				String sqlTables = "SELECT Name FROM sqlite_schema WHERE type = 'table' AND Name NOT LIKE 'sqlite_%';";
				ps = con.prepareStatement(sqlTables);
				rs = ps.executeQuery();
				while (rs.next()) {
					tablesName = gd.returnData(rs.getString("Name"));

					String sql = "SELECT * FROM " + tablesName;
					ps = con.prepareStatement(sql);
					rsMeta = metaData.getColumns(null, null, tablesName, null);

					System.out.println("\n\nTABLE NAME:" + tablesName);

					while (rsMeta.next()) {
						columnName = rsMeta.getString("COLUMN_NAME");
						columnContent = ps.executeQuery().getString(columnName);

						if (columnName.equals("PassWord")) {
							columnContent = sh.secureHash(columnContent);
						}
						gd.getData(columnName + ": " + columnContent + " | ");
						gd.returnData(columnName + ": " + columnContent + " | ");
					}
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

			break;

		default:
			try {
				DatabaseMetaData metaData = con.getMetaData();
				String sql = String.format("SELECT * FROM %s", table);
				ps = con.prepareStatement(sql);
				rs = metaData.getColumns(null, null, table, null);

				System.out.println("ALL COLUMNS FROM " + table);
				while (rs.next()) {
					columnName = rs.getString("COLUMN_NAME");
					columnContent = ps.executeQuery().getString(columnName);

					if (columnName.equals("PassWord")) {
						columnContent = sh.secureHash(columnContent);
					}
					gd.getData(columnName + ": " + columnContent + " | ");
					gd.returnData(columnName + ": " + columnContent + " | ");
				}

			} catch (SQLException e) {
				System.out.println("TABLE NOT FOUND!");
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
			break;
		}
		// method
	}
	// class
}
