import dbUtils.*;
import security.SecureHash;
import view.*;

public class Build {

	public static void main(String[] args) {

//		new DeleteRow(new String[] {"usertest","texto"}, new String[] {"testfoo"});

//		new UpdateData(new String[] {"usertest","texto","texto"},new String[] {"testfoo","testbar"});

// 		new CountTables("canteens","name");

//		new SelectAllDataFrom("menu_canteens");

//		new SelectTables("get","Name");
		new SelectRow(new String[] { "*", "canteens", "ID", "1" });
		new SelectRow(new String[] { "*", "users", "ID", "1" });

		new MainPage();
	}
}