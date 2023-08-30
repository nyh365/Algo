import java.util.*;
import java.io.*;
public class Main
{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] cost = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cost);

        int target, index;
        for(int i = 0; i < q; i++){
            target = Integer.parseInt(br.readLine());
            index = findMiddle(cost, target);
            if(index == -1){
                sb.append(0).append("\n");
            } else {
                sb.append(index * (n - index - 1)).append("\n");
            }
        }
        System.out.print(sb);
    }

    public static int findMiddle(int[] cost, int target){
        int start = 0, end = cost.length - 1;
        int mid = -1, result = -1;
        while(start <= end){
            mid = (start + end) / 2;
            if(target == cost[mid]){
                result = mid;
                return result;
            } else if(cost[mid] < target){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}
