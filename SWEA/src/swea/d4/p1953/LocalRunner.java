package swea.d4.p1953;

import java.io.FileInputStream;
import java.io.IOException;

public class LocalRunner {

	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("testdata/p1953/input.txt"));
		Solution.main(new String[0]);
	}

}
