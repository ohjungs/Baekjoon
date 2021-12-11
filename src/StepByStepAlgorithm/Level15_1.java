package StepByStepAlgorithm;

import java.util.Scanner;

public class Level15_1 {
	/* 1003번 파보나치 함수
	 * 문제 다음 소스는 N번째 피보나치 수를 구하는 C++ 함수이다.
	 * 
	 * int fibonacci(int n) { if (n == 0) { printf("0"); return 0; } else if (n ==
	 * 1) { printf("1"); return 1; } else { return fibonacci(n‐1) + fibonacci(n‐2);
	 * } } fibonacci(3)을 호출하면 다음과 같은 일이 일어난다.
	 * 
	 * fibonacci(3)은 fibonacci(2)와 fibonacci(1) (첫 번째 호출)을 호출한다. fibonacci(2)는
	 * fibonacci(1) (두 번째 호출)과 fibonacci(0)을 호출한다. 두 번째 호출한 fibonacci(1)은 1을 출력하고 1을
	 * 리턴한다. fibonacci(0)은 0을 출력하고, 0을 리턴한다. fibonacci(2)는 fibonacci(1)과
	 * fibonacci(0)의 결과를 얻고, 1을 리턴한다. 첫 번째 호출한 fibonacci(1)은 1을 출력하고, 1을 리턴한다.
	 * fibonacci(3)은 fibonacci(2)와 fibonacci(1)의 결과를 얻고, 2를 리턴한다. 1은 2번 출력되고, 0은 1번
	 * 출력된다. N이 주어졌을 때, fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성하시오.
	 * 
	 * 입력 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
	 * 
	 * 각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. N은 40보다 작거나 같은 자연수 또는 0이다.
	 * 
	 * 출력 각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.
	 */
static Integer[][] dp = new Integer[41][2];
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		dp[0][0] = 1;	// N=0 일 때의 0 호출 횟수
		dp[0][1] = 0;	// N=0 일 때의 1 호출 횟수
		dp[1][0] = 0;	// N=1 일 때의 0 호출 횟수
		dp[1][1] = 1;	// N=1 일 때의 1 호출 횟수
		
		int T = in.nextInt();
        
		while(T-- > 0){
			int N = in.nextInt();
			fibonacci(N);
			System.out.println(dp[N][0] + " " + dp[N][1]);
		}
		
	}
	
	static Integer[] fibonacci(int N) {
		// N에 대한 0, 1의 호출 횟수가 없을 떄(탐색하지 않은 값일 때)
		if(dp[N][0] == null || dp[N][1] == null) {
			// 각 N에 대한 0 호출 횟수와 1 호출 횟수를 재귀호출한다.
			dp[N][0] = fibonacci(N - 1)[0] + fibonacci(N - 2)[0];
			dp[N][1] = fibonacci(N - 1)[1] + fibonacci(N - 2)[1];
		}
		// N에 대한 0과 1, 즉 [N][0]과 [N][1] 을 담고있는 [N]을 반환한다.
		return dp[N];
 
	}
 	
}
