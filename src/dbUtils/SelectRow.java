package dbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import security.SecureHash;
import java.sql.DatabaseMetaData;

public class SelectRow {
	public SelectRow() {
	};

	public SelectRow(String[] statement) {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		SelectData gd = new SelectData();
		SecureHash sh = new SecureHash();
		String columnName, columnContent;

		try {
			DatabaseMetaData metaData = con.getMetaData();
			String sql = String.format("SELECT %s FROM %s WHERE %s = ?",statement[0],statement[1],statement[2]);
			ps = con.prepareStatement(sql);
			ps.setString(1, statement[3]);
			rs = metaData.getColumns(null, null, statement[1], null);
			columnName = rs.getString("COLUMN_NAME");

			if (ps.executeQuery().getString(columnName) == null) {
				System.out.println("table or column not found");
			} else {
				while (rs.next()) {
					columnName = rs.getString("COLUMN_NAME");
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
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
	};
	
	public String selectRow(String[] statement) {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		SelectData gd = new SelectData();
		SecureHash sh = new SecureHash();
		String columnName, columnContent;
		String row= "";

		try {
			DatabaseMetaData metaData = con.getMetaData();
			String sql = String.format("SELECT %s FROM %s WHERE %s = ?",statement[0],statement[1],statement[2]);
			ps = con.prepareStatement(sql);
			ps.setString(1, statement[3]);
			rs = metaData.getColumns(null, null, statement[1], null);
			columnName = rs.getString("COLUMN_NAME");

			if (ps.executeQuery().getString(columnName) == null) {
				System.out.println("table or column not found");
				JOptionPane.showMessageDialog(null, "User not found ");
			} else {
				while (rs.next()) {
					columnName = rs.getString("COLUMN_NAME");
					columnContent = ps.executeQuery().getString(columnName);
					
					if (columnName.equals("PassWord")) {
						columnContent = sh.secureHash(columnContent);
					}
					gd.getData(columnName + ": " + columnContent + " | ");
					row += gd.returnData(columnName + ": " + columnContent + " | ");
				}
			}

		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		return row;
	}
}
