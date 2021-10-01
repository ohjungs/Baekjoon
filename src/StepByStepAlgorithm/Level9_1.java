package StepByStepAlgorithm;

import java.util.Scanner;

public class Level9_1 {
	/*
	 * 1978번 소수찾기 소수 찾기 시간 제한 메모리 제한 제출 정답 맞은 사람 정답 비율 2 초 128 MB 84396 40059 32524
	 * 48.125% 문제 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
	 * 
	 * 입력 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
	 * 
	 * 출력 주어진 수들 중 소수의 개수를 출력한다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int sosuCnt = 0, cnt = 0;

		for (int i = 1; i <= num; i++) {
			int num2 = sc.nextInt();
			sosuCnt = 0;

			for (int j = 1; j <= num2; j++) {
				if (num2 % j == 0)
					sosuCnt++;
			}

			if (sosuCnt == 2)
				cnt++;
		}
		System.out.print(cnt);
	
	}
}
