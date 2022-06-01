package StepByStepAlgorithm;

import java.util.Scanner;

public class Level20_3 {
    // 1780 종이의 개수 문제
    // N×N크기의 행렬로 표현되는 종이가 있다. 종이의 각 칸에는 -1, 0, 1 중 하나가 저장되어 있다. 우리는 이 행렬을 다음과 같은
    // 규칙에 따라 적절한 크기로 자르려고 한다.

    // 만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
    // (1)이 아닌 경우에는 종이를 같은 크기의 종이 9개로 자르고, 각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.
    // 이와 같이 종이를 잘랐을 때, -1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수, 1로만 채워진 종이의 개수를 구해내는 프로그램을
    // 작성하시오.

    // 입력
    // 첫째 줄에 N(1 ≤ N ≤ 37, N은 3k 꼴)이 주어진다. 다음 N개의 줄에는 N개의 정수로 행렬이 주어진다.

    // 출력
    // 첫째 줄에 -1로만 채워진 종이의 개수를, 둘째 줄에 0으로만 채워진 종이의 개수를, 셋째 줄에 1로만 채워진 종이의 개수를 출력한다.
    public static int[][] board;
    public static int GRAY = 0; // -1에 해당
    public static int WHITE = 0; // 0에 해당
    public static int BLACK = 0; // 1에 해당

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = in.nextInt();
            }
        }

        partition(0, 0, N);

        System.out.println(GRAY); // -1
        System.out.println(WHITE); // 0
        System.out.println(BLACK); // 1

    }

    public static void partition(int row, int col, int size) {

        // 만약 같은 색상으로 이루어져있다면 해당 색상 카운트를 증가시킨다.
        if (colorCheck(row, col, size)) {
            if (board[row][col] == -1) {
                GRAY++;
            } else if (board[row][col] == 0) {
                WHITE++;
            } else {
                BLACK++;
            }

            return;
        }

        int newSize = size / 3;

        partition(row, col, newSize); // 왼쪽 위
        partition(row, col + newSize, newSize); // 중앙 위
        partition(row, col + 2 * newSize, newSize); // 오른쪽 위

        partition(row + newSize, col, newSize); // 왼쪽 중간
        partition(row + newSize, col + newSize, newSize); // 중앙 중간
        partition(row + newSize, col + 2 * newSize, newSize); // 오른쪽 중간

        partition(row + 2 * newSize, col, newSize); // 왼쪽 아래
        partition(row + 2 * newSize, col + newSize, newSize); // 중앙 아래
        partition(row + 2 * newSize, col + 2 * newSize, newSize); // 오른쪽 아래

    }

    // 해당 영역이 같은 색인지 검사하는 메소드
    public static boolean colorCheck(int row, int col, int size) {
        int color = board[row][col];

        // 각 블럭의 시작점(row, col)부터 블럭의 끝(row + size, col + size)까지 검사
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (color != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
