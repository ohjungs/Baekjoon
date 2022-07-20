package StepByStepAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Level22_4 {
    // 2805 문제
    // 상근이는 나무 M미터가 필요하다. 근처에 나무를 구입할 곳이 모두 망해버렸기 때문에, 정부에 벌목 허가를 요청했다. 정부는 상근이네 집
    // 근처의 나무 한 줄에 대한 벌목 허가를 내주었고, 상근이는 새로 구입한 목재절단기를 이용해서 나무를 구할것이다.

    // 목재절단기는 다음과 같이 동작한다. 먼저, 상근이는 절단기에 높이 H를 지정해야 한다. 높이를 지정하면 톱날이 땅으로부터 H미터 위로
    // 올라간다. 그 다음, 한 줄에 연속해있는 나무를 모두 절단해버린다. 따라서, 높이가 H보다 큰 나무는 H 위의 부분이 잘릴 것이고, 낮은
    // 나무는 잘리지 않을 것이다. 예를 들어, 한 줄에 연속해있는 나무의 높이가 20, 15, 10, 17이라고 하자. 상근이가 높이를 15로
    // 지정했다면, 나무를 자른 뒤의 높이는 15, 15, 10, 15가 될 것이고, 상근이는 길이가 5인 나무와 2인 나무를 들고 집에 갈
    // 것이다. (총 7미터를 집에 들고 간다) 절단기에 설정할 수 있는 높이는 양의 정수 또는 0이다.

    // 상근이는 환경에 매우 관심이 많기 때문에, 나무를 필요한 만큼만 집으로 가져가려고 한다. 이때, 적어도 M미터의 나무를 집에 가져가기
    // 위해서 절단기에 설정할 수 있는 높이의 최댓값을 구하는 프로그램을 작성하시오.

    // 입력
    // 첫째 줄에 나무의 수 N과 상근이가 집으로 가져가려고 하는 나무의 길이 M이 주어진다. (1 ≤ N ≤ 1,000,000, 1 ≤ M ≤
    // 2,000,000,000)

    // 둘째 줄에는 나무의 높이가 주어진다. 나무의 높이의 합은 항상 M보다 크거나 같기 때문에, 상근이는 집에 필요한 나무를 항상 가져갈 수
    // 있다. 높이는 1,000,000,000보다 작거나 같은 양의 정수 또는 0이다.

    // 출력
    // 적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값을 출력한다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];

        int min = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());

            /*
             * 나무들 중 최댓값을 구하기 위해 매 입력 때마다 max 변수와 비교하여
             * 입력 받은 나무가 max보다 클 경우 max 값을 해당 나무의 높이로 갱신해준다.
             */
            if (max < tree[i]) {
                max = tree[i];
            }
        }

        // 이분 탐색 (upper bound)
        while (min < max) {

            int mid = (min + max) / 2;
            long sum = 0;
            for (int treeHeight : tree) {

                /*
                 * tree의 잘린 길이 = tree의 높이 - 자르는 위치(mid)
                 * tree의 잘린 길의의 합을 구한다.
                 * 이 때 자르는 위치가 주어진 나무의 높이보다 클 수 있기 때문에
                 * 0 이하인 경우(=음수)에는 합산을 하지 않고 양수만 합산하도록 해야한다.
                 */
                if (treeHeight - mid > 0) {
                    sum += (treeHeight - mid);
                }
            }

            /*
             * 자른 나무 길의의 합이 M보다 작다는 것은
             * 자르는 위치(높이)가 높다는 의미이므로 높이를 낮춰야 한다.
             * 즉, 상한(max)를 줄여야 한다.
             */
            if (sum < M) {
                max = mid;
            }

            /*
             * 자른 나무 길이의 합이 M보다 크다는 것은
             * 자르는 위치(높이)가 낮다는 의미이므로 높이를 높여야 한다.
             * 또한, 같을 경우에는 최대한 적게 자르기 위해 자르는 높이를
             * 높여야 하므로 하한(min)을 올려야 한다.
             */
            else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);

    }
}
