import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dbUtils.*;

public class Main {

	public static void main(String[] args) {
		SelectAllDataFrom rad = new SelectAllDataFrom();
		SelectTables gtl = new SelectTables();
		SelectRow rn = new SelectRow();
		InsertData id = new InsertData();
		UpdateData ud = new UpdateData();
		SelectCountTables sct = new SelectCountTables();
		DeleteRow dd = new DeleteRow();
		Table_info ti = new Table_info();
		
//		ti.table_info("users");
		
//		dd.deleteRow(new String[] {"usertest","texto"}, new String[] {"testfoo"});
		
//		ud.updateData(new String[] {"usertest","texto","texto"},new String[] {"testfoo","testbar"});

// 		sct.selectCountTables("users","name");

		rad.SelectAllDataFrom("users");

//		gtl.returnTables("Name");

//		rn.selectRow(new String[] {"*","users","ID","1"});

//		id.insertData(new String[] {"usertest","issofoo"},new String[] {"?"});
	}
}