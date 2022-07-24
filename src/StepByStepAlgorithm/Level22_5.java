package StepByStepAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Level22_5 {
    // 2110 문제
    // 도현이의 집 N개가 수직선 위에 있다. 각각의 집의 좌표는 x1, ..., xN이고, 집 여러개가 같은 좌표를 가지는 일은 없다.

    // 도현이는 언제 어디서나 와이파이를 즐기기 위해서 집에 공유기 C개를 설치하려고 한다. 최대한 많은 곳에서 와이파이를 사용하려고 하기
    // 때문에, 한 집에는 공유기를 하나만 설치할 수 있고, 가장 인접한 두 공유기 사이의 거리를 가능한 크게 하여 설치하려고 한다.

    // C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램을 작성하시오.

    // 입력
    // 첫째 줄에 집의 개수 N (2 ≤ N ≤ 200,000)과 공유기의 개수 C (2 ≤ C ≤ N)이 하나 이상의 빈 칸을 사이에 두고
    // 주어진다. 둘째 줄부터 N개의 줄에는 집의 좌표를 나타내는 xi (0 ≤ xi ≤ 1,000,000,000)가 한 줄에 하나씩 주어진다.

    // 출력
    // 첫째 줄에 가장 인접한 두 공유기 사이의 최대 거리를 출력한다
    public static int[] house;

    /**
     * @param args
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        house = new int[N];

        for (int i = 0; i < N; i++) {
            house[i] = in.nextInt();
        }

        Arrays.sort(house); // 이분탐색을 하기 위해선 반드시 정렬 되어있어야 한다.

        int lo = 1; // 최소 거리가 가질 수 있는 최솟값
        int hi = house[N - 1] - house[0] + 1; // 최소 거리가 가질 수 있는 최댓값

        while (lo < hi) { // Upper Bound 형식

            int mid = (hi + lo) / 2;

            /*
             * mid 거리에 대해 설치 가능한 공유기 개수가 M 개수에 못미치면
             * 거리를 좁혀야 하기 때문에 hi 를 줄인다.
             */
            if (canInstall(mid) < M) {
                hi = mid;
            } else {
                /**
                 * 설치 가능한 공유기 개수가 M 개수보다 크거나 같으면
                 * 거리를 벌리면서 최소거리가 가질 수 있는 최대 거리를
                 * 찾아낸다.
                 */
                lo = mid + 1;
            }
        }

        /*
         * Upper Bound는 탐색 값을 초과하는 첫 번째 값을 가리키므로,
         * 1을 빼준 값이 조건식을 만족하는 최댓값이 된다.
         */
        System.out.println(lo - 1);
    }

    // distance에 대해 설치 가능한 공유기 개수를 찾는 메소드
    public static int canInstall(int distance) {

        // 첫 번째 집은 무조건 설치한다고 가정
        int count = 1;
        int lastLocate = house[0];

        for (int i = 1; i < house.length; i++) {
            int locate = house[i];

            /*
             * 현재 탐색하는 집의 위치와 직전에 설치했던 집의 위치간 거리가
             * 최소 거리(distance)보다 크거나 같을 때 공유기 설치 개수를 늘려주고
             * 마지막 설치 위치를 갱신해준다.
             */
            if (locate - lastLocate >= distance) {
                count++;
                lastLocate = locate;
            }
        }
        return count;

    }

}
