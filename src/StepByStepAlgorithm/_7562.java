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
    static int tt;
    static int n;
    static int x1, y1;
    static int x2, y2;

    static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
    static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };

    static int[][] visited = new int[301][301];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        tt = Integer.parseInt(st.nextToken());

        while (tt-- != 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            cleanVisited();

            bfs(x1, y1, x2, y2);

            System.out.println(visited[x2][y2]);
        }

    }

    public static void bfs(int a, int b, int c, int d) {

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(a, b));
        visited[a][b] = 0;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.x == c && p.y == d)
                break;

            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny & ny < n &&
                        (visited[nx][ny] == -1 || visited[p.x][p.y] + 1 < visited[nx][ny])) {
                    visited[nx][ny] = visited[p.x][p.y] + 1;
                    q.add(new Point(nx, ny));
                }
            }

        }

    }

    public static void cleanVisited() {
        for (int i = 0; i <= 300; i++)
            for (int j = 0; j <= 300; j++)
                visited[i][j] = -1;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
