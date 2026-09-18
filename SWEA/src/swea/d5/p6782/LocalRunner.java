package swea.d5.p6782;

import java.io.FileInputStream;
import java.io.IOException;

public class LocalRunner {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("testdata/p6782/input.txt"));
		Solution.main(new String[0]);
	}

}
