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

    static int[][] dp;
    public static final int div = 10007;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][K + 1];

        System.out.println(BC(N, K));

    }

    static int BC(int n, int k) {

        // 이미 풀었던 sub문제일 경우 값을 재활용
        if (dp[n][k] > 0) {
            return dp[n][k];
        }

        if (k == 0 || n == k) {
            return dp[n][k] = 1;
        }

        return dp[n][k] = (BC(n - 1, k - 1) + BC(n - 1, k)) % div;
    }
}
