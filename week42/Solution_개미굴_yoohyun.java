import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static StringBuilder sb;
	public static class Trie{
		char alp;
		Trie[] child;
		int end;

		public Trie() {
		}

		public Trie(char alp) {
			this.alp = alp;
		}
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        Trie root = new Trie();
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int M = Integer.parseInt(st.nextToken());
        	String[] input = new String[M];
        	for(int j = 0; j < M; j++) {
        		input[j] = st.nextToken();
        	}
        	
        	trieAdd(0, 0, root, input);
        }
        for(int i = 0; i < 26; i++) {
        	if(root.child[i] == null) continue;
        	printTrie(new StringBuilder(), new StringBuilder(), root.child[i]);
        }
        
        System.out.print(sb);
    }
    public static void trieAdd(int curIdx, int alpIdx, Trie trie, String[] input) {
    	char child = input[curIdx].charAt(alpIdx);
    	int childIdx = child -'A';
    	if(trie.child == null) {
    		trie.child = new Trie[26];
    	} 
    	if(trie.child[childIdx] == null) {
			trie.child[childIdx] = new Trie(child);
		}
    	if(input[curIdx].length() - 1 == alpIdx) {
    		if(curIdx == input.length - 1) {
    			trie.child[childIdx].end |= 1;
    		} else {
    			trie.child[childIdx].end |= (1 << 1);
    			trieAdd(curIdx + 1, 0, trie.child[childIdx], input);
    		}
		} else {
			trieAdd(curIdx, alpIdx + 1, trie.child[childIdx], input);
		}
    }
    
    public static void printTrie(StringBuilder deep, StringBuilder word, Trie trie) { 	
    	word.append(trie.alp);
    	if((trie.end & 3) > 0) {
    		sb.append(deep).append(word);
    		sb.append("\n");
    	}
    	if(trie.child == null) return;
    	for(int i = 0; i < 26; i++) {
    		if(trie.child[i] == null) continue;
    		if ((trie.end & (1 << 1)) > 0){
    			printTrie(new StringBuilder(deep).append("--"), new StringBuilder(), trie.child[i]);
    		} else{
    			printTrie(new StringBuilder(deep), new StringBuilder(word), trie.child[i]);
    		}
    		
    	}
    }
}
