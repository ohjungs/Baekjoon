package StepByStepAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _2667 {
    // 문제
    // <그림 1>과 같이 정사각형 모양의 지도가 있다.
    // 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
    // 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
    // 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.
    // 대각선상에 집이 있는 경우는 연결된 것이 아니다.
    // <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다.
    // 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
    static int N; // 지도의 크기
    static int[][] Map; // 2차원 배열 지도
    static int count; // 단지집의 숫자
    static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
    static int[] dc = { 0, 0, -1, 1 }; // 상하좌우

    static ArrayList<Integer> result; // 단지 집의 수 저장 result.size()는 단지 수가 된다.

    static boolean[][] check; // 방문 체크

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 지도의 크기

        // 2차원 배열 지도
        Map = new int[N][N];

        // 방문 체크
        check = new boolean[N][N];

        // 지도 배열 값 입력
        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < N; j++) {
                Map[i][j] = input.charAt(j) - '0';
            }
        }

        // 단지집의 숫자
        count = 0;

        // 단지 집의 수 결과 저장
        result = new ArrayList<>();

        // 지도 전체 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 현재 위치의 값이 1이고 true라면
                if (Map[i][j] == 1 && !check[i][j]) {
                    // 맨 처음이기 때문에 count 1 증가
                    count = 1;
                    Search(i, j);
                    result.add(count);
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int c : result)
            System.out.println(c);
    }

    public static int Search(int x, int y) {
		check[x][y] = true;
		
		//4방향 확인
		for(int i=0;i<4;i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			
			if(nx>=0 && ny>=0 && nx<N && ny<N) {
				if(Map[nx][ny]==1 && !check[nx][ny]) {
					Search(nx,ny);
					count++;
				}
			}
		}
		
		return count;
	}
