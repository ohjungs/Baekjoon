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
	static char[] str1;
	static char[] str2;
 
	static Integer[][] dp;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
 
		// toCharArray() 는 문자열을 char[] 배열로 반환해주는 메소드다.
		str1 = in.nextLine().toCharArray();
		str2 = in.nextLine().toCharArray();
		
		dp = new Integer[str1.length][str2.length];
 
		System.out.println(LCS(str1.length - 1, str2.length - 1));
		
	}
	
	static int LCS(int x, int y) {
		
		// 인덱스 밖 (공집합)일 경우 0 반환
		if(x == -1 || y == -1) {
			return 0;
		}
 
		// 만약 탐색하지 않은 인덱스라면?
		if(dp[x][y] == null) {
			dp[x][y] = 0;
 
			// str1의 x번째 문자와 str2의 y번째 문자가 같은지 검사
			if(str1[x] == str2[y]) {
				dp[x][y] = LCS(x - 1, y - 1) + 1;
			}
 
			// 같지 않다면 LCS(dp)[x-1][y]와 LCS(dp)[x,y-1] 중 큰 값으로 초기화
			else {
				dp[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
			}
		}
		
		return dp[x][y];
	}
}
