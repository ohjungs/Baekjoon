package StepByStepAlgorithm;

import java.util.Scanner;

public class Level7_6 {
public static void main(String[] args) {
	/*
	 * 1152번 단어의 개수 문제 영어 대소문자와 띄어쓰기만으로 이루어진 문자열이 주어진다. 이 문자열에는 몇 개의 단어가 있을까? 이를 구하는
	 * 프로그램을 작성하시오. 단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다. 입력 첫 줄에 영어 대소문자와 띄어쓰기로
	 * 이루어진 문자열이 주어진다. 이 문자열의 길이는 1,000,000을 넘지 않는다. 단어는 띄어쓰기 한 개로 구분되며, 공백이 연속해서
	 * 나오는 경우는 없다. 또한 문자열의 앞과 뒤에는 공백이 있을 수도 있다. 출력 첫째 줄에 단어의 개수를 출력한다.
	 */
	Scanner sc = new Scanner(System.in);
	String input = sc.nextLine().trim();
	sc.close();
	
	if (input.isEmpty()) {
		System.out.println(0);
	} else {
		System.out.println(input.split(" ").length);
	}
}
}
//String 클래스의 split(구분자) 메서드를 사용했습니다.
//split 메서드는 해당 문자열에 [구분자]가 있는 부분을 경계로 문자열을 잘라
//문자열 배열로 변환해줍니다.
//예를 들어, "aaabcccbd" 라는 문자열이 있을 때, 아래와 같이 작성하면
//String arr[] = "aaabcccbd".split("b");
//문자열 "b" 를 기준으로 분리가 되어,
//String arr[] = { "aaa", "ccc", "d" }; 와 같은 배열이 생성됩니다.
//그래서 이 문제는 공백을 구분자( split(" ") )로 단어로 나눈 뒤,
//이 배열의 길이를 출력하면 간단하게 해결이 됩니다.
//앞 뒤에 공백이 껴있는 경우를 처리하기 위해
//trim() 메서드(해당 문자열의 앞 뒤 공백 제거)를 사용했고, 
//입력값이 아예 없는 경우를 처리하기 위해
//isEmpty() 메서드(해당 문자열의 길이가 0 인지 확인)를 사용했습니다.
