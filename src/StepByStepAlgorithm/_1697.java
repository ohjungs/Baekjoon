package StepByStepAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

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
    static int check[]; // 방문여부 배열

    public static void bfs(int a, int k) { // BFS메소드, 수빈이의 위치와 동생의 위치를 전달
        Queue<Integer> queue = new LinkedList();

        check[a] = 0; // 수빈이의 위치를 0으로 초기화
        queue.offer(a);

        while (!queue.isEmpty()) { // 큐가 빌 때 까지 반복한다.
            int x = queue.poll();
            if (check[k] != 0)
                break; // 그러나 동생의 위치값이 0이 아니면 이미 최솟값을 찾은 것이므로 벗어난다.
                       // 배열의 크기를 100,001로 해서 시간을 조금이라도 단축시키기 위함
            if ((x - 1 >= 0) && check[x - 1] == 0) { // 이 부분에서 많은 분들이 런타임 에러가 많이 발생하는 것 같다.
                queue.offer(x - 1); // 조건부의 x범위를 먼저 확인해줘야 뒤에 배열 인덱스를 참조할 때 범위를 벗어나지 않는다.
                check[x - 1] = check[x] + 1; // 이동할 수 있는 경우 x-1
            }
            if ((x < check.length - 1) && check[x + 1] == 0) {
                queue.offer(x + 1);
                check[x + 1] = check[x] + 1; // 이동할 수 있는 경우 x+1
            }
            if ((x * 2 < check.length) && check[2 * x] == 0) {
                queue.offer(2 * x);
                check[2 * x] = check[x] + 1; // 이동할 수 있는 경우 순간이동 x*2
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 수빈이 위치
        int k = sc.nextInt(); // 동생 위치
        check = new int[100001]; // 수빈이와 동생이 위치할 수 있는 범위는 0 ~ 100,000이다.

        if (n == k) { // 만약 수빈이와 동생의 위치가 같다면 이동할 필요가 없다.
            System.out.println("0"); // 이 부분에서 오답처리를 받았다. 예외의 경우를 항상 생각하자.
            return;
        }
        bfs(n, k); // bfs로 수빈이와 동생의 위치를 전달한다.

        System.out.println(check[k]); // 수빈이 위치 인덱스 값을 출력한다.

    }
}
