package swea.d2.p2001;

import java.io.FileInputStream;

public class LocalRunner {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("testdata/p2001/input.txt"));
		Solution.main(new String[0]);
	}
}