package StepByStepAlgorithm;

import java.util.Scanner;

public class Level14_3 {
	/*
	 * 15651번 N과 M(3) 문제 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을
	 * 작성하시오.
	 * 
	 * 1부터 N까지 자연수 중에서 M개를 고른 수열 같은 수를 여러 번 골라도 된다. 입력 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M
	 * ≤ N ≤ 7)
	 * 
	 * 출력 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서
	 * 출력해야 한다.
	 * 
	 * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
	 */

		public static int[] arr;
		public static int N, M;
		public static StringBuilder sb = new StringBuilder();
	 
		public static void main(String[] args) {
	 
			Scanner in = new Scanner(System.in);
	 
			N = in.nextInt();
			M = in.nextInt();
	 
			arr = new int[M];
	        
			dfs(0);
			System.out.print(sb);
	 
		}
	 
		public static void dfs(int depth) {
			// 깊이가 M이랑 같아지면 출력후 return
			if (depth == M) {
				for (int i = 0; i < M; i++) {
					sb.append(arr[i] + " ");
				}
				sb.append('\n');
				return;
			}
	 
			for (int i = 1; i <= N; i++) {
				arr[depth] = i;
				dfs(depth + 1);
			}
	}
}
