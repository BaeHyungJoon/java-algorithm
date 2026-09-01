package swea.d2.p1859;

import java.io.FileInputStream;

public class LocalRunner {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("testdata/p1859/input.txt"));
		Solution.main(new String[0]);
	}
}