package StepByStepAlgorithm;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
    static int[][] check; // 간선 연결상태
    static boolean[] checked; // 확인 여부
    static int n; // 정점개수
    static int m; // 간선개수
    static int start; // 시작정점

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        check = new int[1001][1001]; // 좌표를 그대로 받아들이기 위해 +1해서 선언
        checked = new boolean[1001]; // 초기값 False

        // 간선 연결상태 저장
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            check[x][y] = check[y][x] = 1;
        }

        dfs(start); // dfs호출

        checked = new boolean[1001]; // 확인상태 초기화
        System.out.println(); // 줄바꿈

        bfs(); // bfs호출
    }

    // 시작점을 변수로 받아 확인, 출력 후 다음 연결점을 찾아 시작점을 변경하여 재호출
    public static void dfs(int i) {
        checked[i] = true;
        System.out.print(i + " ");

        for (int j = 1; j <= n; j++) {
            if (check[i][j] == 1 && checked[j] == false) {
                dfs(j);
            }
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start); // 시작점도 Queue에 넣어야 함
        checked[start] = true;
        System.out.print(start + " ");

        // Queue가 빌 때까지 반복. 방문 정점은 확인, 출력 후 Queue에 넣어 순서대로 확인
        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int j = 1; j <= n; j++) {
                if (check[temp][j] == 1 && checked[j] == false) {
                    queue.offer(j);
                    checked[j] = true;
                    System.out.print(j + " ");
                }
            }
        }
    }
}
