package swea.d4.p1232;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LocalRunner {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.setIn(new FileInputStream("testdata/p1232/input.txt"));
		Solution.main(new String[0]);
		
	}

}