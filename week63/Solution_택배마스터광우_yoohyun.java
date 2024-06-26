import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, total, result = Integer.MAX_VALUE;
    static int[] order;
    static int[] rail;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        order = new int[N];
        rail = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            rail[i] = Integer.parseInt(st.nextToken());
        }
        
        permutation(0,0);
        
        System.out.print(result);
    }
    public static void permutation(int cnt, int visited){
        if(cnt == N){
            result = Math.min(result, getResult());
            return;
        }

        for(int i = 0; i < N; i++){
            if(((1 << i) & visited) > 0) continue;

            order[cnt] = i; 
            permutation(cnt + 1, visited | (1 << i));
        }
    }
    public static int getResult(){
        int sum = 0;
        int index = 0;

        for(int i = 0; i < K; i++){
            int temp = 0;
            while(temp + rail[order[index]]<= M){
                temp += rail[order[index++]];
                index %= N;
            }
            sum += temp;
        }
        return sum;
    }
}
