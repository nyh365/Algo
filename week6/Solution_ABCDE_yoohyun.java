import java.io.*;
import java.util.*;

public class Main {
	static List<List<Integer>> list = new ArrayList<>();;
    static int result = 0;
    static int N;
	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < N; i++) {
        	list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	list.get(from).add(to);
        	list.get(to).add(from);
        }
        
        for(int i = 0; i < N; i++) {
        	boolean check[] = new boolean[N];
    		dfs(0,i,check);
    		if(result == 1) break;
        }
        
        System.out.println(result);
    }    
    public static void dfs(int cnt, int from, boolean[] check) {
    	if(cnt == 4) {
    		result = 1;
    		return;
    	}
		if(list.get(from).size() > 0) {
			check[from] = true;
			for(int i = 0; i < list.get(from).size(); i++) {
				if(!check[list.get(from).get(i)])
					dfs(cnt + 1, list.get(from).get(i), check);
			}
			check[from] = false;
		}
    }
}
