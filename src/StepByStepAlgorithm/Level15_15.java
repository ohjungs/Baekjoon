package StepByStepAlgorithm;

import java.util.Scanner;

public class Level15_15 {
	/*
	 * 1912 연속합 문제 n개의 정수로 이루어진 임의의 수열이 주어진다. 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중
	 * 가장 큰 합을 구하려고 한다. 단, 수는 한 개 이상 선택해야 한다.
	 * 
	 * 예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자. 여기서 정답은 12+21인
	 * 33이 정답이 된다.
	 * 
	 * 입력 첫째 줄에 정수 n(1 ≤ n ≤ 100,000)이 주어지고 둘째 줄에는 n개의 정수로 이루어진 수열이 주어진다. 수는
	 * -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.
	 * 
	 * 출력 첫째 줄에 답을 출력한다.
	 */
	static int[] arr;		// 배열 
	static Integer[] dp;		// 메모이제이션 할 dp
	static int max;			// 최댓값 변수 
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		arr = new int[N];
		dp = new Integer[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}
		
		/*
		 * dp[0]은 첫 원소로 이전에 더이상 탐색할 것이 없기 때문에
		 * arr[0] 자체 값이 되므로 arr[0]으로 초기화 해준다.
		 * max또한 첫 번째 원소로 초기화 해준다.
		 */
		dp[0] = arr[0];
		max = arr[0];
		
		// dp의 마지막 index는 N-1이므로 N-1부터 Top-Down 탐색 
		recur(N - 1);
		
		System.out.println(max);
	}
	
	static int recur(int N) {
		
		// 탐색하지 않은 인덱스라면
		if(dp[N] == null) {
			dp[N] = Math.max(recur(N - 1) + arr[N], arr[N]);
 
			// 해당 dp[N]과 max 중 큰 값으로 max 갱신 
			max = Math.max(dp[N], max);
		}
		
		return dp[N];
	}
}
