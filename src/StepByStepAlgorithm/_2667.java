package StepByStepAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class _2667 {
    // 문제
    // <그림 1>과 같이 정사각형 모양의 지도가 있다.
    // 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
    // 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
    // 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.
    // 대각선상에 집이 있는 경우는 연결된 것이 아니다.
    // <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다.
    // 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
    private static int dx[] = { 0, 0, 1, -1 };
    private static int dy[] = { 1, -1, 0, 0 };
    private static int[] aparts = new int[25 * 25];
    private static int n;
    private static int apartNum = 0; // 아파트 단지 번호의 수
    private static boolean[][] visited = new boolean[25][25]; // 방문여부
    private static int[][] map = new int[25][25]; // 지도

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        map = new int[n][n];
        visited = new boolean[n][n];

        // 전체 사각형 입력 받기
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    apartNum++;
                    dfs(i, j);
                }
            }
        }

        Arrays.sort(aparts);
        System.out.println(apartNum);

        for (int i = 0; i < aparts.length; i++) {
            if (aparts[i] == 0) {
            } else {
                System.out.println(aparts[i]);
            }
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        aparts[apartNum]++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
