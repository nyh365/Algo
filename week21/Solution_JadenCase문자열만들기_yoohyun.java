import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s.toLowerCase(), " ", true);

        String tmp; char c;
        while(st.hasMoreTokens()){
            tmp = st.nextToken();
            if(tmp.equals(" ")){
                sb.append(tmp);
            } else {
                c = tmp.charAt(0);
                if('A' <= c && c <= 'z') {
                    sb.append((char)(c - 32)).append(tmp.substring(1, tmp.length()));
                } else {
                    sb.append(tmp);
                }    
            }
        }    
        return sb.toString();
    }
}
