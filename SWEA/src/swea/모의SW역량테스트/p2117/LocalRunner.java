package swea.모의SW역량테스트.p2117;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LocalRunner {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("testdata/p2117/input.txt"));
		Solution.main(new String[0]);

	}

}