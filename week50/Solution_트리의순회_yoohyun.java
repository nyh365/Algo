import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {	
	static int[] inorder, postorder, preorder, position;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		inorder = new int[N];
		postorder = new int[N];
		preorder = new int[N];
		position = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			inorder[i] = Integer.parseInt(st.nextToken()); 
			position[inorder[i]] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			postorder[i] = Integer.parseInt(st.nextToken()); 
		}
		makePreorder(0, N - 1, 0, N - 1);
		
		for(int i = 0; i < N; i++) {
			sb.append(preorder[i]).append(" ");
		}
		
		
		System.out.print(sb);
	}
	public static void makePreorder(int inStart, int inEnd, int postStart, int postEnd) {
		if(inStart <= inEnd && postStart <= postEnd) {
			preorder[cnt++] = postorder[postEnd];
			int rootIdx = position[postorder[postEnd]];
			
			makePreorder(inStart, rootIdx - 1, postStart, postStart + rootIdx - 1 - inStart);
			makePreorder(rootIdx + 1, inEnd, postStart + rootIdx - inStart, postEnd - 1);
		}
	}
}
