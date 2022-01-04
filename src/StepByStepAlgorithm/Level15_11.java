package StepByStepAlgorithm;

import java.util.Scanner;

public class Level15_11 {
	/*
	 * 11053번 문제 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
	 * 
	 * 예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20,
	 * 10, 30, 20, 50} 이고, 길이는 4이다.
	 * 
	 * 입력 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.
	 * 
	 * 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)
	 * 
	 * 출력 첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
	 */
	static int[] seq;
	static Integer[] dp;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		seq = new int[N];
		dp = new Integer[N];
		
		
		for(int i = 0; i < N; i++) {
			seq[i] = in.nextInt();
		}
		
		// 0 ~ N-1 까지 모든 부분수열 탐색 
		for(int i = 0; i < N; i++) {
			LIS(i);
		}
		
		int max = dp[0];
		// 최댓값 찾기 
		for(int i = 1; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
	
	
	static int LIS(int N) {
		
		// 만약 탐색하지 않던 위치의 경우 
		if(dp[N] == null) {
			dp[N] = 1;	// 1로 초기화 
			
			// N-1 부터 0까지중 N보다 작은 값들을 찾으면서 재귀호출. 
			for(int i = N - 1; i >= 0; i--) {
				if(seq[i] < seq[N]) {
					dp[N] = Math.max(dp[N], LIS(i) + 1);
				}
			}
		}
		return dp[N];
	}
	
}
