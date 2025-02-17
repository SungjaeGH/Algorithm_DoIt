/*
 * 문제 링크 : https://www.acmicpc.net/problem/2018
 * */

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nArr = new int[N];

        for (int idx = 0; idx < N; idx++) {
            nArr[idx] = idx + 1;
        }

        int sum = 1;
        int count = 1;
        int startIdx = 0, endIdx = 0;
        boolean isEnd = false;

        while (!isEnd) {

            if (sum > N) {
                sum -= nArr[startIdx];
                startIdx++;

            } else {
                endIdx++;

                if (endIdx >= N) {
                    isEnd = true;
                    continue;
                }

                if (sum == N) {
                    count++;
                }

                sum += nArr[endIdx];
            }
        }

        System.out.println(count);
    }
}