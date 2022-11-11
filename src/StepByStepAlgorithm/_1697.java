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
    static int n, k;
    static int[] arr;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n >= k) {
            System.out.println(n - k);
        } else {
            System.out.println(bfs());
        }

    }

    static int bfs() {

        // 시간을 저장하는 배열선언
        arr = new int[100001];
        q.add(n);
        arr[n] = 1;
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i = 0; i < 3; i++) {
                int nx;
                if (i == 0)
                    nx = x - 1;
                else if (i == 1)
                    nx = x + 1;
                else
                    nx = x * 2;

                if (nx == k)
                    return arr[x];

                if (nx >= 0 && nx < 100001 && arr[nx] == 0) {
                    arr[nx] = arr[x] + 1;
                    q.add(nx);
                }
            }
        }
        return 0;
    }
}
