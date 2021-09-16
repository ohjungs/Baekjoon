package StepByStepAlgorithm;

import java.io.IOException;
import java.util.Scanner;

public class Level7_10 {
	/*
	 * 문제 1613번 그룹 단어 체커 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 예를
	 * 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹
	 * 단어이지만, aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다. 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는
	 * 프로그램을 작성하시오. 입력 첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에
	 * 단어가 들어온다. 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다. 출력 첫째 줄에 그룹 단어의 개수를 출력한다
	 */
	public static void main(String[] args) {
		/*
		 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); int
		 * n = Integer.parseInt(br.readLine()); int result = n; StringTokenizer st;
		 * for(int i=0; i<n; i++) { st = new StringTokenizer(br.readLine()); String s =
		 * st.nextToken(); int cnt=0; for(char c='a'; c<='z'; c++) { int first =
		 * s.indexOf(c); int last = s.lastIndexOf(c); if(first!=last) { for(int
		 * j=first+1; j<last; j++) { if(s.charAt(j)!=c) { cnt++; break; } } } }
		 * if(cnt!=0) { result--; } } System.out.println(result); }
		 */
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int cnt = a;
		for (int i = 0; i < a; i++) {
			String word = sc.next();
			for (int j = 1; j < word.length(); j++) {
				if (word.indexOf(word.charAt(j - 1)) > word.indexOf(word.charAt(j))) {
					cnt--;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}
// 다시풀기 안풀림..
