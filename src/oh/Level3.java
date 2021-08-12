package oh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Level3 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//		for(int i=1; i<10; i++){
//			System.out.println(n*i );
//			};
		// 
//		int arr[] = new int[n];
//		 
//		for (int i = 0; i < n; i++) {
//			int a = sc.nextInt();
//			int b = sc.nextInt();
//			arr[i] = a + b;
//		}
//		sc.close();
// 
//		for (int k : arr) {
//			System.out.println(k);
//		}
		
		//n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.
//		int sum=0;
//		for (int i = 1; i <= n; i++) {
//			sum += i;
//		}
//		System.out.println(sum);
			
		/*
		 * Scanner와 System.out.println 대신 BufferedReader와 BufferedWriter를 사용할 수 있다.
		 * BufferedWriter.flush는 맨 마지막에 한 번만 하면 된다.
		 * 각 테스트케이스마다 A+B를 한 줄에 하나씩 순서대로 출력한다. -> 스캐너를 쓰지말고 ..!
		 * 	int N = Integer.parseInt(br.readLine());
        
		StringTokenizer st;
 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			bw.write((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()))+ "\n");
		}
		br.close();
        
		bw.flush();
		bw.close();
		 */
			
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		StringBuilder sb = new StringBuilder();
// 
//		for (int i = 0; i < N; i++) {		
//			String str = br.readLine();
//			int target = str.indexOf(" ");
//			int result = Integer.parseInt(str.substring(0,target)) + Integer.parseInt(str.substring(target + 1));		
//			sb.append(result+"\n");
//		}
//		
//		br.close();
//		System.out.print(sb);
//		자연수 N이 주어졌을 때, 1부터 N까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오.
//		입력
//		첫째 줄에 100,000보다 작거나 같은 자연수 N이 주어진다.
//		출력
//		첫째 줄부터 N번째 줄 까지 차례대로 출력한다.
	for(int i=1; i<=n; i++) {
		System.out.println(i);
	}
	
	}
}
