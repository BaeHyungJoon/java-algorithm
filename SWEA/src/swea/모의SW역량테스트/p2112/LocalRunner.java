package swea.모의SW역량테스트.p2112;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LocalRunner {

	public static void main(String[] args) throws NumberFormatException, FileNotFoundException {
		
		System.setIn(new FileInputStream("testdata/p2112/input.txt"));
		Solution.main(new String[0]);

	}

}
