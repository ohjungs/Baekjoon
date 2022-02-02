package StepByStepAlgorithm;

import java.util.Scanner;

public class Level16_1 {
	/*
	 * 11047번 동전 0 문제 준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다. 동전을 적절히 사용해서 그
	 * 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오. 입력 첫째 줄에 N과 K가 주어진다.
	 * (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000) 둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤
	 * Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수) 출력 첫째 줄에 K원을 만드는데 필요한 동전 개수의
	 * 최솟값을 출력한다.
	 */

	public static void main(String[] args) {
		 
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int K = in.nextInt();
		
		int[] coin = new int[N];
		
		for(int i = 0; i < N; i++) {
			coin[i] = in.nextInt();
		}
		
		int count = 0;
 
		for(int i = N - 1; i >= 0; i--) {
 
			// 현재 동전의 가치가 K보다 작거나 같아야지 구성가능하다.
			if(coin[i] <= K) {
				// 현재 가치의 동전으로 구성할 수 있는 개수를 더해준다.
				count += (K / coin[i]);
				K = K % coin[i];
			}
		}
		System.out.println(count);
	}
}
