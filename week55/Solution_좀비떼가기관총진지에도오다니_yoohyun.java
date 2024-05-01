import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int L = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        int ML = Integer.parseInt(st.nextToken());
        int MK = Integer.parseInt(st.nextToken());
        
        int C = Integer.parseInt(br.readLine());
        
        int[] zombie = new int[L + 1];
        
        boolean flag = true;
        int bomb = 0;
        for(int i = 1; i <= L; i++) {
        	if(i > ML) {
        		if(zombie[i - ML] > MK) {
        			bomb--;
        		}
        	}
        	zombie[i] = Integer.parseInt(br.readLine());
        	
        	int cnt = ML > i ? i - 1 : ML - 1;
        	zombie[i] -= MK * (cnt - bomb);
        	if(zombie[i] > MK) {
        		if(C > 0) {
        			C--;
        			bomb++;
        		} else {
        			flag = false;
        			break;
        		}
        	} 
        }
        
        System.out.print(flag ? "YES" : "NO");
    }
}
