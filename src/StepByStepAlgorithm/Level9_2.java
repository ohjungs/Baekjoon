package StepByStepAlgorithm;

import java.util.Scanner;

public class Level9_2 {
	/*
	 * 2581번 소수 문제 자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는
	 * 프로그램을 작성하시오.
	 * 
	 * 예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 소수는 61, 67, 71, 73, 79, 83, 89, 97 총
	 * 8개가 있으므로, 이들 소수의 합은 620이고, 최솟값은 61이 된다.
	 * 
	 * 입력 입력의 첫째 줄에 M이, 둘째 줄에 N이 주어진다.
	 * 
	 * M과 N은 10,000이하의 자연수이며, M은 N보다 작거나 같다.
	 * 
	 * 출력 M이상 N이하의 자연수 중 소수인 것을 모두 찾아 첫째 줄에 그 합을, 둘째 줄에 그 중 최솟값을 출력한다.
	 * 
	 * 단, M이상 N이하의 자연수 중 소수가 없을 경우는 첫째 줄에 -1을 출력한다.
	 */
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int m=sc.nextInt();
		int n = sc.nextInt();
		boolean arr[]= new boolean[n+1];
		arr[0] = true;
		arr[1] = true;
		for(int i=2; i<=Math.sqrt(n+1); i++) {
			for(int j=i*i; j<n+1; j+=i) {
				arr[j] =true;
			}
		}
		int min =Integer.MAX_VALUE;
		int sum = 0;
		for(int i=m; i<n+1; i++) {
			if(arr[i] == false) {
				if(min>i)
					min =i;
				sum += i;
			}
		}
		if(sum ==0)
			System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}}
