import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Main{
    static char[] alps, result, dupli;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int len;
        for(int i = 0; i < N; i++) {
            alps = br.readLine().toCharArray();
            len = alps.length;
            
            result = new char[len];
            dupli = new char[len];
            visited = new boolean[len];
            
            Arrays.fill(visited, false);
            Arrays.sort(alps);
            
            solve(len, 0);
        }
    }
    public static void solve(int length, int curIdx) {
        if(curIdx == length) {
            System.out.println(result);
            return;
        }
        
        dupli[curIdx] = 'A';
        for(int i = 0; i < length; i++) {
            if(visited[i]) continue;
            if(dupli[curIdx] >= alps[i]) continue;
            
            visited[i] = true;
            dupli[curIdx] = alps[i];
            result[curIdx] = alps[i];
            solve(length, curIdx + 1);
            visited[i] = false;
        }
    }    
}
