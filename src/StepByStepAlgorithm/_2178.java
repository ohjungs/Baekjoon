package StepByStepAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2178 {
    // N×M크기의 배열로 표현되는 미로가 있다.

    // 1 0 1 1 1 1
    // 1 0 1 0 1 0
    // 1 0 1 0 1 1
    // 1 1 1 0 1 1
    // 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여
    // (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한
    // 칸으로만 이동할 수 있다.

    // 위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

    // 입력
    // 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은
    // 붙어서 입력으로 주어진다.

    // 출력
    // 첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

    static int[][] map;
    static int n;
    static int m;
    static int minVal;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        visited = new boolean[n][m];
        visited[0][0] = true;
        minVal = Integer.MAX_VALUE;
        dfs(0, 0, 1);
        System.out.println(minVal);
    }

    public static void dfs(int x, int y, int count) {
        if (x == n - 1 && y == m - 1) {
            minVal = Math.min(minVal, count);
            return;
        }

        if (count > minVal)
            return; // 가지치기 - 이미 count가 minVal보다 커졌다면 return;

        // 방향배열 사용하지 않고 조건문으로 4가지를 나누어 보았다.
        if (x > 0 && !visited[x - 1][y] && map[x - 1][y] == 1) { // 상
            visited[x - 1][y] = true;
            dfs(x - 1, y, count + 1);
            visited[x - 1][y] = false;
        }
        if (x < n - 1 && !visited[x + 1][y] && map[x + 1][y] == 1) { // 하
            visited[x + 1][y] = true;
            dfs(x + 1, y, count + 1);
            visited[x + 1][y] = false;
        }
        if (y > 0 && !visited[x][y - 1] && map[x][y - 1] == 1) { // 좌
            visited[x][y - 1] = true;
            dfs(x, y - 1, count + 1);
            visited[x][y - 1] = false;
        }
        if (y < m - 1 && !visited[x][y + 1] && map[x][y + 1] == 1) { // 우
            visited[x][y + 1] = true;
            dfs(x, y + 1, count + 1);
            visited[x][y + 1] = false;
        }
    }
}
