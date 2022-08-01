package StepByStepAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Level22_7 {
    // 12015 문제
    // 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.

    // 예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20,
    // 10, 30, 20, 50} 이고, 길이는 4이다.

    // 입력
    // 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다.

    // 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000,000)

    // 출력
    // 첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] seq = new int[N];
        int[] LIS = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        // LIS 초기 값으로 첫 번째 수열의 값을 갖는다.
        LIS[0] = seq[0];
        int lengthOfLIS = 1;

        for (int i = 1; i < N; i++) {

            int key = seq[i];

            // 만약 key가 LIS의 마지막 값보다 클 경우 추가해준다.
            if (LIS[lengthOfLIS - 1] < key) {
                lengthOfLIS++;
                LIS[lengthOfLIS - 1] = key;
            } else {
                // Lower Bound 이분탐색을 진행한다.
                int lo = 0;
                int hi = lengthOfLIS;
                while (lo < hi) {
                    int mid = (lo + hi) >>> 1;

                    if (LIS[mid] < key) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }

                }
                /*
                 * lo가 LIS에서 대치 될 원소의 위치가 될 것이고
                 * 해당 위치에 key값으로 원소를 바꿔준다.
                 */

                LIS[lo] = key;

            }

        }
        // 위 과정을 통해 나온 LIS의 길이를 출력한다.
        System.out.println(lengthOfLIS);
    }
}
