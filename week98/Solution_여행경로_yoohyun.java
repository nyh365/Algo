import java.util.*;

class Solution {
    List<String> results;
    boolean[] visited;
    public String[] solution(String[][] tickets) {
        results = new LinkedList<>();
        visited = new boolean[tickets.length];
        
        dfs("ICN", "ICN", tickets, 0);
        
        Collections.sort(results);
        
        return results.get(0).split(" ");
    }
    public void dfs(String start, String route, String[][] tickets, int cnt) {
        if(cnt == tickets.length) {
            results.add(route);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(visited[i] || !tickets[i][0].equals(start)) continue;
            visited[i] = true;
            dfs(tickets[i][1], route + " " + tickets[i][1], tickets, cnt + 1);
            visited[i] = false;
        }
    }
}
