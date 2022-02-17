package StepByStepAlgorithm;

import java.util.Scanner;

public class Level10_3 {
	/*
	 * 2447번 별 찍기
	 * 문제 재귀적인 패턴으로 별을 찍어 보자. N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은
	 * N×N 정사각형 모양이다.
	 * 
	 * 크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.
	 ***
	 * 
	 * *
	 ***
	 * N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다.
	 * 예를 들어 크기 27의 패턴은 예제 출력 1과 같다.
	 * 
	 * 입력 첫째 줄에 N이 주어진다. N은 3의 거듭제곱이다. 즉 어떤 정수 k에 대해 N=3k이며, 이때 1 ≤ k < 8이다.
	 * 
	 * 출력 첫째 줄부터 N번째 줄까지 별을 출력한다.
	 */
	static char[][] arr;
	 
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int N = in.nextInt();
 
			arr = new char[N][N];
			
			star(0, 0, N, false);
 
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(arr[i][j]);
				}
				sb.append('\n');
			}
			System.out.print(sb);
		}
	}
 
	static void star(int x, int y, int N, boolean blank) {
 
		// 공백칸일 경우
		if (blank) {
			for (int i = x; i < x + N; i++) {
				for (int j = y; j < y + N; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}
 
		// 더이상 쪼갤 수 없는 블록일 때
		if (N == 1) {
			arr[x][y] = '*';
			return;
		}
 
		/*
		   N=27 일 경우 한 블록의 사이즈는 9이고, 
		   N=9 일 경우 한 블록의 사이즈는 3이듯
		   해당 블록의 한 칸을 담을 변수를 의미 size
           
		   count는 별 출력 누적을 의미
		 */
 
		int size = N / 3;
		int count = 0;
		for (int i = x; i < x + N; i += size) {
			for (int j = y; j < y + N; j += size) {
				count++;
				if (count == 5) { // 공백 칸일 경우
					star(i, j, size, true);
				} else {
					star(i, j, size, false);
				}
			}
		}
	}
}