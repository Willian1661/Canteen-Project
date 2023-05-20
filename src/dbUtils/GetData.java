package dbUtils;

public class GetData {
	public GetData() {
	};

	public void getData(String... arguments) {
		for (String arg : arguments) {
			System.out.print(arg);
		}
	}
}