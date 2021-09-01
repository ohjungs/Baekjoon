package StepByStepAlgorithm;

import java.util.*;

public class Level5_2 {

	public static void main(String[] args) {
		/*
		 * 9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성하시오. 예를 들어,
		 * 서로 다른 9개의 자연수 3, 29, 38, 12, 57, 74, 40, 85, 61 이 주어지면, 이들 중 최댓값은 85이고, 이 값은
		 * 8번째 수이다. 입력 첫째 줄부터 아홉 번째 줄까지 한 줄에 하나의 자연수가 주어진다. 주어지는 자연수는 100 보다 작다. 출력 첫째
		 * 줄에 최댓값을 출력하고, 둘째 줄에 최댓값이 몇 번째 수인지를 출력한다.
		 */ 
		Scanner sc = new Scanner(System.in);
		int [] arr = new int[9];			// 정수 9개를 담을 배열 선언
		
		for(int i = 0 ; i < arr.length ; i ++)			// 배열에 9개의 수를 넣음
		{
			arr[i]=sc.nextInt();	
		}
		
		int max = arr[0];			// 기준이 될 첫번 째 값을 max에 넣음 
		int index = 0 ;			// 최대값의 위치를 알아낼 변수 생성
		
		for(int i = 1 ; i < arr.length ; i ++)
		{
			if(arr[i] > max) 			// max는 arr[0]이니까, max보다 큰 값이 있으면 그 값이 max가 됨.
			{							
				max = arr[i];
				index = i+1;			// max가 된 값의 위치를 index에 저장
			}
		}
		
		System.out.println(max);
		System.out.println(index);
		
	}
}

