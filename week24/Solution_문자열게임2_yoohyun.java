import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		LinkedList<Integer>[] alp = new LinkedList[26];
		for(int test_case = 0; test_case < T; test_case++) {
			String word = br.readLine();
			int k = Integer.parseInt(br.readLine());
			
			init(alp);
				
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			
			int tmp, target;
			for(int i = 0; i < word.length(); i++) {
				tmp = word.charAt(i) - 'a';
				alp[tmp].add(i);

				if(alp[tmp].size() >= k) {
					target = alp[tmp].size() - k;
					min = Math.min(min, i - alp[tmp].get(target) + 1);
					max = Math.max(max, i - alp[tmp].get(target) + 1);
				}
			}
			
			if(min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) {
				sb.append(-1).append("\n");
			} else {
				sb.append(min).append(" ").append(max).append("\n");
			}
		}
		System.out.print(sb);
    }
	
	public static void init(LinkedList<Integer>[] alp) {
		for(int i = 0; i < 26; i++) {
			alp[i] = new LinkedList<>();
		}
	}
}
