package StepByStepAlgorithm;

import java.util.Scanner;

public class Level4 {
	public static void main(String[] args) {
		//두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
		Scanner sc = new Scanner(System.in);
		
		
		
		while(true) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			if(num1==0 && num2==0){
				sc.close();
				break;
		}	System.out.println(num1+num2);
	}
		while(sc.hasNextInt()) {
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(a+b);
		}

	}
}
