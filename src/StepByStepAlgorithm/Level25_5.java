package StepByStepAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Level25_5 {
    // 1260 문제
    // 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는
    // 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

    // 입력
    // 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가
    // 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로
    // 주어지는 간선은 양방향이다.

    // 출력
    // 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

    // DFS에 쓰일 이차원 배열
    static int[][] Dgraph = new int[1001][1001];
    // BFS에 쓰일 이차원 배열
    static int[][] Bgraph = new int[1001][1001];
    static boolean[] Dvisit = new boolean[10001];
    // N은 DFS, BFS 메소드에도 사용되어야 하기 때문에 필드로 선언
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        // 간선을 두개의 그래프 배열에 똑같이 저장해 준다.
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            Dgraph[u][v] = Dgraph[v][u] = 1;
            Bgraph[u][v] = Bgraph[v][u] = 1;
        }
        DFS(V);
        System.out.println();
        BFS(V);
    }

    public static void DFS(int node) {
        Dvisit[node] = true;
        System.out.print(node + " ");

        for (int i = 1; i <= N; i++) {
            if (!Dvisit[i] && Dgraph[node][i] == 1) {
                DFS(i);
            }
        }
    }

    public static void BFS(int node) {
        boolean[] Bvisit = new boolean[10001];
        Queue<Integer> que = new LinkedList<Integer>();
        Bvisit[node] = true;
        que.offer(node);

        while (!que.isEmpty()) {
            int P = que.poll();
            System.out.print(P + " ");

            for (int i = 1; i <= N; i++) {
                if (!Bvisit[i] && Bgraph[P][i] == 1) {
                    Bvisit[i] = true;
                    que.offer(i);
                }
            }
        }
    }
}
