import view.*;
import dbUtils.SelectRow;

public class Build {
	static int severalTime = 0;
	public static void main(String[] args) {
		
		new SelectRow(new String[] { "*", "users", "ID", "1" });

		new MainPage();
	}
}