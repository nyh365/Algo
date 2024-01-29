import java.util.*;
import java.lang.*;
import java.io.*;
 
public class Main{
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	LinkedList<int[]>[] participants = new LinkedList[N + 1];
    	for(int i = 1; i <= N; i++) {
    		participants[i] = new LinkedList<>();
    	}

    	boolean[] party = new boolean[M + 1];
    	boolean[] friends = new boolean[N + 1];
    	Arrays.fill(party, true);
    	
    	
    	Queue<Integer> queue = new LinkedList<>();
    	st = new StringTokenizer(br.readLine());
    	int num = Integer.parseInt(st.nextToken());
    	for(int i = 0; i < num; i++) {
    		queue.add(Integer.parseInt(st.nextToken()));
    	}
    	
    	int friend;
    	for(int i = 1; i <= M; i++) {
    		st = new StringTokenizer(br.readLine());
    		num = Integer.parseInt(st.nextToken());

    		int base = Integer.parseInt(st.nextToken());
    		participants[base].add(new int[] {base, i});
    		
    		for(int j = 1; j < num; j++) {
    			friend = Integer.parseInt(st.nextToken());
    			participants[base].add(new int[] {friend, i});
    			participants[friend].add(new int[] {base, i});
    		}
    	}
    	
    	int cur;
    	while(!queue.isEmpty()) {
    		cur = queue.remove();
    		
    		for(int[] next : participants[cur]) {
    			if(friends[next[0]] && !party[next[1]]) continue; 
    			queue.add(next[0]);
    			party[next[1]] = false;
    			friends[next[0]] = true;
    		}
    	}
    	
    	int result = 0;
    	for(int i = 1; i <= M; i++) {
    		if(party[i]) result++;
    	}
    	
    	System.out.print(result);
    }
}
