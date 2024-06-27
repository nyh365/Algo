import java.io.*;
import java.util.*;

public class Main {
    static int[] foods, leftSum, rightSum, leftMax, rightMax;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        foods = new int[N];
        leftSum = new int[N];
        rightSum = new int[N];
        leftMax = new int[N];
        rightMax = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            foods[i] = Integer.parseInt(st.nextToken());
        }
        
        leftSum[0] = leftMax[0] = foods[0];
        rightSum[N - 1] = rightMax[N - 1] = foods[N - 1];
        for(int i = 1; i < N; i++){
            leftSum[i] = Math.max(foods[i], leftSum[i - 1] + foods[i]);
            leftMax[i] = Math.max(leftMax[i - 1], leftSum[i]);

            rightSum[N - i - 1] = Math.max(foods[N - i - 1], rightSum[N - i] + foods[N - i - 1]);
            rightMax[N - i - 1] = Math.max(rightMax[N - i], rightSum[N - i - 1]);
        }

        int result = Integer.MIN_VALUE;
        for(int i = 1; i < N - 1; i++){
            result = Math.max(result, leftMax[i - 1] + rightMax[i + 1]);
        }
        
        System.out.print(result);
    }
}
