package StepByStepAlgorithm;

import java.util.Scanner;

public class Level16_4 {
//    1541 문제 잃어버린 괄호
// 세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.

// 그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.

// 괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다. 그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다. 수는 0으로 시작할 수 있다. 입력으로 주어지는 식의 길이는 50보다 작거나 같다.

// 출력
// 첫째 줄에 정답을 출력한다.

public static void main(String[] args) {
 
    Scanner in = new Scanner(System.in);

    int sum = Integer.MAX_VALUE;	// 초기 상태 여부 확인을 위한 값으로 설정 
    String[] subtraction = in.nextLine().split("-");
    

    for(int i = 0; i < subtraction.length; i++) {
        int temp = 0;

        // 뺄셈으로 나뉜 토큰을 덧셈으로 분리하여 해당 토큰들을 더한다.
        String[] addition = subtraction[i].split("\\+");
        
        // 덧셈으로 나뉜 토큰들을 모두 더한다. 
        for(int j = 0; j < addition.length; j++) {
            temp += Integer.parseInt(addition[j]);
        }
        
        // 첫 번째토큰인 경우 temp값이 첫 번째 수가 됨
        if (sum == Integer.MAX_VALUE) {
            sum = temp;
        } else {
            sum -= temp;
        }
    }
    System.out.println(sum);
}
}
