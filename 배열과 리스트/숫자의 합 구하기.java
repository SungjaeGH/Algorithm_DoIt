/*
* 문제 링크 : https://www.acmicpc.net/problem/11720
* */
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();
        String nums = sc.next();

        int result = 0;

        String[] splitNums = nums.split("");
        for (int idx = 0; idx < input; idx++) {
            result += Integer.parseInt(splitNums[idx]);
        }

        System.out.println(result);
    }
}

/*
* [다른 코드]
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int inputCount = Integer.parseInt(bufferedReader.readLine());
        String inputNum = bufferedReader.readLine();

        int result = 0;
        for (int idx = 0; idx < inputCount; idx++) {
            int num = inputNum.charAt(idx) - '0';
            result += num;
        }

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.flush();
    }
}

* */