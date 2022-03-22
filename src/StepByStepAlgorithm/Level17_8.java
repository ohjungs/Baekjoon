package StepByStepAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Level17_8 {
    // 11051 문제
    // 자연수 \(N\)과 정수 \(K\)가 주어졌을 때 이항 계수
    // \(\binom{N}{K}\)를 10,007로 나눈 나머지를 구하는 프로그램을 작성하시오.

    // 입력
    // 첫째 줄에 \(N\)과 \(K\)가 주어진다. (1 ≤ \(N\) ≤ 1,000, 0 ≤ \(K\) ≤ \(N\))

    // 출력

    // \(\binom{N}{K}\)를 10,007로 나눈 나머지를 출력한다.

    public static final int div = 10007;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        /*
         * n! / ((n-k)! * k!) -> n! * ((n-k)! * k!)^(-1) 으로 변환
         * ((n-k)! * k!)^(-1) == ((n-k)! * k!)^(p-2) 동치
         * p(=div)가 소수여서 가능함)
         */
        System.out.println((factorial(N) * mod_inverse((factorial(N - K) * factorial(K)) % div, div - 2)) % div);
    }

    static int factorial(int N) {
        // factorial(0) == 1 이다.
        if (N <= 1) {
            return 1;
        }
        return (N * factorial(N - 1)) % div;
    }

    // 역원 구하기 (= 제곱승 구하기)
    static int mod_inverse(int a, int p) {
        int ret = 1;
        while (p > 0) {
            if (p % 2 == 1) {
                ret *= a;
                p--;
                ret %= div;
            }
            a *= a;
            a %= div;
            p >>= 1; // p = p/2 랑 동치
        }
        return ret;
    }
}
