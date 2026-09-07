package swea.d2.p19645;

import java.io.FileInputStream;

public class LocalRunner {

	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("testdata/p19645/input.txt"));
		Solution.main(new String[0]);
		
	}

}
