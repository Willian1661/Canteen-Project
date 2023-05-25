package dbUtils;

public class SelectData {
	public SelectData() {
	};

	public void getData(String... arguments) {
		for (String arg : arguments) {
			System.out.print(arg);
		}
	}
}