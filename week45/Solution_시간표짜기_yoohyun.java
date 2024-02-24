import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] subject = new int[N][5];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            for(int j = 0; j < K; j++) {
                int num = Integer.parseInt(st.nextToken());
                int day = (num - 1) / 10;
                int hours = num;
                while(hours > 10) {
                    hours -= 10;
                }
                subject[i][day] = subject[i][day] | (1 << (hours - 1));
            }
        }

        int M = Integer.parseInt(br.readLine());
        int[][] student = new int[M][5];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            for(int j = 0; j < K; j++) {
                int num = Integer.parseInt(st.nextToken());
                int day = (num - 1) / 10;
                int hours = num;
                while(hours > 10) {
                    hours -= 10;
                }
                student[i][day] = student[i][day] | (1 << (hours - 1));
            }
        }

        int result[] = new int[M];
        for(int i = 0; i < M; i++) {
            int count = 0;
            for(int j = 0; j < N; j++) {
                boolean flag = true;

                for(int k = 0; k < 5; k++) {
                    if((student[i][k] & subject[j][k]) != subject[j][k]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) count++;
            }
            result[i] = count;
        }


        StringBuilder sb = new StringBuilder();
        for(int num : result) {
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }
}
