/*
* 문제 링크 : https://www.acmicpc.net/problem/1546
* */

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        sc.nextLine();

        String numStr = sc.nextLine();

        ArrayList<Integer> nums = new ArrayList<>();
        int maxNum = 0;

        StringTokenizer st = new StringTokenizer(numStr, " ");
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());

            if (maxNum < num) {
                maxNum = num;
            }

            nums.add(num);
        }

        double result = 0;
        for (int num : nums) {
            result += ((double) (num * 100) / maxNum);
        }

        System.out.println(result / input);
    }
}