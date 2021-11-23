package StepByStepAlgorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Level12_10 {
	/*
	 * 18870 좌표 압축 문제 수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.
	 * 
	 * Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수와 같아야 한다.
	 * 
	 * X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.
	 * 
	 * 입력 첫째 줄에 N이 주어진다.
	 * 
	 * 둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.
	 * 
	 * 출력 첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.
	 * 
	 * 제한 1 ≤ N ≤ 1,000,000 -109 ≤ Xi ≤ 109
	 */
	public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);
	        int N = sc.nextInt();
	        int[] arr = new int[N];
	        int[] arrClone;
	        Map<Integer, Integer> map = new HashMap<>();
	        int count = 0;
	        StringBuilder sb = new StringBuilder();

	        for (int i = 0; i < arr.length; i++) {
	            arr[i] = sc.nextInt();
	        }

	        arrClone = arr.clone();

	        Arrays.sort(arrClone);

	        for (int i = 0; i < arrClone.length; i++) {
	            if (!map.containsKey(arrClone[i])) {
	                map.put(arrClone[i], count++);
	            }
	        }

	        for (int i = 0; i < arr.length; i++) {
	            sb.append(map.get(arr[i])).append(" ");
	        }
	        
	        System.out.println(sb);
	}
}
