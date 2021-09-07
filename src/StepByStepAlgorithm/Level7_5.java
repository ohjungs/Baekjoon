package StepByStepAlgorithm;

import java.util.Scanner;

public class Level7_5 {
	/*
	 * 1157번, 단어공부 문제 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을
	 * 작성하시오. 단, 대문자와 소문자를 구분하지 않는다. 입력 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는
	 * 1,000,000을 넘지 않는다. 출력 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된
	 * 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[26];
		String a = sc.next().toUpperCase();
		int max = -1;
		char st = '?';

		for (int i = 0; i < a.length(); i++) {
			arr[a.charAt(i) - 65]++;
			if (max < arr[a.charAt(i) - 65]) {
				max = arr[a.charAt(i) - 65];
				st = a.charAt(i);
			} else if (max == arr[a.charAt(i) - 65])
				st = '?';
		}
		System.out.println(st);
	}

}
/*
 * 대문자로 출력의 문제이기에 편리를 위해 입력값도 모두 대문자로 변환 -> String.toUpperCase(); 모두 대문자로 변경,
 * 소문자는 String.toLowerCase();
 * 
 * 알파벳 'A ~ Z'는 총 26개 -> int[] count = new int[26], 26크기의 배열 선언
 * 
 * 입력 문자열 길이만큼 반복문 실행 -> 입력 문자열 한 글자씩, 해당 알파벳 순서의 int배열 count 값 증가 -> 'A'일 경우
 * ex) 'A'-'A' => 65-65 => 0으로 count배열 0번째 값 증가
 * 
 * 알파벳 개수(배열크기)만큼 반복문 실행 -> 가장 중복값이 큰지 비교하며 max에 저장 -> 해당 위치 알파벳 알아내기 위해 (index
 * + 'A') ex) 1+'A' => 1+65 => 66, 66은 'B'에 해당
 */
