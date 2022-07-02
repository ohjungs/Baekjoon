package StepByStepAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Level20_9 {
    // 6549 문제
    // 히스토그램은 직사각형 여러 개가 아래쪽으로 정렬되어 있는 도형이다. 각 직사각형은 같은 너비를 가지고 있지만, 높이는 서로 다를 수도
    // 있다. 예를 들어, 왼쪽 그림은 높이가 2, 1, 4, 5, 1, 3, 3이고 너비가 1인 직사각형으로 이루어진 히스토그램이다.

    // 히스토그램에서 가장 넓이가 큰 직사각형을 구하는 프로그램을 작성하시오.

    // 입력
    // 입력은 테스트 케이스 여러 개로 이루어져 있다. 각 테스트 케이스는 한 줄로 이루어져 있고, 직사각형의 수 n이 가장 처음으로 주어진다.
    // (1 ≤ n ≤ 100,000) 그 다음 n개의 정수 h1, ..., hn (0 ≤ hi ≤ 1,000,000,000)가 주어진다. 이
    // 숫자들은 히스토그램에 있는 직사각형의 높이이며, 왼쪽부터 오른쪽까지 순서대로 주어진다. 모든 직사각형의 너비는 1이고, 입력의 마지막
    // 줄에는 0이 하나 주어진다.

    // 출력
    // 각 테스트 케이스에 대해서, 히스토그램에서 가장 넓이가 큰 직사각형의 넓이를 출력한다.
    public static int[] histogram;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int N;
        while (true) {

            st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());

            if (N == 0) {
                break;
            }
            histogram = new int[N];

            for (int i = 0; i < N; i++) {
                histogram[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(getArea(0, N - 1)).append('\n');
            histogram = null;

        }
        System.out.println(sb);
    }

    public static long getArea(int lo, int hi) {

        // 막대 폭이 1일경우
        if (lo == hi) {
            return histogram[lo];
        }

        // [1번 과정]
        int mid = (lo + hi) / 2; // 중간지점

        /*
         * [2번 과정]
         * mid를 기점으로 양쪽으로 나누어 양쪽 구간 중 큰 넓이를 저장
         * 왼쪽 부분 : lo ~ mid
         * 오른쪽 부분 : mid + 1 ~ hi
         */
        long leftArea = getArea(lo, mid);
        long rightArea = getArea(mid + 1, hi);

        // [3번 과정]
        long max = Math.max(leftArea, rightArea);

        // 양쪽 구간 중 큰 값과 중간 구간을 비교하여 더 큰 넓이로 갱신
        max = Math.max(max, getMidArea(lo, hi, mid));

        return max;

    }

    // 중간지점 영역의 넓이를 구하는 메소드
    public static long getMidArea(int lo, int hi, int mid) {

        int toLeft = mid; // 중간 지점으로부터 왼쪽으로 갈 변수
        int toRight = mid; // 중간 지점으로부터 오른쪽으로 갈 변수

        long height = histogram[mid]; // 높이

        // [초기 넓이 (구간 폭이 1이므로 넓이는 높이가 면적이 됨)
        long maxArea = height;

        // 양 끝 범위를 벗어나기 전까지 반복
        while (lo < toLeft && toRight < hi) {

            /*
             * 양쪽 다음칸의 높이 중 높은 값을 선택하되,
             * 갱신되는 height는 기존 height보다 작거나 같아야 한다.
             */
            if (histogram[toLeft - 1] < histogram[toRight + 1]) {
                toRight++;
                height = Math.min(height, histogram[toRight]);
            } else {
                toLeft--;
                height = Math.min(height, histogram[toLeft]);
            }

            // 최대 넓이 갱신
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        // 오른쪽 구간을 끝까지 탐색 못했다면 마저 탐색한다.
        while (toRight < hi) {
            toRight++;
            height = Math.min(height, histogram[toRight]);
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        // 왼쪽 구간을 끝까지 탐색 못했다면 마저 탐색한다.
        while (lo < toLeft) {
            toLeft--;
            height = Math.min(height, histogram[toLeft]);
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        return maxArea;
    }
}
