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

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] miro = new char[N][M]; // 미로를 저장할 배열
        int[][] dist = new int[N][M]; // 거리를 계산할 dist 배열
        int[] dx = { 1, 0, -1, 0 }; // 상하좌우 계산할 x좌표
        int[] dy = { 0, 1, 0, -1 }; // 상하좌우 계산할 y좌표
        Queue<Pair> qu = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String line = bf.readLine();
            for (int j = 0; j < M; j++) {
                miro[i][j] = line.charAt(j);
                dist[i][j] = -1; // 거리를 -1로 세팅하면, 방문여부를 확인가능.
            }
        }

        qu.offer(new Pair(0, 0)); // 시작점
        dist[0][0] = 0; // 첫 시작이니까 거리가 0이다.

        while (!qu.isEmpty()) {
            Pair p = qu.poll();

            // 상, 하, 좌, 우를 계산해준다.
            for (int i = 0; i < 4; i++) {
                int nX = p.x + dx[i];
                int nY = p.y + dy[i];

                // 벽에 부딪히거나, 범위를 넘어가면 PASS
                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }
                // 길이 아니거나, 방문을 했다면 PASS
                if (miro[nX][nY] == '0' || dist[nX][nY] != -1) {
                    continue;
                }

                // 큐에 이동한 좌표를 넣어준다.
                qu.offer(new Pair(nX, nY));
                // 한칸 이동하였기 때문에, 이전 출발지점의 거리 +1을 해준다.
                dist[nX][nY] = dist[p.x][p.y] + 1;
            }
        }

        // 마지막 지점의 (거리 + 1)를 출력해주면 된다.
        System.out.print(dist[N - 1][M - 1] + 1);
    }

    // 큐에 좌표를 넣어주기 위한 클래스
    public static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
