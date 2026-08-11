package swea.d3.p2806;

import java.io.FileInputStream;

public class LocalRunner {

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("testdata/p2806/input.txt"));
		
		Solution.main(new String[0]);
	}

}