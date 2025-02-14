import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        Queue<Integer> queue = new LinkedList<>();
        
        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++) {
        	queue.add(i);
        }

        boolean flag = true;
        while(!queue.isEmpty()) {
        	if(flag) {
        		sb.append(queue.remove()).append(" ");
        		flag = false;
        	} else {
        		queue.add(queue.remove());
        		flag = true;
        	}
        }
        
        System.out.println(sb);
	}
}
