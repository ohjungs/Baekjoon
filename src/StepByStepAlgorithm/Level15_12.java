package StepByStepAlgorithm;

import java.util.Scanner;

public class Level15_12 {
	/*
	 * 11054 가장 긴 바이토닉 부분 수열 문제 수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 >
	 * ... SN-1 > SN을 만족한다면, 그 수열을 바이토닉 수열이라고 한다.
	 * 
	 * 예를 들어, {10, 20, 30, 25, 20}과 {10, 20, 30, 40}, {50, 40, 25, 10} 은 바이토닉 수열이지만,
	 * {1, 2, 3, 2, 1, 2, 3, 2, 1}과 {10, 20, 30, 40, 20, 30} 은 바이토닉 수열이 아니다.
	 * 
	 * 수열 A가 주어졌을 때, 그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이를 구하는 프로그램을 작성하시오.
	 * 
	 * 입력 첫째 줄에 수열 A의 크기 N이 주어지고, 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ N ≤ 1,000, 1 ≤
	 * Ai ≤ 1,000)
	 * 
	 * 출력 첫째 줄에 수열 A의 부분 수열 중에서 가장 긴 바이토닉 수열의 길이를 출력한다.
	 */
	static Integer[] r_dp;
	static Integer[] l_dp;
	static int[] seq;
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		int N = in.nextInt();
        
		r_dp = new Integer[N];	// LIS dp
		l_dp = new Integer[N];	// LDS dp
		seq = new int[N];
 
 
		for (int i = 0; i < N; i++) {
			seq[i] = in.nextInt();
		}
 
		for (int i = 0; i < N; i++) {
			LIS(i);
			LDS(i);
		}
 
		int max = -1;
		for (int i = 0; i < N; i++) {
			max = Math.max(r_dp[i] + l_dp[i], max);
		}
		System.out.println(max - 1);
 
	}
 
	static int LIS(int N) {
 
		// 만약 탐색하지 않던 위치의 경우
		if (r_dp[N] == null) {
			r_dp[N] = 1; // 1로 초기화
 
			// N 이전의 노드들을 탐색
			for (int i = N - 1; i >= 0; i--) {
				// 이전의 노드 중 seq[N]의 값보다 작은 걸 발견했을 경우
				if (seq[i] < seq[N]) {
					r_dp[N] = Math.max(r_dp[N], LIS(i) + 1);
				}
			}
		}
		return r_dp[N];
	}
 
	static int LDS(int N) {
		
		// 만약 탐색하지 않던 위치의 경우
		if (l_dp[N] == null) {
			l_dp[N] = 1; // 1로 초기화
 
			// N 이후의 노드들을 탐색
			for (int i = N + 1; i < l_dp.length; i++) {
				// 이후의 노드 중 seq[N]의 값보다 작은 걸 발견했을 경우
				if (seq[i] < seq[N]) {
					l_dp[N] = Math.max(l_dp[N], LDS(i) + 1);
				}
			}
		}
		return l_dp[N];
	}
}
