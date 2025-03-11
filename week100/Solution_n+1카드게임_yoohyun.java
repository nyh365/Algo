class Solution {
    static boolean[] myCards = new boolean[1001];
    static boolean[] pendingCards = new boolean[1001];
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        
        int cardIdx = 0;
        for(; cardIdx < n / 3; cardIdx++) {
            myCards[cards[cardIdx]] = true;
        }
        
        int round = 1;
        
        for(;;round++) {
            // 카드 뽑기
            if(cardIdx >= n) break;
            
            pendingCards[cards[cardIdx++]] = true;
            pendingCards[cards[cardIdx++]] = true;
            
            // 카드 내기
            if(findTargetInMyCard(n)) continue;
            if(coin > 0) {
                if(findTargetOneCoin(n)) {
                    coin--;
                    continue;
                }
            }
            if(coin > 1) {
                if(findTargetTwoCoin(n)) {
                    coin -= 2;
                    continue;
                } 
            }
            break;
        }    
        
        return round;
    }
    public boolean findTargetInMyCard(int n) {
        for(int i = 1; i <= n / 2; i++) {
            if(myCards[i] && myCards[n + 1 - i]) {
                myCards[i] = false;
                myCards[n + 1 - i] = false;
                return true;
            }
        } 
        
        return false;
    }
    
    public boolean findTargetOneCoin(int n) {
        for(int i = 1; i <= n; i++) {
            if(myCards[i] && pendingCards[n + 1 - i]) {
                myCards[i] = false;
                pendingCards[n + 1 - i] = false;
                return true;
            }
        } 
        
        return false;
    }
    
    public boolean findTargetTwoCoin(int n) {
        for(int i = 1; i <= n / 2; i++) {
            if(pendingCards[i] && pendingCards[n + 1 - i]) {
                pendingCards[i] = false;
                pendingCards[n + 1 - i] = false;
                return true;
            }
        } 
        
        return false;
    }
}
