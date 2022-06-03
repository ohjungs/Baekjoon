package StepByStepAlgorithm;

import java.util.Scanner;

public class Level20_4 {
    // 1629 문제
    // 자연수 A를 B번 곱한 수를 알고 싶다. 단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.

    // 입력
    // 첫째 줄에 A, B, C가 빈 칸을 사이에 두고 순서대로 주어진다. A, B, C는 모두 2,147,483,647 이하의 자연수이다.

    // 출력
    // 첫째 줄에 A를 B번 곱한 수를 C로 나눈 나머지를 출력한다.
    public static long C;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        long A = in.nextLong();
        long B = in.nextLong();
        C = in.nextLong();

        System.out.println(pow(A, B));
    }

    // A^exponent
    public static long pow(long A, long exponent) {

        // 지수가 1일 경우 A^1 이므로 A를 그대로 리턴
        if (exponent == 1) {
            return A % C;
        }

        // 지수의 절반에 해당하는 A^(exponent / 2) 을 구한다.
        long temp = pow(A, exponent / 2);

        /*
         * 현재 지수가 홀 수 였다면
         * A^(exponent / 2) * A^(exponent / 2) * A 이므로
         * A를 한 번 더 곱해주어야 한다.
         * 
         * ex) A^9 = A^4 * A^4 * A
         */
        if (exponent % 2 == 1) {
            return (temp * temp % C) * A % C;
        }
        return temp * temp % C;

    }
}
