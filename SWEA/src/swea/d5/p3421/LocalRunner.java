package swea.d5.p3421;

import java.io.FileInputStream;
import java.io.IOException;

public class LocalRunner {

	public static void main(String[] args) throws IOException{
		
		System.setIn(new FileInputStream("testdata/p3421/input.txt"));
		Solution.main(new String[0]);
		
	}

}