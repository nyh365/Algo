import java.io.*;
import java.util.*;
public class Main { 	
  static int[] card; 	
  static int N; 	
  static LinkedList<Integer> leftCard = new LinkedList<>(), rightCard = new LinkedList<>(); 	
  static LinkedList<Integer> temp = new LinkedList<>(); 	 	
  public static void main(String[] args) throws IOException { 	
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 	
    StringTokenizer st; 	 
    N = Integer.parseInt(br.readLine()); 	
    card = new int[N]; 	
    st = new StringTokenizer(br.readLine()); 	
    for(int i = 0; i < N; i++) { 		
      card[i] = Integer.parseInt(st.nextToken()); 	
    } 	 	
    for(int i = 1; (1 << i) < N; i++) { 		
      init(); 		 		
      mixCard(i, N, 1); 		
      temp = toList(); 		 		
      for(int j = 1; (1 << j) < N; j++) { 			
        copyList(); 			
        mixCard(j, N, 1); 			
        if(isSame()) { 				
          System.out.print(i + " " + j); 				
          return; 			
        } 		
      } 	
    } 	
    return; 	
  } 	
  public static void init() { 		
    leftCard.clear(); 		
    rightCard.clear(); 		
    for(int i = 1; i <= N; i++) { 			
      leftCard.add(i); 		
    } 	
  } 	 	
  public static LinkedList<Integer> toList() { 		
    LinkedList<Integer> list = new LinkedList<>(); 		 		
    while(!leftCard.isEmpty()) { 			
      list.add(leftCard.remove()); 		
    } 		
    while(!rightCard.isEmpty()) { 			
      list.add(rightCard.remove()); 		
    } 		 		
    return list; 	
  } 	 	
  public static void copyList() { 		
    leftCard.clear(); 		
    rightCard.clear(); 		 		
    for(int i = 0; i < N; i++) { 			
      leftCard.add(temp.get(i)); 		
    } 	
  } 	 	
  public static void mixCard(int K, int size, int step) { 		
    if(step > K + 1) return; 		 		
    int targetCnt = step == 1 ? 1 << K : 1 << (K - step + 1); 		 		
    if(step == 1) { 			
      for(int i = 0; i < size - targetCnt; i++) { 				
        rightCard.add(leftCard.remove()); 			
      } 		
    } else { 			
      for(int i = 0; i < targetCnt; i++) { 				
        leftCard.addFirst(leftCard.removeLast()); 			
      } 			
      for(int i = 0; i < size - targetCnt; i++) { 				
        rightCard.addFirst(leftCard.removeLast()); 			
      } 		
    } 		 		
    mixCard(K, targetCnt, step + 1); 	
  } 	 	
  public static boolean isSame() { 		
    int index = 0, num; 		
    while(!leftCard.isEmpty()) { 			
      num = leftCard.remove(); 			 			
      if(card[index++] != num) return false; 		
    } 		
    while(!rightCard.isEmpty()) { 			
      num = rightCard.remove(); 			 			
      if(card[index++] != num) return false; 		
    } 		 		return true; 	
  } 
}
