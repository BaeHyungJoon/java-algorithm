package programmers.lv3.p77486;

import java.util.Arrays;

public class LocalRunner {

    public static void main(String[] args) {

        Solution solution = new Solution();

        // 예제 1
        String[] enroll1 = {
                "john", "mary", "edward", "sam",
                "emily", "jaimie", "tod", "young"
        };

        String[] referral1 = {
                "-", "-", "mary", "edward",
                "mary", "mary", "jaimie", "edward"
        };

        String[] seller1 = {
                "young", "john", "tod", "emily", "mary"
        };

        int[] amount1 = {
                12, 4, 2, 5, 10
        };

        int[] result1 = solution.solution(
                enroll1,
                referral1,
                seller1,
                amount1
        );

        System.out.println("예제 1");
        System.out.println("실제 결과 : " + Arrays.toString(result1));
        System.out.println("기대 결과 : "
                + Arrays.toString(
                        new int[]{360, 958, 108, 0, 450, 18, 180, 1080}
                )
        );

        System.out.println();


        // 예제 2
        String[] enroll2 = {
                "john", "mary", "edward", "sam",
                "emily", "jaimie", "tod", "young"
        };

        String[] referral2 = {
                "-", "-", "mary", "edward",
                "mary", "mary", "jaimie", "edward"
        };

        String[] seller2 = {
                "sam", "emily", "jaimie", "edward"
        };

        int[] amount2 = {
                2, 3, 5, 4
        };

        int[] result2 = solution.solution(
                enroll2,
                referral2,
                seller2,
                amount2
        );

        System.out.println("예제 2");
        System.out.println("실제 결과 : " + Arrays.toString(result2));
        System.out.println("기대 결과 : "
                + Arrays.toString(
                        new int[]{0, 110, 378, 180, 270, 450, 0, 0}
                )
        );
    }
}