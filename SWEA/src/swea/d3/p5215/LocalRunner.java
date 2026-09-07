package swea.d3.p5215;

import java.io.FileInputStream;
import java.io.IOException;

public class LocalRunner {

	public static void main(String[] args) throws IOException{
		
		System.setIn(new FileInputStream("testdata/p5215/input.txt"));
		Solution.main(new String[0]);
		
	}

}