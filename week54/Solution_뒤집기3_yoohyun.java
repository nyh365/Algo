import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] alp = br.readLine().toCharArray();
        Deque<Character> deq = new LinkedList<>();
        
        char maxChar = alp[0];
        deq.add(alp[0]);
        
        for(int i = 1; i < alp.length; i++) {
        	if(maxChar >= alp[i]) {
        		deq.addFirst(alp[i]);
        		maxChar = alp[i];
        	} else {
        		deq.add(alp[i]);
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        while(!deq.isEmpty()) {
        	sb.append(deq.removeFirst());
        }
        
        System.out.print(sb);
    }
}
