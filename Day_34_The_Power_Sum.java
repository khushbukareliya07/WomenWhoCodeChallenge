import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    static Set<Integer> visited;
    static int target, power, count;

    public static int powerSum(int X, int N) {
        // Write your code here
        visited = new HashSet<>();
        target = X;
        power = N;
        count = 0;

        dfs(1, 0); // number, curr sum
        return count;
    }

    private static void dfs(int number, int currSum) {
        // base casee, aiming target
        if (currSum == target) {
            System.out.println("Answer : " + number);
            System.out.println("CurrSum :  : " + currSum);
            count++;
            return;
        }

        if (currSum > target) {
            return;
        }

        for (int i = number; (int) Math.pow(i, power) < target; i++) {
            // logic
            currSum += (int) Math.pow(number, power);

            dfs(i + 1, currSum);

            // backtracking - subtraction
            System.out.println("****** back  Before sum: " + currSum);
            currSum = currSum - (int) Math.pow(number, power);
            System.out.print("Safter backtrack sum : " + currSum + " Number subtracted: " + number);
        }

    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int X = Integer.parseInt(bufferedReader.readLine().trim());

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.powerSum(X, N);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
