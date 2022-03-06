package StepByStepAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Level17_4 {
    // 1934 최소공배수
    // 문제
    // 두 자연수 A와 B에 대해서, A의 배수이면서 B의 배수인 자연수를 A와 B의 공배수라고 한다. 이런 공배수 중에서 가장 작은 수를
    // 최소공배수라고 한다. 예를 들어, 6과 15의 공배수는 30, 60, 90등이 있으며, 최소 공배수는 30이다.

    // 두 자연수 A와 B가 주어졌을 때, A와 B의 최소공배수를 구하는 프로그램을 작성하시오.

    // 입력
    // 첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 둘째 줄부터 T개의 줄에 걸쳐서 A와 B가 주어진다. (1 ≤
    // A, B ≤ 45,000)

    // 출력
    // 첫째 줄부터 T개의 줄에 A와 B의 최소공배수를 입력받은 순서대로 한 줄에 하나씩 출력한다.
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int d = gcd(a, b);

            sb.append(a * b / d).append('\n');
        }
        System.out.println(sb);

    }

    // 최대공약수 반복문 방식
    public static int gcd(int a, int b) {

        while (b != 0) {
            int r = a % b; // 나머지를 구해준다.

            // GCD(a, b) = GCD(b, r)이므로 변환한다.
            a = b;
            b = r;
        }
        return a;
    }
}
