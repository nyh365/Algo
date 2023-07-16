import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {	
	public static class Node{
		int num;
		Node left, right;
		
		public Node(int num) {
			this.num = num;
		}
		
		public void add(int num) {
			if(num < this.num) {
				if(this.left == null) {
					this.left = new Node(num);
				} else {
					this.left.add(num);
				}
			} else {
				if(this.right == null) {
					this.right = new Node(num);
				} else {
					this.right.add(num);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		Node tree = new Node(Integer.parseInt(input));
		while((input = br.readLine()) != null) {
			tree.add(Integer.parseInt(input));
		}
		postOrder(tree, sb);
		System.out.print(sb);
	}
	public static void postOrder(Node tree, StringBuilder sb) {
		if(tree.left != null) {
			postOrder(tree.left, sb);
		}
		if(tree.right != null) {
			postOrder(tree.right, sb);
		}
		sb.append(tree.num).append("\n");
	}
}
