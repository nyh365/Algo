import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main{
	static char[][] tictactoe = new char[3][3];
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();

    	String input;
    	while(!(input = br.readLine()).equals("end")) {
    		sb.append(canMake(input) ? "valid" : "invalid").append("\n");
    	}
    	System.out.print(sb);
    }
	public static boolean isSuccess(char target) {
		for(int i = 0; i < 3; i++) {
			if(tictactoe[i][0] == tictactoe[i][1] && tictactoe[i][1] == tictactoe[i][2] && tictactoe[i][2] == target) return true;
			if(tictactoe[0][i] == tictactoe[1][i] && tictactoe[1][i] == tictactoe[2][i] && tictactoe[2][i] == target) return true;
		}
		if(tictactoe[0][0] == tictactoe[1][1] && tictactoe[1][1] == tictactoe[2][2] && tictactoe[2][2] == target) return true;
		if(tictactoe[0][2] == tictactoe[1][1] && tictactoe[1][1] == tictactoe[2][0] && tictactoe[2][0] == target) return true;
		
		return false;
	}
	public static boolean canMake(String input) {
		int index = 0, XCnt = 0, OCnt = 0;
    	boolean XSuccess, OSuccess;
    	
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				tictactoe[i][j] = input.charAt(index++);
				if(tictactoe[i][j] == 'X') XCnt++;
				if(tictactoe[i][j] == 'O') OCnt++;
			}
		}
		
		if(OCnt > XCnt) {
			return false;
		} else {
			// X가 3칸을 연결했는지 확인하기
			XSuccess = isSuccess('X');
			
			// O가  3칸을 연결했는지 확인하기
			OSuccess = isSuccess('O');
			
			if(XSuccess && OSuccess) return false;
			else if(XSuccess) {
				if(XCnt - 1 != OCnt) return false;
			} else if(OSuccess){
				if(XCnt != OCnt) return false;
			} else {
				if((XCnt + OCnt != 9) || ((XCnt + OCnt == 9) && (XCnt - 1 != OCnt))) return false;
			}
		}
		return true;
	}
}
