package swea.d3.p1225;

import java.io.FileInputStream;

public class LocalRunner {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("testdata/p1225/input.txt")); 
		Solution.main(new String[0]);
	}
}