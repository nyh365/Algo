import java.util.*;

class Solution {
    static LinkedList<Integer>[] wPlayer;
    static LinkedList<Integer>[] losPlayer;
    static int[] winCnt, loseCnt;
    static boolean[] visited;
    public int solution(int n, int[][] results) {
        int answer = 0;

        winCnt = new int[n + 1];
        loseCnt = new int[n + 1];
        visited = new boolean[n + 1];
        wPlayer = new LinkedList[n + 1];
        losPlayer = new LinkedList[n + 1];

        for(int i = 1; i <= n; i++){
            wPlayer[i] = new LinkedList<>();
            losPlayer[i] = new LinkedList<>();
        }

        for(int[] win : results){
            wPlayer[win[0]].add(win[1]);
            losPlayer[win[1]].add(win[0]);
        }

        int tmp = 0;
        for(int i = 1; i <= n; i++){
            Arrays.fill(visited, false);
            tmp = findWinCnt(i);

            Arrays.fill(visited, false);
            tmp += findLoseCnt(i);
            if(tmp == n) answer++;
        }

        return answer;
    }
    public int findWinCnt(int number){
        int cnt = 1;
        visited[number] = true;
        for(int player : wPlayer[number]){
            if(visited[player]) continue;
            cnt += findWinCnt(player);
        }

        return cnt;
    }    
    public int findLoseCnt(int number){
        int cnt = 0;

        visited[number] = true;
        for(int player : losPlayer[number]){
            if(visited[player]) continue;
            cnt += findLoseCnt(player) + 1;
        }

        return cnt;
    }
}
