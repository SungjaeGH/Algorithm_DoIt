/*
 * 문제 링크 : https://www.acmicpc.net/problem/10986
 * */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // TODO: 시간 초과 코드 <- 해결 필요

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] inputSplits = input.split(" ");

        int N = Integer.parseInt(inputSplits[0]);
        int M = Integer.parseInt(inputSplits[1]);

        StringTokenizer inputSt = new StringTokenizer(br.readLine(), " ");
        int[] sumArr = new int[N + 1];
        int numCount = 1;

        // 구간 합 배열 채우기
        while (inputSt.hasMoreTokens()) {

            int num = Integer.parseInt(inputSt.nextToken());
            sumArr[numCount] = num + sumArr[numCount - 1];

            numCount++;
        }

        int result = 0;

        // 구간별로 나누어 떨어지는 구간 구하기
        for (int idx = 1; idx <= N; idx++) {
            result += findModZeroCount(idx, M, sumArr);
        }

        System.out.println(result);
    }

    private static int findModZeroCount(int section, int M, int[] sumArr) {

        int count = 0;

        for (int startIdx = 0; startIdx < sumArr.length - section; startIdx++) {

            if ((sumArr[startIdx + section] - sumArr[startIdx]) % M == 0) {
                count++;
            }
        }

        return count;
    }
}

/*
* 0, 1, 3, 6, 7, 9
* 7개

* 1 - 1, 2, 3, 1, 2 -> 1
* 2 - 3, 5, 4, 3 -> 2
* 3 - 6, 6, 6 -> 3
* 4 - 7, 8 -> 0
* 5 - 9 -> 1
*
* => 7개
* */