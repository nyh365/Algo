import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int X = Integer.parseInt(br.readLine());
	    
        int tmp;
        for(int i = 1; i <= X; i++) {
        	tmp = i * (i + 1) / 2;
        	if(tmp >= X) {
        		if(i % 2 == 0) {
        			System.out.print((i - (tmp - X)) + "/" + (1 + tmp - X));
        		} else {
        			System.out.print((1 + tmp - X) + "/" + (i - (tmp - X)));
        		}
        		return;
        	}
        }
	}
}
