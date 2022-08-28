package StepByStepAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
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
    static int n, m;// 추의 개수 구슬의 개수
    static int[] chu;// 추
    static int[] ball;// 구슬
    static boolean[] flag = new boolean[40001];// 구슬 무게는 40000까지 가능
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        chu = new int[n]; // 추의 무게
        arr.add(0);// 처음 계산하기 위한 수 0을 넣어준다.
        flag[0] = true; // 무게의 차가 0인 것을 초기화해서 true
        for (int i = 0; i < n; i++) {
            chu[i] = sc.nextInt();
        }
        m = sc.nextInt();
        ball = new int[m];
        for (int i = 0; i < m; i++) {
            ball[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int size = arr.size(); // 앞의 추에서 이미 계산한 무게만큼만 돌려준다.
            for (int j = 0; j < size; j++) { // 앞에 계산된 무게에서 현재 무게를 더하고 빼는 경우 구해준다.
                int x = arr.get(j);// 계산된 무게 중 하나
                if (x + chu[i] <= 40000 && flag[x + chu[i]] == false) {// 이전까지 가능한 무게에서 더했을 때
                    arr.add(x + chu[i]); // 새로운 무게 더해줌
                    flag[x + chu[i]] = true;
                }
                if (flag[Math.abs(x - chu[i])] == false) {// 현재 추의 무게와 이전에 계산된 무게들의 차
                    arr.add(Math.abs(x - chu[i]));
                    flag[Math.abs(x - chu[i])] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (flag[ball[i]]) { // 계산되었던 수라면 가능하다 y
                System.out.print("Y ");
            } else {
                System.out.print("N ");
            }
        }
    }
}
