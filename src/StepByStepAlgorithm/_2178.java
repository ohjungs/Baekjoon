package StepByStepAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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

    static int n, m;
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        graph = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 1; j <= m; j++) {
                graph[i][j] = Integer.parseInt(line[j - 1]);
            }
        }

        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        Queue<MazePoint> queue = new LinkedList<>();

        queue.add(new MazePoint(1, 1));
        visited[1][1] = true;
        while (!queue.isEmpty()) {
            MazePoint point = queue.remove();
            for (int i = 0; i < dx.length; i++) {
                int xx = point.x + dx[i];
                int yy = point.y + dy[i];
                if (xx > 0 && yy > 0 && xx <= m && yy <= n) {
                    if (graph[yy][xx] != 0 && !visited[yy][xx]) {
                        visited[yy][xx] = true;
                        graph[yy][xx] = graph[point.y][point.x] + 1;
                        queue.add(new MazePoint(xx, yy));
                    }
                }
            }
        }
        bw.write(String.valueOf(graph[n][m]));
        bw.flush();
        bw.close();
    }
}

class MazePoint {
    int x;
    int y;

    MazePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
