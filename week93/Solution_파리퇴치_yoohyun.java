import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), res = 0;
        for(int tc = 0; tc < t; tc++) {
            int n = sc.nextInt(), m = sc.nextInt();
            int[][] arr = new int[n][n];
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    arr[i][j] = sc.nextInt();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    int sum1 = 0;
                    for(int x = 0; x <= m - 1; x++) {
                      for(int y = 0; y <= m - 1; y++) {
                    	  if(i + x >= 0 && j + y >= 0 && i + x < n && j + y < n)
                              sum1 += arr[i + x][j + y];
                      }
                    }
                    max = Math.max(max, sum1);
                }
            }
            System.out.println("#" + (tc + 1) + " " + max);
        }
        sc.close();
    }
}
