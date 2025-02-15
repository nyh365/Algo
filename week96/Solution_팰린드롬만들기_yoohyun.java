import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        char[] input = br.readLine().toCharArray();
        int len = input.length;
        int[] cntOfAlp = new int[26];
        
        for(int i = 0; i < len; i++) {
        	cntOfAlp[input[i] - 'A']++;
        }
        
        Queue<Character> front = new LinkedList<>();
        Stack<Character> back = new Stack<>();
        
        int index = -1;
        for(int i = 0; i < 26; i++) {
        	if(cntOfAlp[i] == 0) continue;
        	
        	if(cntOfAlp[i] % 2 != 0) {
        		if(index != -1) {
        			System.out.print("I'm Sorry Hansoo");
        			return;
        		} else {
        			for(int j = 0; j < cntOfAlp[i] / 2; j++) {
            			front.add((char) ('A' + i));
            			back.add((char) ('A' + i));
            		}
        			index = i;
        		}
        	} else {
        		for(int j = 0; j < cntOfAlp[i] / 2; j++) {
        			front.add((char) ('A' + i));
        			back.add((char) ('A' + i));
        		}
        	}
        }
        
        if(index != -1) {
        	front.add((char) ('A' + index));
        }
        
        while(!front.isEmpty()) {
        	sb.append(front.remove());
        }
        
        while(!back.isEmpty()) {
        	sb.append(back.pop());
        }
        
        System.out.print(sb);
	}
}
  
