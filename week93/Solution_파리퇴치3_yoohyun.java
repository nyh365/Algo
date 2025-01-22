import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 0; tc < t; tc++) {
            int res = Integer.MIN_VALUE;
            int n = sc.nextInt(), m = sc.nextInt();
            int[][] arr = new int[n][n];
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    arr[i][j] = sc.nextInt();
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    int sum1 = arr[i][j], sum2 = arr[i][j];
                    for(int x = 1; x <= m - 1; x++) {
                        if(i + x >= 0 && i + x < n)
                            sum1 += arr[i + x][j];
                        if(i - x >= 0 && i - x < n)
                            sum1 += arr[i - x][j];
                        if(j + x >= 0 && j + x < n)
                            sum1 += arr[i][j + x];
                        if(j - x >= 0 && j - x < n)
                            sum1 += arr[i][j - x];
                    }
                    for(int x = 1; x <= m - 1; x++) {
                        if(i + x >= 0 && j + x >= 0 && i + x < n && j + x < n)
                            sum2 += arr[i + x][j + x];
                        if(i + x >= 0 && j - x >= 0 && i + x < n && j - x < n)
                            sum2 += arr[i + x][j - x];
                        if(i - x >= 0 && j + x >= 0 && i - x < n && j + x < n)
                            sum2 += arr[i - x][j + x];
                        if(i - x >= 0 && j - x >= 0 && i - x < n && j - x < n)
                            sum2 += arr[i - x][j - x];
                    }
                    int max = (sum1 > sum2 ? sum1 : sum2); 
                    res = max > res ? max : res;
                }
            }
            System.out.println("#" + (tc + 1) + " " + res);
        }
        sc.close();
    }
}
