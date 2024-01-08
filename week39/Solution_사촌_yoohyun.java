import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] num, parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        while(true){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            if(N == 0 && K == 0) break;

            init(N);
            int parentIdx = -1, targetIdx = -1;
            parent[0] = -1;
            num[0] = -1;
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++){
                num[i] = Integer.parseInt(st.nextToken());
                if(num[i] == K){
                    targetIdx = i;
                }
                if(num[i - 1] + 1 != num[i]){
                    parentIdx++;
                }
                parent[i] = parentIdx;
            }
            sb.append(findCousin(N, targetIdx)).append("\n");
        }
        System.out.print(sb);
    }
    public static void init(int N){
        num = new int[N + 1];
        parent = new int[N + 1];
    }

    public static int findCousin(int N, int targetIdx){
        int result = 0;
        int sibling = parent[targetIdx];
        int target = parent[parent[targetIdx]];
        for(int i = 1; i <= N; i++){
            if(i == targetIdx) continue;
            if(parent[i] == sibling) continue;
            if(target == parent[parent[i]]) result++;
        }
        return result;
    }   
}
