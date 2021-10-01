package StepByStepAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Level2_1 {
	public static void main(String[] args) {
//		int a = 12, b = 10;
//		if (a > b) {
//			System.out.println(">");
//		} else if (a < b) {
//			System.out.println("<");
//		} else {
//			System.out.println("==");
//		}
//		;
//		System.out.println(a > b ? "a가크다" : "b가 크다.");
//		System.out.println("============");
//
//		for (int i = 0; i < 10; i++) {
//			if (i < 10)
//				System.out.print("변한 값" + i);
//			System.out.print("이후 값" + i);
//			System.out.println();
//
//		}
		//시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.
//		int score = 60;
//		if (score >= 90 ) { 
//			System.out.println("A학점");
//			} else if (score >= 80) {
//			System.out.println("B학점");
//		} else if (score >= 70) {
//			System.out.println("C학점");
//		}else if (score >= 60) {
//			System.out.println("D학점");
//		}else { System.out.println("F학점");}

//		연도가 주어졌을 때, 윤년이면 1, 아니면 0을 출력하는 프로그램을 작성하시오.
//		윤년은 연도가 4의 배수이면서, 100의 배수가 아닐 때 또는 400의 배수일 때이다.
//		예를 들어, 2012년은 4의 배수이면서 100의 배수가 아니라서 윤년이다. 1900년은 100의 배수이고 400의 배수는 아니기 때문에 윤년이 아니다. 하지만, 2000년은 400의 배수이기 때문에 윤년이다.
//		int y = 2000;
//		if(y%4==0) {
//			if(y%400==0) System.out.println("1");
//			else if(y%100==0) System.out.println("0");
//			else System.out.println("1");
//		}
//		else System.out.println("0");
//		System.out.print((y%4==0)?((y%400==0)?"1":(y%100==0)?"0":"1"):"0");
//		
		
		
//흔한 수학 문제 중 하나는 주어진 점이 어느 사분면에 속하는지 알아내는 것이다. 사분면은 아래 그림처럼 1부터 4까지 번호를 갖는다. "Quadrant n"은 "제n사분면"이라는 뜻이다.
// 1사분면 ++, 2사분면 -,+ 3사분면 -, - 4사분면 -, + 
//		Scanner scanner = new Scanner(System.in);
//		int X = scanner.nextInt();
//		int Y = scanner.nextInt();
//		
//		if(X > 0) {
//			if(Y > 0) {
//				System.out.print(1);
//			} 
//			else {
//				System.out.print(4);
//			}
//		} 
//		
//		else {
//			if(Y > 0) {
//				System.out.print(2);
//			} 
//			else {
//				System.out.print(3);
//			}
//		}
		
		/*
		 * 첫째 줄에 두 정수 H와 M이 주어진다. (0 ≤ H ≤ 23, 0 ≤ M ≤ 59) 그리고 이것은 현재 상근이가 설정한 놓은 알람 시간
		 * H시 M분을 의미한다. 입력 시간은 24시간 표현을 사용한다. 24시간 표현에서 하루의 시작은 0:0(자정)이고, 끝은 23:59(다음날
		 * 자정 1분 전)이다. 시간을 나타낼 때, 불필요한 0은 사용하지 않는다
		 * 첫째 줄에 상근이가 창영이의 방법을 사용할 때, 설정해야 하는 알람 시간을 출력한다. (입력과 같은 형태로 출력하면 된다.)
		 */
		
		/*
		 * 1-1 단계 : 45분보다 작은지 여부 - if (min < 45 )
		 * 
		 * 2-1 단계 : 시(hour) 가 0보다 작은지 여부 - if (hour < 0 )
		 * 
		 * 1-2 단계 : 1단계 조건 외 여부 - else
		 */
		Scanner in = new Scanner(System.in);
		
		int H = in.nextInt(); // 시
		int M = in.nextInt(); // 분
		in.close();
		
		if(M < 45) {
			H--;		// 시(hour) 1 감소
			M= 60 - (45 - M); 	// 분(min) 감소
			if(H < 0) {
				H = 23;
			}
			System.out.println(H + " " + M);
		}
		else {
			System.out.println(H + " " + (M - 45));
		}
			
		
		
		
		
		
		
	}
		
	}

