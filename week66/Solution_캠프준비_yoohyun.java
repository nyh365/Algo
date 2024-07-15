import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Main{
    static int N, L, R, X, result;
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        solve(0,0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        
        System.out.println(result);
    }
    public static void solve(int curIndex, int total, int min, int max, int cnt) {
        if(cnt > 1) {
            result += possible(total, min, max) ? 1 : 0;
        }
        
        for(int i = curIndex; i < N; i++) {
            solve(i + 1, total + A[i], Math.min(min, A[i]), Math.max(max, A[i]), cnt + 1);
        }
    }    
    public static boolean possible(int total, int min, int max) {
        if(max - min < X) return false;
        if(total < L || total > R) return false;
        return true;
    }
}
