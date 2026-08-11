package swea.d4.p7733;

import java.io.FileInputStream;

public class LocalRunner {

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("testdata/p7733/input.txt"));

        Solution.main(new String[0]);
    }
}