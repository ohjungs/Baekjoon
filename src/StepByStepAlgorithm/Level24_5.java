package StepByStepAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Level24_5 {
    // 2629 양팔저울 문제
    // 양팔 저울과 몇 개의 추가 주어졌을 때, 이를 이용하여 입력으로 주어진 구슬의 무게를 확인할 수 있는지를 결정하려고 한다.

    // 무게가 각각 1g과 4g인 두 개의 추가 있을 경우, 주어진 구슬과 1g 추 하나를 양팔 저울의 양쪽에 각각 올려놓아 수평을 이루면 구슬의
    // 무게는 1g이다. 또 다른 구슬이 4g인지를 확인하려면 1g 추 대신 4g 추를 올려놓으면 된다.

    // 구슬이 3g인 경우 아래 <그림 1>과 같이 구슬과 추를 올려놓으면 양팔 저울이 수평을 이루게 된다. 따라서 각각 1g과 4g인 추가
    // 하나씩 있을 경우 주어진 구슬이 3g인지도 확인해 볼 수 있다.

    // <그림 1> 구슬이 3g인지 확인하는 방법 ($\boxed{1}$은 1g인 추, $\boxed{4}$는 4g인 추, ●은 무게를 확인할
    // 구슬)

    // <그림 2>와 같은 방법을 사용하면 구슬이 5g인지도 확인할 수 있다. 구슬이 2g이면 주어진 추를 가지고는 확인할 수 없다.

    // 추들의 무게와 확인할 구슬들의 무게가 입력되었을 때, 주어진 추만을 사용하여 구슬의 무게를 확인 할 수 있는지를 결정하는 프로그램을
    // 작성하시오.

    // <그림 2> 구슬이 5g인지 확인하는 방법

    // 입력
    // 첫째 줄에는 추의 개수가 자연수로 주어진다. 추의 개수는 30 이하이다. 둘째 줄에는 추의 무게들이 자연수로 가벼운 것부터 차례로
    // 주어진다. 같은 무게의 추가 여러 개 있을 수도 있다. 추의 무게는 500g이하이며, 입력되는 무게들 사이에는 빈칸이 하나씩 있 다. 세
    // 번째 줄에는 무게를 확인하고자 하는 구슬들의 개수가 주어진다. 확인할 구슬의 개수는 7이하이다. 네 번째 줄에는 확인하고자 하는 구슬들의
    // 무게가 자연수로 주어지며, 입력되는 무게들 사이에는 빈 칸이 하나씩 있다. 확인하고자 하는 구슬의 무게는 40,000보다 작거나 같은
    // 자연수이다.

    // 출력
    // 주어진 각 구슬의 무게에 대하여 확인이 가능하면 Y, 아니면 N 을 차례로 출력한다. 출력은 한 개의 줄로 이루어지며, 각 구슬에 대한 답
    // 사이에는 빈칸을 하나씩 둔다.
    static int n;
    static int[] w;
    static boolean[][] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = new int[n];
        result = new boolean[n + 1][40001];
        for (int i = 0; i < n; i++) {
            int src = Integer.parseInt(st.nextToken());
            w[i] = src;
        }

        dp(0, 0);

        for (int j = 0; j < 20; j++) {
            if (result[n][j]) {
                System.out.println(j);
                System.out.print(result[n][j] + " ");
            }
        }

        int c = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            int t = Integer.parseInt(st.nextToken());

            if (result[n][t]) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }

        System.out.println(sb.toString());
    }

    static void dp(int cnt, int num) {
        if (result[cnt][num])
            return;
        result[cnt][num] = true;

        if (cnt == n)
            return;

        dp(cnt + 1, num + w[cnt]);
        dp(cnt + 1, num);
        dp(cnt + 1, Math.abs(num - w[cnt]));

    }
}
