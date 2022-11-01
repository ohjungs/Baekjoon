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

    static boolean visit[][];
    static int maze[][];
    static int dirY[] = { -1, 1, 0, 0 };
    static int dirX[] = { 0, 0, -1, 1 };
    static Queue<Node> que = new LinkedList<>();

    static int now_x, now_y;
    static int x, y;
    static int N, M;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        visit = new boolean[N][M];
        maze = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char ch = str.charAt(j);
                maze[i][j] = Character.getNumericValue(ch);
            }
        }

        BFS(0, 0);
        System.out.println(maze[N - 1][M - 1]);
    }

    static void BFS(int x, int y) {
        que.offer(new Node(x, y));
        visit[y][x] = true;

        while (!que.isEmpty()) {
            Node node = que.poll();

            for (int i = 0; i < 4; i++) {
                now_y = node.y + dirY[i];
                now_x = node.x + dirX[i];

                if (Range_check() == true && visit[now_y][now_x] == false && maze[now_y][now_x] == 1) {
                    que.offer(new Node(now_x, now_y));
                    visit[now_y][now_x] = true;

                    maze[now_y][now_x] = maze[node.y][node.x] + 1;
                    if (visit[N - 1][M - 1] == true) {
                        return;
                    }

                }
            }
        }
    }

    public static boolean Range_check() {
        return (now_x >= 0 && now_x < M && now_y >= 0 && now_y < N);
    }
}
