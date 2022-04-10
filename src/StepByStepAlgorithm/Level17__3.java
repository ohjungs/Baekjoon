package StepByStepAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Level17__3 {
    // 9012번 문제
    // 괄호 문자열(Parenthesis String, PS)은 두 개의 괄호 기호인 ‘(’ 와 ‘)’ 만으로 구성되어 있는 문자열이다. 그
    // 중에서 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다. 한 쌍의 괄호 기호로 된 “(
    // )” 문자열은 기본 VPS 이라고 부른다. 만일 x 가 VPS 라면 이것을 하나의 괄호에 넣은 새로운 문자열 “(x)”도 VPS 가 된다.
    // 그리고 두 VPS x 와 y를 접합(concatenation)시킨 새로운 문자열 xy도 VPS 가 된다. 예를 들어 “(())()”와
    // “((()))” 는 VPS 이지만 “(()(”, “(())()))” , 그리고 “(()” 는 모두 VPS 가 아닌 문자열이다.

    // 여러분은 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다.

    // 입력
    // 입력 데이터는 표준 입력을 사용한다. 입력은 T개의 테스트 데이터로 주어진다. 입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수
    // T가 주어진다. 각 테스트 데이터의 첫째 줄에는 괄호 문자열이 한 줄에 주어진다. 하나의 괄호 문자열의 길이는 2 이상 50 이하이다.

    // 출력
    // 출력은 표준 출력을 사용한다. 만일 입력 괄호 문자열이 올바른 괄호 문자열(VPS)이면 “YES”, 아니면 “NO”를 한 줄에 하나씩
    // 차례대로 출력해야 한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            sb.append(solve(br.readLine())).append('\n');
        }
        System.out.println(sb);

    }

    public static String solve(String s) {

        int count = 0;

        for (char c : s.toCharArray()) {

            // 여는 괄호일 경우 카운트 증가
            if (c == '(') {
                count++;
            }

            // 아래는 모두 닫는 괄호 일 경우들이다.

            // count 가 0인 경우. 즉, 닫는 괄호를 입력받았으나 pop할 원소가 없을 경우
            else if (count == 0) {
                return "NO";
            }
            // 그 외의 경우 count를 감소시킨다.
            else {
                count--;
            }
        }

        /*
         * 모든 검사 마치고 잔여 요소가 있으면(count > 0) 여는 괄호가 많은 경우는 "NO"
         * 요소가 비어있으면(count = 0) 온전한 수식이므로 "YES" 이다.
         */

        if (count == 0) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
