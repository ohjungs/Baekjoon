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

	}
};
