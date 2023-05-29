package dbUtils;

public class SelectData {
	public SelectData() {
	};

	public void getData(String... arguments) {
		for (String arg : arguments) {
			System.out.print(arg);
		}
	}

	public String returnData(String... arguments) {
		String args = "";
		for (String arg : arguments) {
			args += arg;
		}
		return args;
	}
}