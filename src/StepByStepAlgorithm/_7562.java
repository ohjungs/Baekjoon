package StepByStepAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7562 {
    // 나이트의 이동 다국어
    // 시간 제한 메모리 제한 제출 정답 맞힌 사람 정답 비율
    // 1 초 256 MB 43361 21952 16370 49.629%
    // 문제
    // 체스판 위에 한 나이트가 놓여져 있다. 나이트가 한 번에 이동할 수 있는 칸은 아래 그림에 나와있다. 나이트가 이동하려고 하는 칸이
    // 주어진다. 나이트는 몇 번 움직이면 이 칸으로 이동할 수 있을까?

    // 입력
    // 입력의 첫째 줄에는 테스트 케이스의 개수가 주어진다.

    // 각 테스트 케이스는 세 줄로 이루어져 있다. 첫째 줄에는 체스판의 한 변의 길이 l(4 ≤ l ≤ 300)이 주어진다. 체스판의 크기는 l
    // × l이다. 체스판의 각 칸은 두 수의 쌍 {0, ..., l-1} × {0, ..., l-1}로 나타낼 수 있다. 둘째 줄과 셋째 줄에는
    // 나이트가 현재 있는 칸, 나이트가 이동하려고 하는 칸이 주어진다.

    // 출력
    // 각 테스트 케이스마다 나이트가 최소 몇 번만에 이동할 수 있는지 출력한다.
    //
    // 나이트가 이동할 수 있는 경우의 수를 설정해준다.
    static int[] dx = { -2, -1, 2, 1, 2, 1, -2, -1 };
    static int[] dy = { 1, 2, 1, 2, -1, -2, -1, -2 };
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int start_x, start_y, end_x, end_y;
    static int count = 0;
    static Queue<dot> q = new LinkedList<dot>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            visited = new boolean[n][n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            start_x = Integer.parseInt(st.nextToken());
            start_y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            end_x = Integer.parseInt(st.nextToken());
            end_y = Integer.parseInt(st.nextToken());

            bfs(new dot(start_x, start_y));
            System.out.println(map[end_x][end_y]);
        }

    }

    static void bfs(dot d) {
        // 미리 설정해둔 도착지가 되면 return해준다.
        if (d.x == end_x && d.y == end_y) {
            return;
        }
        visited[d.x][d.y] = true;

        q.add(d);

        while (!q.isEmpty()) {
            dot t = q.remove();
            int x1 = t.x;
            int y1 = t.y;

            for (int i = 0; i < dx.length; i++) {
                int x2 = x1 + dx[i];
                int y2 = y1 + dy[i];

                if (x2 >= 0 && x2 < n && y2 >= 0 && y2 < n && !visited[x2][y2]) {
                    q.add(new dot(x2, y2));
                    visited[x2][y2] = true;
                    // 전의 이동 횟수에 +1 씩 더해주며 이동 횟수를 증가시켜준다.
                    map[x2][y2] = map[x1][y1] + 1;
                }
            }
        }

    }

}

class dot {
    int x;
    int y;

    public dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
