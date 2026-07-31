package swea.d2.p1976;

import java.io.FileInputStream;

public class LocalRunner {

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("testdata/p1976/input.txt"));

        Solution.main(new String[0]);
    }
}