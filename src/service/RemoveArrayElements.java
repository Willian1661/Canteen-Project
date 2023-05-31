package service;

public class RemoveArrayElements {
	public void RemoveLastElement() {
	};

	public String removeLastChar(String s) {
	    return (s == null || s.length() == 0)
	      ? null 
	      : (s.substring(0, s.length() - 1));
	}

}
