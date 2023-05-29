package dbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import security.SecureHash;
import dbUtils.SelectTables;

public class SelectAllDataFrom {
	// constructor
	public SelectAllDataFrom() {
	};

	//method
	public static void SelectAllDataFrom(String table) {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSet rsMeta = null;
		SecureHash sh = new SecureHash();
		SelectData gd = new SelectData();
		String columnName, columnContent;
		SelectTables gtl = new SelectTables();
		int index = 0;
		String tablesName = "";

		switch (table) {
		case "*":
			try {
				DatabaseMetaData metaData = con.getMetaData();
				String sqlTables = "SELECT \n" + "Name \n" + "FROM \n" + "sqlite_schema\n" + "WHERE \n"
						+ "    type ='table' AND \n" + "    name NOT LIKE 'sqlite_%';";
				ps = con.prepareStatement(sqlTables);
				rs = ps.executeQuery();
				while (rs.next()) {
					index++;

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
				String sql = "SELECT * FROM " + table;
				ps = con.prepareStatement(sql);
				rs = metaData.getColumns(null, null, table, null);

				System.out.println("ALL users");
				while (rs.next()) {
					columnName = rs.getString("COLUMN_NAME");
					columnContent = ps.executeQuery().getString(columnName);

					if (columnName.equals("PassWord")) {
						columnContent = sh.secureHash(columnContent);
					}
					gd.getData(columnName + ": " + columnContent + " | ");

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
