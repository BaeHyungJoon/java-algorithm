package samsung02;

import java.io.FileInputStream;
import java.io.IOException;

public class LocalRunner {

	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("testdata/input2.txt"));
		Solution.main(new String[0]);
	}

}