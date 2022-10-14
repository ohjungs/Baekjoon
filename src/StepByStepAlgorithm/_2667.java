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
    static int arr[][];
    static boolean visit[][];
    static int dirX[] = { 0, 0, -1, 1 };
    static int dirY[] = { -1, 1, 0, 0 };

    static int count = 0, number = 0;
    static int nowX, nowY, N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < N; j++) {
                arr[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (visit[i][j] == false && arr[i][j] == 1) {
                    count = 0;
                    number++;
                    DFS(i, j);
                    list.add(count);
                }

            }
        }

        Collections.sort(list);
        bw.append(number + "\n");
        for (int num : list) {
            bw.append(num + "\n");
        }

        bw.flush();
        bw.close();
    } // End of main

    static void DFS(int x, int y) {
        visit[x][y] = true;
        arr[x][y] = number;
        count++;

        for (int i = 0; i < 4; i++) {
            nowX = dirX[i] + x;
            nowY = dirY[i] + y;

            if (Range_check() && visit[nowX][nowY] == false && arr[nowX][nowY] == 1) {
                visit[nowX][nowY] = true;
                arr[nowX][nowY] = number;

                DFS(nowX, nowY);
            }
        }

    } // End of DFS

    static boolean Range_check() {
        return (nowX >= 0 && nowX < N && nowY >= 0 && nowY < N);
    } // End of Range_check
} // End of class
