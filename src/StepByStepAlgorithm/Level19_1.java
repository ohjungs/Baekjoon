package StepByStepAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Level19_1 {
    // 18258 문제
    // 정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

    // 명령은 총 여섯 가지이다.

    // push X: 정수 X를 큐에 넣는 연산이다.
    // pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    // size: 큐에 들어있는 정수의 개수를 출력한다.
    // empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
    // front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    // back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    // 입력
    // 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 2,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
    // 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

    // 출력
    // 출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer command;

        while (N-- > 0) {
            command = new StringTokenizer(br.readLine(), " "); // 문자열 분리

            switch (command.nextToken()) {

                case "push":
                    // offer는 큐의 맨 뒤에 요소를 추가한다.
                    q.offer(Integer.parseInt(command.nextToken()));
                    break;

                case "pop":
                    /*
                     * poll은 가장 앞에 있는 요소를 삭제하며
                     * 삭제할 원소가 없을 경우 예외를 던지는 것이 아닌 null을 반환한다.
                     */
                    Integer item = q.poll();
                    if (item == null) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(item).append('\n');
                    }
                    break;

                case "size":
                    sb.append(q.size()).append('\n');
                    break;

                case "empty":
                    if (q.isEmpty()) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                    break;

                case "front":
                    // peek()은 큐에 꺼낼 요소가 없을 경우 null을 반환한다.
                    Integer ite = q.peek();
                    if (ite == null) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(ite).append('\n');
                    }
                    break;

                case "back":
                    // peekLast()은 큐에 꺼낼 요소가 없을 경우 null을 반환한다.
                    Integer it = q.peekLast();
                    if (it == null) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(it).append('\n');
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
