import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        char[][] input = new char[N][];
        for(int i = 0; i < N; i++) {
            input[i] = br.readLine().toCharArray();
        }
        
        System.out.println(findWidth(input, N) + " " + findHeight(input, N));
    }
    public static int findHeight(char[][] input, int N) {
        int cnt = 0;    
            
        int flag;
        for(int i = 0; i < N; i++) {
            flag = 0;
            for(int j = 0; j < N; j++) {
                if(input[j][i] == 'X') {
                    if(flag > 1) cnt++;
                    flag = 0;
                    continue;
                }
                flag++;
            }
            if(flag > 1) cnt++;
        }
        
        return cnt;
    }
    
    public static int findWidth(char[][] input, int N) {
        int cnt = 0;
        
        int flag;
        for(int i = 0; i < N; i++) {
            flag = 0;
            for(int j = 0; j < N; j++) {
                if(input[i][j] == 'X') {
                    if(flag > 1) cnt++;
                    flag = 0;
                    continue;
                }
                flag++;
            }
            if(flag > 1) cnt++;
        }
        
        return cnt;
    }
}
