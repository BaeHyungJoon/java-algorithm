package swea.d4.p4008;

import java.io.FileInputStream;
import java.io.IOException;

public class LocalRunner {

	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("testdata/p4008/input.txt"));
		Solution.main(new String[0]);
	}

}
