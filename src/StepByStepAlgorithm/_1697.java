package StepByStepAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _1697 {
    // 문제
    // 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤
    // 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로
    // 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
    // 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
    // 입력
    // 첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
    // 출력
    // 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
    static int N;
    static int K;

    static int visited[] = new int[100001];

    // X-1, X+1
    // 2*X
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] inputs = input.split(" ");

        N = Integer.valueOf(inputs[0]);
        K = Integer.valueOf(inputs[1]);

        int result = bfs(N);
        System.out.println(result);
    }

    private static int bfs(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(node);
        int index = node;
        int n = 0;
        visited[index] = 1;
        while (queue.isEmpty() == false) {
            n = queue.remove();

            if (n == K) {
                return visited[n] - 1;
            }

            if (n - 1 >= 0 && visited[n - 1] == 0) {
                visited[n - 1] = visited[n] + 1;
                queue.add(n - 1);
            }
            if (n + 1 <= 100000 && visited[n + 1] == 0) {
                visited[n + 1] = visited[n] + 1;
                queue.add(n + 1);
            }
            if (2 * n <= 100000 && visited[2 * n] == 0) {
                visited[2 * n] = visited[n] + 1;
                queue.add(2 * n);
            }
        }
        return -1;
    }
}
