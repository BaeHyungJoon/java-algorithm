package swea.d5.p1907;

import java.io.FileInputStream;

public class LocalRunner {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("testdata/p1907/input.txt"));
		Solution.main(new String[0]);
	}
}