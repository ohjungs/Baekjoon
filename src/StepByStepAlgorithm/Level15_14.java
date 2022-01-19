package StepByStepAlgorithm;

import java.util.Scanner;

public class Level15_14 {
	/*
	 * 9251번 LCS 문제 LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때,
	 * 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.
	 * 
	 * 예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.
	 * 
	 * 입력 첫째 줄과 둘째 줄에 두 문자열이 주어진다. 문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어져 있다.
	 * 
	 * 출력 첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를 출력한다.
	 */
	public static void main(String[] args) {
		 
		Scanner in = new Scanner(System.in);
		
		char[] str1 = in.nextLine().toCharArray();
		char[] str2 = in.nextLine().toCharArray();
		
		int length_1 = str1.length;
		int length_2 = str2.length;
		
		// 공집합 표현을 위해 인덱스가 한 줄씩 추가 됨 
		int[][] dp = new int[length_1 + 1][length_2 + 1];
		
		// 1부터 시작 (index 0 은 공집합이므로 0의 값을 갖고있음) 
		for(int i = 1; i <= length_1; i++) {
			for(int j = 1; j <= length_2; j++) {
				
				// (i-1)과 (j-1) 번째 문자가 서로 같다면  
				if(str1[i - 1] == str2[j - 1]) {
					// 대각선 위 (i-1, j-1)의 dp에 +1 한 값으로 갱신 
					dp[i][j] = dp[i - 1][j - 1] + 1;	
				}
				
				// 같지 않다면 이전 열(i-1)과 이전 행(j-1)의 값 중 큰 것으로 갱신  
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
        
		// Top-Down 때와는 다르게 dp 인덱스가 한 줄씩 추가되었으므로 -1을 하지 않음
		System.out.println(dp[length_1][length_2]);
		
	}
}
