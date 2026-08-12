package swea.d5.p7793;

import java.io.FileInputStream;

public class LocalRunner {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("testdata/p7793/input.txt"));
		Solution.main(new String[0]);
	}
}