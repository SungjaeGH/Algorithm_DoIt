/*
* 문제 링크 : https://www.acmicpc.net/problem/11660
* */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] inputArr = input.split(" ");
        int N = Integer.parseInt(inputArr[0]);
        int M = Integer.parseInt(inputArr[1]);

        // 구간 합 2차원 배열 세팅하기
        int[][] sumArr = new int[N][N];
        for (int row = 0; row < N; row++) {

            String numsStr = br.readLine();
            StringTokenizer st = new StringTokenizer(numsStr, " ");

            for (int col = 0; col < N; col++) {

                int num = Integer.parseInt(st.nextToken());

                if (row == 0 && col == 0) {
                    sumArr[row][col] = num;

                } else if (col == 0) {
                    sumArr[row][col] = num + sumArr[row - 1][N - 1];

                } else {
                    sumArr[row][col] = num + sumArr[row][col - 1];

                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 구간 합 구하기
        for (int inputIdx = 0; inputIdx < M; inputIdx++) {

            String numsStr = br.readLine();
            String[] panelArr = numsStr.split(" ");

            int firstRow = Integer.parseInt(panelArr[0]) - 1;
            int firstCol = Integer.parseInt(panelArr[1]) - 1;
            int secondRow = Integer.parseInt(panelArr[2]) - 1;
            int secondCol = Integer.parseInt(panelArr[3]) - 1;

            long result = 0;

            for (int row = firstRow; row <= secondRow; row++) {

                if (firstCol - 1 < 0) {
                    if (row - 1 < 0) {
                        result += sumArr[row][secondCol];

                    } else {
                        result += sumArr[row][secondCol] - sumArr[row - 1][N - 1];

                    }

                } else {
                    result += sumArr[row][secondCol] - sumArr[row][firstCol - 1];

                }
            }

            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
    }
}