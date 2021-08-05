package oh;

public class Level2 {
	public static void main(String[] args) {
		int a = 12, b = 10;
		if (a > b) {
			System.out.println(">");
		} else if (a < b) {
			System.out.println("<");
		} else {
			System.out.println("==");
		}
		;
		System.out.println(a > b ? "a가크다" : "b가 크다.");
		System.out.println("============");

		for (int i = 0; i < 10; i++) {
			if (i < 10)
				System.out.print("변한 값" + i);
			System.out.print("이후 값" + i);
			System.out.println();

		}
		//시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.
		int score = 60;
		if (score >= 90 ) { 
			System.out.println("A학점");
			} else if (score >= 80) {
			System.out.println("B학점");
		} else if (score >= 70) {
			System.out.println("C학점");
		}else if (score >= 60) {
			System.out.println("D학점");
		}else { System.out.println("F학점");}

//		연도가 주어졌을 때, 윤년이면 1, 아니면 0을 출력하는 프로그램을 작성하시오.
//		윤년은 연도가 4의 배수이면서, 100의 배수가 아닐 때 또는 400의 배수일 때이다.
//		예를 들어, 2012년은 4의 배수이면서 100의 배수가 아니라서 윤년이다. 1900년은 100의 배수이고 400의 배수는 아니기 때문에 윤년이 아니다. 하지만, 2000년은 400의 배수이기 때문에 윤년이다.
		int y = 2000;
		if(y%4==0) {
			if(y%400==0) System.out.println("1");
			else if(y%100==0) System.out.println("0");
			else System.out.println("1");
		}
		else System.out.println("0");
		System.out.print((y%4==0)?((y%400==0)?"1":(y%100==0)?"0":"1"):"0");
	}
		
	}

