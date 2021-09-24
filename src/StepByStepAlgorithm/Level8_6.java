package StepByStepAlgorithm;

import java.util.Scanner;

public class Level8_6 {
	/*
	 * 2775번 부녀회장이 될테야 문제 평소 반상회에 참석하는 것을 좋아하는 주희는 이번 기회에 부녀회장이 되고 싶어 각 층의 사람들을 불러
	 * 모아 반상회를 주최하려고 한다.
	 * 
	 * 이 아파트에 거주를 하려면 조건이 있는데, “a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을
	 * 데려와 살아야 한다” 는 계약 조항을 꼭 지키고 들어와야 한다.
	 * 
	 * 아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정했을 때, 주어지는 양의 정수 k와 n에 대해 k층에
	 * n호에는 몇 명이 살고 있는지 출력하라. 단, 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.
	 * 
	 * 입력 첫 번째 줄에 Test case의 수 T가 주어진다. 그리고 각각의 케이스마다 입력으로 첫 번째 줄에 정수 k, 두 번째 줄에 정수
	 * n이 주어진다
	 * 
	 * 출력 각각의 Test case에 대해서 해당 집에 거주민 수를 출력하라.
	 * 
	 * 제한 1 ≤ k, n ≤ 14
	 */
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
		
		// 아파트 생성 
		int[][] APT = new int[15][15];
 
		for(int i = 0; i < 15; i++) {
			APT[i][1] = 1;	// i층 1호
			APT[0][i] = i;	// 0층 i호
		}
 
 
		for(int i = 1; i < 15; i ++) {	// 1층부터 14층까지
 
			for(int j = 2; j < 15; j++) {	// 2호부터 14호까지
				APT[i][j] = APT[i][j - 1] + APT[i - 1][j];
			}
		}
		
		// 테스트 부분 		
		int T = in.nextInt();
		
		for(int i = 0; i < T; i++) {
			int k = in.nextInt();
			int n = in.nextInt();
			System.out.println(APT[k][n]);
		}
	}
}
