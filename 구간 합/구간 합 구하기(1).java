/*
* 문제 링크 : https://www.acmicpc.net/problem/11659
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

        String numsStr = br.readLine();
        int[] sumArr = new int[N + 1];

        // 구간 합 배열 구현
        StringTokenizer st = new StringTokenizer(numsStr, " ");
        for (int idx = 1; idx <= N; idx++) {

            int num = Integer.parseInt(st.nextToken());
            sumArr[idx] = sumArr[idx - 1] + num;
        }

        // 구간 합 구하기
        for (int inputIdx = 0; inputIdx < M; inputIdx++) {

            String panel = br.readLine();
            String[] panelArr = panel.split(" ");
            int start = Integer.parseInt(panelArr[0]);
            int end = Integer.parseInt(panelArr[1]);

            System.out.println(sumArr[end] - sumArr[start - 1]);
        }
    }
}