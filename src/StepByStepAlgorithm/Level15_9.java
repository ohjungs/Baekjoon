package StepByStepAlgorithm;

import java.util.Scanner;

public class Level15_9 {
	/*
	 * 10844번 쉬운 계단 수 문제 45656이란 수를 보자.
	 * 
	 * 이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다.
	 * 
	 * N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구해보자. 0으로 시작하는 수는 계단수가 아니다.
	 * 
	 * 입력 첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.
	 * 
	 * 출력 첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.
	 */


final static long mod = 1000000000;
    
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		long[][] dp = new long[N + 1][10];
		
		// 첫 번째 자릿수는 오른쪽 맨 끝의 자릿수이므로 경우의 수가 1개밖에 없음 
		for(int i = 1; i < 10; i++) {
			dp[1][i] = 1; 
		}
		
		// 두 번째 자릿수부터 N까지 탐색 
		for(int i = 2; i <= N; i++) {
			
			// i번째 자릿수의 자릿값들을 탐색 (0~9) 
			for(int j = 0; j < 10; j++) {
				
				// j=0, 즉 자릿값이 0이라면 이전 자릿수의 첫번째 자릿수만 가능 
				if(j == 0) {
					dp[i][0] = dp[i - 1][1] % mod;
				}
				// j=9라면 이전 자릿수는 8만 가능
				else if (j == 9) {
					dp[i][9] = dp[i - 1][8] % mod;
				}
				// 그 외의 경우 이전 자릿수의 자릿값 +1, -1 의 합이 됨 
				else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
				}
			}
		}
		
		long result = 0;
		
		// 각 자릿값마다의 경우의 수를 모두 더해준다. 
		for(int i = 0; i < 10; i++) {
			result += dp[N][i];
		}
		
		System.out.println(result % mod);
	}
}
