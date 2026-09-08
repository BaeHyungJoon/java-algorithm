package swea.d4.p8275;

import java.io.FileInputStream;
import java.io.IOException;

public class LocalRunner {

	public static void main(String[] args) throws IOException{

		System.setIn(new FileInputStream("testdata/p8275/input.txt"));
		Solution.main(new String[0]);
		
	}

}