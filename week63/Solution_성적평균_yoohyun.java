import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] students = new int[N + 1];
        long[] sum = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            students[i] = Integer.parseInt(st.nextToken());
            sum[i] += sum[i-1] + students[i];
        }

        int start, end;
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            sb.append(String.format("%.2f", ((double) (sum[end] - sum[start - 1])) / (end - start + 1))).append("\n");
        }
        System.out.print(sb);
    }
}
