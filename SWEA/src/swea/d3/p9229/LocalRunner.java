package swea.d3.p9229;

import java.io.FileInputStream;

public class LocalRunner {

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("testdata/p9229/input.txt"));
		Solution.main(new String[0]);
		
	}

}
