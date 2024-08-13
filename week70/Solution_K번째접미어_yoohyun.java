import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Trie {
	char alp;
	boolean isEnd;
	Trie[] child = new Trie[26];
	
	Trie() {}
	
	Trie(char alp){
		this.alp = alp;
	}
	
	void add(int index, String s) {
		if(this.child == null) {
			this.child = new Trie[26];
		}

		int childIdx = s.charAt(index) - 'a';
		if(this.child[childIdx] == null) {
			this.child[childIdx] = new Trie(s.charAt(index));
		}
		
		if(index == s.length() - 1) {
			this.child[childIdx].isEnd = true;
			return;
		} else {
			this.child[childIdx].add(index + 1, s);
		}
	}
}

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static char[] result = new char[400];
	static int curK;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			
			Trie root = new Trie();
			
			int size = input.length();
			for(int i = 0; i < size; i++) {
				root.add(0, input.substring(i));
			}
			if(N > size) {
				sb.append("none").append("\n");
			} else {
				curK = 0;
				dfs(root, 0, N);
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
	public static void dfs(Trie trie, int dept, int K) {
		if(curK >= K) return;
		
		if(trie.isEnd) {
			curK++;
			
			if(curK == K) {
				for(int i = 0; i < dept; i++) {
					sb.append(result[i]);
				}
			}
		}
		
		if(trie.child != null) {
			for(int i = 0; i < 26; i++) {
				if(trie.child[i] != null) {
					result[dept] = (char) ('a' + i);
					dfs(trie.child[i], dept + 1, K);
				}
			}
		}
	}
}
