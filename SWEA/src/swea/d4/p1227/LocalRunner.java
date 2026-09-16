package swea.d4.p1227;

import java.io.FileInputStream;

public class LocalRunner {

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("testdata/p1227/input.txt"));
		Solution.main(new String[0]);
		
	}

}