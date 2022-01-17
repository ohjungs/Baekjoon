package StepByStepAlgorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Level15_13 {
	/*
	 * 2565번 전깃줄 문제 두 전봇대 A와 B 사이에 하나 둘씩 전깃줄을 추가하다 보니 전깃줄이 서로 교차하는 경우가 발생하였다. 합선의
	 * 위험이 있어 이들 중 몇 개의 전깃줄을 없애 전깃줄이 교차하지 않도록 만들려고 한다. 예를 들어, < 그림 1 >과 같이 전깃줄이 연결되어
	 * 있는 경우 A의 1번 위치와 B의 8번 위치를 잇는 전깃줄, A의 3번 위치와 B의 9번 위치를 잇는 전깃줄, A의 4번 위치와 B의 1번
	 * 위치를 잇는 전깃줄을 없애면 남아있는 모든 전깃줄이 서로 교차하지 않게 된다. < 그림 1 > 전깃줄이 전봇대에 연결되는 위치는 전봇대
	 * 위에서부터 차례대로 번호가 매겨진다. 전깃줄의 개수와 전깃줄들이 두 전봇대에 연결되는 위치의 번호가 주어질 때, 남아있는 모든 전깃줄이
	 * 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 구하는 프로그램을 작성하시오. 입력 첫째 줄에는 두 전봇대 사이의 전깃줄의
	 * 개수가 주어진다. 전깃줄의 개수는 100 이하의 자연수이다. 둘째 줄부터 한 줄에 하나씩 전깃줄이 A전봇대와 연결되는 위치의 번호와
	 * B전봇대와 연결되는 위치의 번호가 차례로 주어진다. 위치의 번호는 500 이하의 자연수이고, 같은 위치에 두 개 이상의 전깃줄이 연결될 수
	 * 없다. 출력 첫째 줄에 남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 출력한다.
	 */
	static Integer[] dp;
	static int[][] wire;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		dp = new Integer[N];
		wire = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			wire[i][0] = in.nextInt();
			wire[i][1] = in.nextInt();
		}
		
		// 첫 번째 원소(A전봇대)를 기준으로 오름차순으로 정
		Arrays.sort(wire, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
 
		int max = 0;
		
		/*
		 *  i번째 A전봇를 기준으로 연결가능한 개수 탐색
		 *  및 최댓값 찾기
		 */
		 
		for(int i = 0; i < N; i++) {
			max = Math.max(recur(i), max);
		}
		
		// 전선 개수 - 쵀댓값 
		System.out.println(N - max);
		
	}
	
	
	static int recur(int N) {
		
		// 탐색하지 않았던 위치라면 
		if(dp[N] == null) {
			
			dp[N] = 1;	// 최솟값 1로 초기화 
			
			// A의 N번째와 이후의 전봇대들 비교 
			for(int i = N + 1; i < dp.length; i++) {
				
				/*
				 *  A전봇대의 N번째 전선이 연결되어있는 B전봇대보다 A의 i번째
				 *  전봇대의 전선이 이어진 B전봇대가 뒤에 있을 경우 
				 *  전선을 설치할 수 있음 
				 */
				if(wire[N][1] < wire[i][1]) {
					// 연결 가능한 전선의 경우의 수 중 큰 값을 dp에 저장한다.
					dp[N] = Math.max(dp[N], recur(i) + 1);
				}
			}
		}
		return dp[N];
	}
}
