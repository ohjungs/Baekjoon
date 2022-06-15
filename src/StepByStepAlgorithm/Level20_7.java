package StepByStepAlgorithm;

import java.util.Scanner;

public class Level20_7 {
    // 10830번 행렬 제곱 문제
    // 크기가 N*N인 행렬 A가 주어진다. 이때, A의 B제곱을 구하는 프로그램을 작성하시오. 수가 매우 커질 수 있으니, A^B의 각 원소를
    // 1,000으로 나눈 나머지를 출력한다.

    // 입력
    // 첫째 줄에 행렬의 크기 N과 B가 주어진다. (2 ≤ N ≤ 5, 1 ≤ B ≤ 100,000,000,000)

    // 둘째 줄부터 N개의 줄에 행렬의 각 원소가 주어진다. 행렬의 각 원소는 1,000보다 작거나 같은 자연수 또는 0이다.

    // 출력
    // 첫째 줄부터 N개의 줄에 걸쳐 행렬 A를 B제곱한 결과를 출력한다.
    final static int MOD = 1000;
    public static int N;
    public static int[][] origin; // A^1 일 때의 배열(초기 배열)

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        long B = in.nextLong(); // 타입 주의

        origin = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                /*
                 * B=1 일 때는 pow과정에서 바로 A가 반환 될 수 있다.
                 * 이 때의 경우 만약 원소가 1000이상일 경우 pow메소드에서 모듈러연산이
                 * 실행되지 않기 때문에 오답이 되어버린다.
                 * 
                 * 이를 방지하기 위해 초기 행렬에도 1000으로 나눈 나머지 값으로
                 * 초기화를 해준다.
                 */
                origin[i][j] = in.nextInt() % MOD;
            }
        }

        int[][] result = pow(origin, B);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);

    }

    // 행렬 제곱 분할정복 메소드
    public static int[][] pow(int[][] A, long exp) {

        // 지수가 1일 땐 A를 return한다.
        if (exp == 1L) {
            return A;
        }

        // 지수를 절반으로 분할하여 재귀호출
        int[][] ret = pow(A, exp / 2);

        // 하위 재귀에서 얻은 행렬을 제곱해준다.
        ret = multiply(ret, ret);

        // 만약 지수가 홀수라면 마지막에 A^1 (origin)을 곱해준다.
        if (exp % 2 == 1L) {
            ret = multiply(ret, origin);
        }

        return ret;
    }

    // o1과 o2 행렬을 곱해주는 메소드
    public static int[][] multiply(int[][] o1, int[][] o2) {

        int[][] ret = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {

                    ret[i][j] += o1[i][k] * o2[k][j];
                    ret[i][j] %= MOD; // 행렬 원소 연산이 끝나면 MOD로 나머지연산
                }
            }
        }
        return ret;
    }
}
