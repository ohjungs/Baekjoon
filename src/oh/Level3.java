package oh;

import java.util.Scanner;

public class Level3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//		for(int i=1; i<10; i++){
//			System.out.println(n*i );
//			};
		int arr[] = new int[n];
		 
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[i] = a + b;
		}
		sc.close();
 
		for (int k : arr) {
			System.out.println(k);
		}
			
			
			
			
			
			
			
			
			
			
			
			
	}
}
