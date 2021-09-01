package StepByStepAlgorithm;

import java.util.Scanner;

public class Level3_3 {

	public static void main(String[] args) {
//		첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
//		입력
//		첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
//		출력
//		첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
		
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<i; j++) {
//				System.out.print("*");
//			}	
//			System.out.println("");
//		}
//		문제
//		첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
//
//		하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.
//
//		입력
//		첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
//
//		출력
//		첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.

		for(int i=1; i<=n; i++) { //1부터 n까지 i를 1씩 증가시키면서 반복
			for(int j=1; j<=n; j++) { //1부터 n까지 j를 1씩 증가시키면서 반복
				if(j<=n-i) { //j가 n-i보다 작다면 공백 출력
					System.out.printf(" "); 
				}
				else { //j가 i보다 크다면 * 출력
					System.out.printf("*"); //* 출력	
				}
			}
			System.out.println();
		}
	}

}
