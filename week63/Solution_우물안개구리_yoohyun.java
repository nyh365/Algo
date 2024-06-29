import java.io.*;
import java.util.*;

public class Main {
    static int[] member;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        member = new int[N + 1];
        LinkedList<Integer>[] edges = new LinkedList[N + 1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            member[i] = Integer.parseInt(st.nextToken());
            edges[i] = new LinkedList<>();
        }
        
        int from, to;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
        
            edges[from].add(to);
            edges[to].add(from);
        }
        System.out.print(getResult(edges, N));
    }
    public static int getResult(LinkedList<Integer>[] edges, int N){
        int result = 0;
        boolean flag = true;
        for(int i = 1; i <= N; i++){
            flag = true;
            for(int m : edges[i]){
                if(member[i] <= member[m]){
                    flag = false;
                } 
            }
            if(flag) {
                result++;
            }
        }
        return result;
    }
}
