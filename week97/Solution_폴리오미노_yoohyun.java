import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        
        input = input.replaceAll("XXXX", "AAAA");
        input = input.replaceAll("XX", "BB");
        
        if(input.contains("X")) {
        	System.out.println(-1);
        	return;
        }
        
        System.out.println(input);
	}
}
