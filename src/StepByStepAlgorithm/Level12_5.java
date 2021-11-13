package StepByStepAlgorithm;

import java.util.Scanner;

public class Level12_5 {
	/*
	 * 1427번 소트인사이드 문제 배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
	 * 
	 * 입력 첫째 줄에 정렬하려고 하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
	 * 
	 * 출력 첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		 
		int[] counting = new int[10];
 
		int N = in.nextInt();
 
		while (N != 0) {
			counting[N % 10]++;
			N /= 10;
		}
 
		for (int i = 9; i >= 0; i--) {
			while (counting[i]-- > 0) {
				System.out.print(i);
			}
		}
	}
}
