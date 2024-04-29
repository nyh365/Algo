import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main{
    static int[][] alp = new int[10][12];
    public static class Alp implements Comparable<Alp>{
    	int index;
    	long total;
    	boolean isFirst;
    	
    	public Alp (int index) {
    		this.index = index;
    		this.total = 0;
    		this.isFirst = false;
    	}
    	
    	public int compareTo(Alp alp) {
    		return Long.compare(alp.total, this.total);
    	}
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        char[][] alps = new char[N][];
        
        Alp[] arr1 = new Alp[10];
        Alp[] arr2 = new Alp[10];
        for(int i = 0; i < 10; i++) {
        	arr1[i] = new Alp(i);
        	arr2[i] = new Alp(i);
        }

        for(int i = 0; i < N; i++) {
        	alps[i] = br.readLine().toCharArray();
        	for(int j = alps[i].length - 1; j >= 0; j--) {
        		alp[alps[i][j] - 'A'][j]++;
        		arr1[alps[i][j] - 'A'].total += Math.pow(10, alps[i].length - 1 - j);
        		arr2[alps[i][j] - 'A'].total = arr1[alps[i][j] - 'A'].total;
        		if(j == 0) {
        			arr1[alps[i][j] - 'A'].isFirst = true;
        			arr2[alps[i][j] - 'A'].isFirst = true;
        		}
        	}
        }
        
        Arrays.sort(arr1);
        int[] numAlp = new int[10];
        long result = 0;
        for(int i = 0; i < 10; i++) {
        	numAlp[9 - i] = arr1[i].index;
        	if(i == 9 && arr1[i].isFirst) {
        		for(int k = 1; k < 10; k++) {
        			if(!arr2[numAlp[k]].isFirst) {
        				int temp = numAlp[k];
        				for(int j = k; j > 0; j--) {
        					numAlp[j] = numAlp[j - 1];
        				}
        				numAlp[0] = temp;
        				break;
        			}
        		}
        	}
        }
        
        for(int i = 0; i < 10; i++) {
        	result += i * arr2[numAlp[i]].total;
        }
        
        System.out.print(result);
    }
}
