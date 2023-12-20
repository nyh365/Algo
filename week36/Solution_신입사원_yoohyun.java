import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      StringTokenizer st;
      int T = Integer.parseInt(br.readLine());
      for(int test_case = 0; test_case < T; test_case++) {
    	  int N = Integer.parseInt(br.readLine());
    	  int result = 0;
    	  List<Employee> list = new ArrayList<>();
    	  for(int i = 0; i < N; i++) {
    		 st = new StringTokenizer(br.readLine());
    		 list.add(new Employee(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
    	  }
    	  Collections.sort(list);
    	  int rrank = Integer.MAX_VALUE;
    	  int irank = Integer.MAX_VALUE;
    	  for(int i = 0; i < N; i++) {
    		  if(rrank > list.get(i).r_rank && irank > list.get(i).i_rank) {
    			  if(list.get(i).r_rank == (i / 2) + 1)
    				  irank = list.get(i).i_rank;
    			  else {
    				  rrank = list.get(i).r_rank;  
    			  }
    			  result++;
    		  }
    	  }
    	  sb.append(result).append("\n");
      }
      
      System.out.println(sb);
    }
    
}
class Employee implements Comparable<Employee>{
	int r_rank;
	int i_rank;
	int hight;
	int low;
	public Employee(int r_rank, int i_rank) {
		super();
		this.r_rank = r_rank;
		this.i_rank = i_rank;
		hight = this.r_rank;
		low = this.i_rank;
		if(hight > low) {
			int tmp = hight;
			hight = low;
			low = tmp;
		}
	}
	@Override
	public int compareTo(Employee o) {
		if(this.hight < o.hight) {
			return -1;
		}
		else if(this.hight == o.hight) {
			if(this.low > o.low) return 1;
			else if(this.i_rank == o.i_rank) return 0;
			else return -1;
		}
		else return 1;
	}
}
