package StepByStepAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
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
    static int[] dr = { -1, -2, -2, -1, 1, 2, 2, 1 };
    static int[] dc = { -2, -1, 1, 2, 2, 1, -1, -2 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int start_r = Integer.parseInt(st.nextToken());
            int start_c = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int end_r = Integer.parseInt(st.nextToken());
            int end_c = Integer.parseInt(st.nextToken());
            bfs(n, new Node(start_r, start_c, 0), new int[] { end_r, end_c });
        }
    }

    public static void bfs(int n, Node start, int[] end) {
        boolean[][] visited = new boolean[n][n];

        Queue<Node> q = new LinkedList<>();
        q.add(start);
        visited[start.r][start.c] = true;

        while (!q.isEmpty()) {
            Node tmp = q.poll();
            if (tmp.r == end[0] && tmp.c == end[1]) {
                System.out.println(tmp.cnt);
                return;
            }
            for (int i = 0; i < 8; i++) {
                int newR = tmp.r + dr[i];
                int newC = tmp.c + dc[i];
                if (0 <= newR && newR < n && 0 <= newC && newC < n && !visited[newR][newC]) {
                    q.add(new Node(newR, newC, tmp.cnt + 1));
                    visited[newR][newC] = true;
                }
            }
        }
    }

    public static class Node {
        int r, c, cnt;

        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}
