package StepByStepAlgorithm;

import java.util.Scanner;

public class Level14_6 {
	/*
	 * 2580번 스도쿠 문제 스도쿠는 18세기 스위스 수학자가 만든 '라틴 사각형'이랑 퍼즐에서 유래한 것으로 현재 많은 인기를 누리고 있다.
	 * 이 게임은 아래 그림과 같이 가로, 세로 각각 9개씩 총 81개의 작은 칸으로 이루어진 정사각형 판 위에서 이뤄지는데, 게임 시작 전 일부
	 * 칸에는 1부터 9까지의 숫자 중 하나가 쓰여 있다. 나머지 빈 칸을 채우는 방식은 다음과 같다. 각각의 가로줄과 세로줄에는 1부터 9까지의
	 * 숫자가 한 번씩만 나타나야 한다. 굵은 선으로 구분되어 있는 3x3 정사각형 안에도 1부터 9까지의 숫자가 한 번씩만 나타나야 한다. 위의
	 * 예의 경우, 첫째 줄에는 1을 제외한 나머지 2부터 9까지의 숫자들이 이미 나타나 있으므로 첫째 줄 빈칸에는 1이 들어가야 한다. 또한
	 * 위쪽 가운데 위치한 3x3 정사각형의 경우에는 3을 제외한 나머지 숫자들이 이미 쓰여있으므로 가운데 빈 칸에는 3이 들어가야 한다. 이와
	 * 같이 빈 칸을 차례로 채워 가면 다음과 같은 최종 결과를 얻을 수 있다. 게임 시작 전 스도쿠 판에 쓰여 있는 숫자들의 정보가 주어질 때
	 * 모든 빈 칸이 채워진 최종 모습을 출력하는 프로그램을 작성하시오. 입력 아홉 줄에 걸쳐 한 줄에 9개씩 게임 시작 전 스도쿠판 각 줄에
	 * 쓰여 있는 숫자가 한 칸씩 띄워서 차례로 주어진다. 스도쿠 판의 빈 칸의 경우에는 0이 주어진다. 스도쿠 판을 규칙대로 채울 수 없는
	 * 경우의 입력은 주어지지 않는다. 출력 모든 빈 칸이 채워진 스도쿠 판의 최종 모습을 아홉 줄에 걸쳐 한 줄에 9개씩 한 칸씩 띄워서
	 * 출력한다. 스도쿠 판을 채우는 방법이 여럿인 경우는 그 중 하나만을 출력한다. 제한 baekjoon의 백트래킹 알고리즘으로 풀 수 있는
	 * 입력만 주어진다. 다음은 그 알고리즘의 수행 시간이다. C++14: 80ms Java: 292ms PyPy3: 1172ms
	 */
	public static int[][] arr = new int[9][9];
	 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				arr[i][j] = in.nextInt();
			}
		}
 
		sudoku(0, 0);
 
	}
 
	public static void sudoku(int row, int col) {
 
		// 해당 행이 다 채워졌을 경우 다음 행의 첫 번째 열부터 시작
		if (col == 9) {
			sudoku(row + 1, 0);
			return;
		}
 
		// 행과 열이 모두 채워졌을 경우 출력 후 종료
		if (row == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
 
			// 출력 뒤 시스템을 종료한다.
			System.exit(0);
		}
 
		// 만약 해당 위치가 0 이라면 1부터 9까지 중 가능한 수 탐색
		if (arr[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				// i 값이 중복되지 않는지 검사
				if (possibility(row, col, i)) {
					arr[row][col] = i;
					sudoku(row, col + 1);
				}
			}
			arr[row][col] = 0;
			return;
		}
 
		sudoku(row, col + 1);
 
	}
 
	public static boolean possibility(int row, int col, int value) {
 
		// 같은 행에 있는 원소들 중 겹치는 열 원소가 있는지 검사
		for (int i = 0; i < 9; i++) {
			if (arr[row][i] == value) {
				return false;
			}
		}
 
		// 같은 열에 있는 원소들 중 겹치는 행 원소가 있는지 검사
		for (int i = 0; i < 9; i++) {
			if (arr[i][col] == value) {
				return false;
			}
		}
 
		// 3*3 칸에 중복되는 원소가 있는지 검사
		int set_row = (row / 3) * 3; // value가 속한 3x3의 행의 첫 위치
		int set_col = (col / 3) * 3; // value가 속한 3x3의 열의 첫 위치
 
		for (int i = set_row; i < set_row + 3; i++) {
			for (int j = set_col; j < set_col + 3; j++) {
				if (arr[i][j] == value) {
					return false;
				}
			}
		}
 
		return true; // 중복되는 것이 없을 경우 true 반환
	}
 
}