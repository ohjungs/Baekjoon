package StepByStepAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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

	static int N;
	static int[] seq;
	static int[] r_dp;
	static int[] l_dp;
	
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		N = Integer.parseInt(br.readLine());
		
		r_dp = new int[N];	// LIS
		l_dp = new int[N];	// LDS
		seq = new int[N];
		
 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
 
		LIS();
		LDS();
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			if(max < r_dp[i] + l_dp[i]) {
				max = r_dp[i] + l_dp[i];
			}
		}
 
		System.out.println(max - 1);
	}
 
	
	
	static void LIS() {
 
		for(int i = 0; i < N; i++) {
			r_dp[i] = 1;
		    
			// 0 ~ i 이전 원소들 탐색
			for(int j = 0; j < i; j++) {
		    
				// j번째 원소가 i번째 원소보다 작으면서 i번째 dp가 j번째 dp+1 값보다 작은경우
				if(seq[j] < seq[i] && r_dp[i] < r_dp[j] + 1) {
					r_dp[i] = r_dp[j] + 1;	// j번째 원소의 +1 값이 i번째 dp가 된다.
				}
			}
		}
	}
 
 
	
	static void LDS() {
 
		// 뒤에서부터 시작 
		for (int i = N - 1; i >= 0; i--) {
			l_dp[i] = 1;
			
			// 맨 뒤에서 i 이전 원소들을 탐색 
			for (int j = N - 1; j > i; j--) {
				
				// i번째 원소가 j번째 원소보다 크면서 i번째 dp가 j번째 dp+1 값보다 작은경우 
				if (seq[j] < seq[i] && l_dp[i] < l_dp[j] + 1) {
					l_dp[i] = l_dp[j] + 1;	// j번쨰 원소의 +1이 i번쨰 dp값이 됨
				}
			}
		}
	
	}
}
