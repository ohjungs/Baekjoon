package StepByStepAlgorithm;

import java.util.Scanner;
import java.util.Stack;

public class Level18_6 {
    // 17298 문제
    // 크기가 N인 수열 A = A1, A2, ..., AN이 있다. 수열의 각 원소 Ai에 대해서 오큰수 NGE(i)를 구하려고 한다. Ai의
    // 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다. 그러한 수가 없는 경우에 오큰수는 -1이다.

    // 예를 들어, A = [3, 5, 2, 7]인 경우 NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) =
    // -1이다. A = [9, 5, 4, 8]인 경우에는 NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) =
    // -1이다.

    // 입력
    // 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에 수열 A의 원소 A1, A2, ..., AN (1
    // ≤ Ai ≤ 1,000,000)이 주어진다.

    // 출력
    // 총 N개의 수 NGE(1), NGE(2), ..., NGE(N)을 공백으로 구분해 출력한다.
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] seq = new int[N];
        int[] stack = new int[N]; // 스택처럼 쓸 배열
        int top = -1; // 스택의 맨 위 원소를 가리키는 변수

        for (int i = 0; i < N; i++) {
            seq[i] = in.nextInt();
        }

        for (int i = 0; i < N; i++) {
            /*
             * 스택이 비어있지 않으면서 (= top 이 -1이 아닐 경우)
             * 현재 원소가 스택의 맨 위 원소가 가리키는 원소보다 큰 경우
             * 해당 조건을 만족할 때 까지 stack의 원소를 pop하면서
             * 해당 인덱스의 값을 현재 원소로 바꿔준다.
             */
            while (top != -1 && seq[stack[top]] < seq[i]) {
                seq[stack[top]] = seq[i];
                top--;
            }
            top++;
            stack[top] = i;
        }

        /*
         * 스택의 모든 원소를 pop하면서 해당 인덱스의 value를
         * -1로 초기화한다.
         */
        for (int i = top; i >= 0; i--) {
            seq[stack[i]] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int v : seq) {
            sb.append(v).append(' ');
        }

        System.out.println(sb);
    }
}
