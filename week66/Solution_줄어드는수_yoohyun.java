import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
 
public class Main{
    static LinkedList<Long> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 9; i >= 0; i--) {
            solve((long) i, i - 1);
        }
        
        Collections.sort(list);
        if(list.size() < N) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(N - 1));
        }
    }
    public static void solve(long N, int cur) {
        list.add(N);

        if(cur == -1) {
            return;
        }
        
        for(int i = cur; i >= 0; i--) {
            solve(N * 10 + i, i - 1);
        }
    }    
}
