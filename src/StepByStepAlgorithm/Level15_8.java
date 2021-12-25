package StepByStepAlgorithm;

import java.util.Scanner;

public class Level15_8 {
	/*
	 * 1463번 1로 만들기 문제 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
	 * 
	 * X가 3으로 나누어 떨어지면, 3으로 나눈다. X가 2로 나누어 떨어지면, 2로 나눈다. 1을 뺀다. 정수 N이 주어졌을 때, 위와 같은
	 * 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
	 * 
	 * 입력 첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.
	 * 
	 * 출력 첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
	 */

	static Integer[] dp;
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		int N = in.nextInt();
 
		dp = new Integer[N + 1];
		dp[0] = dp[1] = 0;
 
		System.out.print(recur(N));
 
	}
 
	static int recur(int N) {
 
		if (dp[N] == null) {
			// 6으로 나눠지는 경우 
			if (N % 6 == 0) {
				dp[N] = Math.min(recur(N - 1), Math.min(recur(N / 3), recur(N / 2))) + 1;
			}
			// 3으로만 나눠지는 경우 
			else if (N % 3 == 0) {
				dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
			}
			// 2로만 나눠지는 경우 
			else if (N % 2 == 0) {
				dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
			}
			// 2와 3으로 나누어지지 않는 경우
			else {
				dp[N] = recur(N - 1) + 1;
			}
		}
		return dp[N];
	}
 
}
