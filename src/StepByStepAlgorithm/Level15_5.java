package StepByStepAlgorithm;

import java.util.Scanner;

public class Level15_5 {
	/*
	 * 1149번 RGB 거리
	 *  문제 RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.
	 * 
	 * 집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을
	 * 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.
	 * 
	 * 1번 집의 색은 2번 집의 색과 같지 않아야 한다. N번 집의 색은 N-1번 집의 색과 같지 않아야 한다. i(2 ≤ i ≤ N-1)번
	 * 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다. 입력 첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 둘째
	 * 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 집을 칠하는 비용은
	 * 1,000보다 작거나 같은 자연수이다.
	 * 
	 * 출력 첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.
	 */
	final static int Red = 0;
	final static int Green = 1;
	final static int Blue = 2;
	
	static int[][] Cost;
	static int[][] DP;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
        
		Cost = new int[N][3];
		DP = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			Cost[i][Red] = in.nextInt();
			Cost[i][Green] = in.nextInt();
			Cost[i][Blue] = in.nextInt();
		}
		
		// DP의 첫번째 값(집)은 각 색상비용의 첫번째 값으로 초기화
		DP[0][Red] = Cost[0][Red];
		DP[0][Green] = Cost[0][Green];
		DP[0][Blue] = Cost[0][Blue];
		
		
		System.out.print(Math.min(Paint_cost(N- 1, Red), Math.min(Paint_cost(N - 1, Green), Paint_cost(N - 1, Blue))));
	}
	
	static int Paint_cost(int N, int color) {
		
		// 만약 탐색하지 않은 배열이라면
		if(DP[N][color] == 0) {
			
			// color의 색에 따라 이전 집의 서로 다른 색을 재귀호출하여 최솟값과 현재 집의 비용을 더해서 DP에 저장한다
			if(color == Red) {
				DP[N][Red] = Math.min(Paint_cost(N - 1, Green), Paint_cost(N - 1, Blue)) + Cost[N][Red];
			}
			else if(color == Green) {
				DP[N][Green] = Math.min(Paint_cost(N - 1, Red), Paint_cost(N - 1, Blue)) + Cost[N][Green];
			}
			else {
				DP[N][Blue] = Math.min(Paint_cost(N - 1, Red), Paint_cost(N - 1, Green)) + Cost[N][Blue];
			}
			
		}
		
		return DP[N][color];
	}

}
