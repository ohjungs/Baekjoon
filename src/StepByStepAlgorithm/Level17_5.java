package StepByStepAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Level17_5 {
    // 2981 검문 문제
    // 트럭을 타고 이동하던 상근이는 경찰의 검문을 받게 되었다. 경찰은 상근이가 운반하던 화물을 하나하나 모두 확인할 것이기 때문에, 검문하는데
    // 엄청나게 오랜 시간이 걸린다.

    // 상근이는 시간을 때우기 위해서 수학 게임을 하기로 했다.

    // 먼저 근처에 보이는 숫자 N개를 종이에 적는다. 그 다음, 종이에 적은 수를 M으로 나누었을 때, 나머지가 모두 같게 되는 M을 모두
    // 찾으려고 한다. M은 1보다 커야 한다.

    // N개의 수가 주어졌을 때, 가능한 M을 모두 찾는 프로그램을 작성하시오.

    // 입력
    // 첫째 줄에 종이에 적은 수의 개수 N이 주어진다. (2 ≤ N ≤ 100)

    // 다음 줄부터 N개 줄에는 종이에 적은 수가 하나씩 주어진다. 이 수는 모두 1보다 크거나 같고, 1,000,000,000보다 작거나 같은
    // 자연수이다. 같은 수가 두 번 이상 주어지지 않는다.

    // 항상 M이 하나 이상 존재하는 경우만 입력으로 주어진다.

    // 출력
    // 첫째 줄에 가능한 M을 공백으로 구분하여 모두 출력한다. 이때, M은 증가하는 순서이어야 한다.
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr); // 정렬

        int gcdVal = arr[1] - arr[0]; // 음수가 되지 않도록 큰 수에서 작은 수로 빼준다.

        for (int i = 2; i < N; i++) {
            // 직전의 최대 공약수와 다음 수(arr[i] - arr[i - 1])의 최대공약수를 갱신
            gcdVal = gcd(gcdVal, arr[i] - arr[i - 1]);
        }

        // 최대공약수의 약수들 찾기
        for (int i = 2; i <= gcdVal; i++) {

            // i가 최대공약수의 약수라면 출력
            if (gcdVal % i == 0) {
                System.out.print(i + " ");
            }
        }

    }

    // 최대공약수 함수
    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

}
