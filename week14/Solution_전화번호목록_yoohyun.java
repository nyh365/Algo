import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {	
	public static class Trie{
		boolean visit;
		Trie[] child;
		
		public Trie() {
			this.child = new Trie[10];
		}

		public Trie(boolean visit) {
			this.visit = visit;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int test_case = Integer.parseInt(br.readLine());
		for(int t = 1; t <= test_case; t++) {
			int N = Integer.parseInt(br.readLine());
			Trie root = new Trie();
			boolean flag = true;
			for(int i = 0; i < N; i++) {
				char[] phone = br.readLine().toCharArray();
				if(!flag) continue;
				if(!makeTrie(root, phone, 0)) {
					flag = false;
				}
			}
			sb.append(flag ? "YES" : "NO").append("\n");
		}
		
		System.out.print(sb);
	}
	public static boolean makeTrie(Trie root, char[] phone, int index) {
		int num = phone[index] - '0';
		if(index == phone.length - 1) {
			if(root.child[num] == null) {
				root.child[num] = new Trie(true);
				return true;
			} else {
				root.child[num].visit = true;
				return false;
			}
		} 
		if(root.child[num] == null) {
			root.child[num] = new Trie();
		} else {
			if(root.child[num].visit) return false;
		}
		return makeTrie(root.child[num], phone, index + 1);
	}
}
