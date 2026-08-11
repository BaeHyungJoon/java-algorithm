package swea.d4.p1226;

import java.io.FileInputStream;

import swea.d4.p1226.Solution;

public class LocalRunner {

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("testdata/p1226/input.txt"));

        Solution.main(new String[0]);
    }
}