package swea.모의SW역량테스트.p5648;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LocalRunner {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("testdata/p5648/input.txt"));
		Solution.main(new String[0]);
	}

}
