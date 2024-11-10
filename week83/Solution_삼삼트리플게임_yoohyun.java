import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++) {
			int[] red = new int[10];
			int[] blue = new int[10];
			int[] gleen = new int[10];

			sb.append("#").append(test_case).append(" ");

			String result = "Win";
			String num = br.readLine();
			String color = br.readLine();

			for(int i = 0; i < 9; i++) {
				if(color.charAt(i) == 'R') {
					red[num.charAt(i) -'0']++;
					red[0]++;
				}

				else if(color.charAt(i) == 'B') {
					blue[num.charAt(i) -'0']++;
					blue[0]++;
				}

				else{
					gleen[num.charAt(i) -'0']++;
					gleen[0]++;
				}
			}

			if(red[0] % 3 != 0 || blue[0] % 3 != 0 || gleen[0] % 3 != 0 ) {
				result = "Continue";
			}

			else {
				for(int k = 0; k < 3; k++){
					int cnt = 0;
					boolean flag1 = false;
					boolean flag2 = false;

					for(int i = 1; i <= 9; i++) {
						if(red[i] > 3) {
							flag2 = true;
							red[i] -= 3;
							red[0] -= 3;
							break;
						}

						if(!flag1 && 0 < red[i] && red[i] < 3) {
							if(!flag1) flag1 = true;
							else flag2 = true;
							cnt++;
						}

						else if(flag1 && 0 < red[i]){
							if(!flag1) flag1 = true;
							else flag2 = true;
							cnt++;
						}

						else {
							flag1 = false;
							cnt = 0;
						}

						if(cnt == 3) {
							red[i]--;red[i-1]--;red[i-2]--;
							red[0] -= 3;
							break;
						}
					}

					if(!flag2) {
						for(int i = 1; i <= 9; i++) {
							if(red[i] >= 3) {
								red[i] -= 3;
								red[0] -= 3;
							}
            }
					}
				}

				for(int k = 0; k < 3; k++) {
					int cnt = 0;
					boolean flag1 = false;
					boolean flag2 = false;

					for(int i = 1; i <= 9; i++) {
						if(blue[i] > 3) {
							flag2 = true;
							blue[i] -= 3;
							blue[0] -= 3;
							break;
						}

						if(!flag1 && 0 < blue[i] && blue[i] < 3 ) {
							if(!flag1) flag1 = true;
							else flag2 = true;
							cnt++:
						}

						else if(flag1 && 0 < blue[i]){
							if(!flag1) flag1 = true;
							else flag2 = true;
							cnt++;
						}

						else {
							flag1 = false
							cnt = 0;
						}

						if(cnt == 3) {
							blue[i]--;blue[i-1]--;blue[i-2]--;
							blue[0] -= 3;
							break;
						}
					}

					if(!flag2) {
						for(int i = 1; i <= 9; i++) {
							if(blue[i] >= 3) {
								blue[i] -= 3;
								blue[0] -= 3;
              }
				  	}
					}
				}

				for(int k = 0; k < 3; k++) {
					int cnt = 0;
					boolean flag1 = false;
					boolean flag2 = false;

					for(int i = 1; i <= 9; i++) {
						if(gleen[i] > 3) {
							flag2 = true;
							gleen[i] -= 3;
							gleen[0] -= 3;
				  		break;
						}

						if(!flag1 && 0 < gleen[i] && gleen[i] < 3) {
							if(!flag1) flag1 = true;
							else flag2 = true;
							cnt++;
						}

						else if(flag1 && 0 < gleen[i]){
							if(!flag1) flag1 = true;
							else flag2 = true;
							cnt++;
						}

						else {
							flag1 = false;
							cnt = 0;
						}

						if(cnt == 3) {
							gleen[i]--;gleen[i-1]--;gleen[i-2]--;
							gleen[0] -= 3;
							break;
						}
					}

					if(!flag2) {
						for(int i = 1; i <= 9; i++) {
							if(gleen[i] >= 3) {
								gleen[i] -= 3;
								gleen[0] -= 3;
							}
						}
					}
				}
			}
			if(red[0] > 0 || blue[0] > 0 || gleen[0] > 0) result = "Continue";

			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}
}

