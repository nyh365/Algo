import java.io.*;
import java.util.*;

class Solution{
    static int result;
    static int[] stuff, rotation;
    static int K;
    static LinkedList<int[]> link = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            K = Integer.parseInt(br.readLine());

            stuff = new int[4];
            for(int i = 0; i < 4; i++) {
                char[] input = br.readLine().replace(" ", "").toCharArray();
                for(int j = 7; j >= 0; j--) {
                    if(input[j] == '1') {
                        stuff[i] |= 1 << 7-j;
                    }
                }
            }
            link.add(new int[] {0,0});
            link.add(new int[] {-1,1});
            link.add(new int[] {0,2});
            link.add(new int[] {1, 3});
            link.add(new int[] {2,-1});


            for(int i = 0; i < K ; i++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                rotation = new int[] {-2,-2,-2,-2};

                dfs(num, dir, true);

                for(int j = 0; j < 4; j++) {
                    if(rotation[j] == 1) {
                        right(j);
                    }
                    else if(rotation[j] == -1){
                        left(j);
                    }
                }
            }
            result = 0;
            for(int i = 0; i < 4; i++) {
                if((1 << 7 & stuff[i]) > 0) {
                    result += Math.pow(2, i);
                }
            }

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
    public static void right(int index) {
        int tmp = (stuff[index] & 1 << 0) > 0 ? 1 : 0;
        stuff[index] = stuff[index] >> 1;
        stuff[index] |= tmp << 7;

    }
    public static void left(int index) {
        int tmp = (stuff[index] & 1 << 7) > 0 ? 1 : 0;
        stuff[index] = stuff[index] << 1;
        stuff[index] -= tmp << 8;
        stuff[index] += tmp;
    }
    public static void dfs(int current, int dir, boolean start) {
        if(link.get(current)[0] != -1 && rotation[link.get(current)[0]] == -2) {
            if(((stuff[current - 1] & (1 << 1)) != ((stuff[link.get(current)[0]] & (1 << 5))) >> 4)) {
                rotation[current-1] = dir;
                rotation[link.get(current)[0]] = dir * -1;
                dfs(link.get(current)[0] + 1, dir * -1, false);
            }
        }
        if(link.get(current)[1] != -1 && rotation[link.get(current)[1]] == -2) {
            if((((stuff[current - 1] & (1 << 5)) >> 4) != (stuff[link.get(current)[1]] & (1 << 1)))) {
                rotation[current-1] = dir;
                rotation[link.get(current)[1]] = dir * -1;
                dfs(link.get(current)[1] + 1, dir * -1, false);
            }
        }
         if(start) {
             if(rotation[current - 1] == -2)
                 rotation[current - 1] = dir;
         }
    }
}
