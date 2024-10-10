import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int FF = Integer.parseInt(st.nextToken());
        int FS = Integer.parseInt(st.nextToken());
        int SF = Integer.parseInt(st.nextToken());
        int SS = Integer.parseInt(st.nextToken());

        if(FF == 0 && FS == 0) {
        	System.out.println(SS + Math.min(1, SF));
        } else if (FS == 0) {
        	System.out.println(FF);
        } else {
        	if(FS > SF) {
        		System.out.println(SF * 2 + SS + FF + 1);
        	} else {
        		System.out.println(FS * 2 + SS + FF);
        	}
        }
    }
}
