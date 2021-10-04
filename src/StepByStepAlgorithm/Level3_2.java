package StepByStepAlgorithm;

import java.util.Scanner;

public class Level3_2 {
//	문제
//	두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
//
//	입력
//	첫째 줄에 테스트 케이스의 개수 T가 주어진다.
//
//	각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
//
//	출력
//	각 테스트 케이스마다 "Case #x: A + B = C" 형식으로 출력한다. x는 테스트 케이스 번호이고 1부터 시작하며, C는 A+B이다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ¿ 문제 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오. 입력 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
		 * 각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10) 출력 각 테스트 케이스마다
		 * "Case #x: "를 출력한 다음, A+B를 출력한다. 테스트 케이스 번호는 1부터 시작한다.
		 */
	Scanner sc = new Scanner(System.in);
	int n= sc.nextInt();
	for(int i=0; i<n; i++) {
		int num1=sc.nextInt();
		int num2=sc.nextInt();
		System.out.println( "Case #"+(i+1) +": " + (num1+num2) );


	}
	}
}
