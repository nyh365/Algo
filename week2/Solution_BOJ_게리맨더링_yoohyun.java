import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static ArrayList<ArrayList<Integer>> list;
	static int[] population;
	static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		population = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		list = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			for(int j = 0; j < M; j++) {
				list.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		
		boolean[] visited = new boolean[N + 1];
		result = Integer.MAX_VALUE;
		subSet(0, 0, visited);
		if(result == Integer.MAX_VALUE)
			result = -1;
		System.out.println(result);

	}
	static public void subSet(int dept, int Tcount, boolean[] visited) {
		if(dept == N) {
			// 구역이 제대로 나누어졌는지 확인
			if(isTValidate(visited, Tcount) && isFValidate(visited, N - Tcount)) {
				// 최솟값 구하기
				findMin(visited);
			}
			return;
		}
		visited[dept + 1] = true;
		subSet(dept + 1, Tcount + 1, visited);
		visited[dept + 1] = false;
		subSet(dept + 1, Tcount, visited);
	}
	static public boolean isTValidate(boolean[] visited, int Tcount) {
		if(Tcount == 0 || Tcount == N) return false;
		int count = 0;
		boolean[] check = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		boolean flag = false;
		for(int i = 1; i <= N; i++) {
			if(visited[i] && !check[i]) {
				flag = true;
				count++;
				check[i] = true;
				queue.add(i);
			}
			while(!queue.isEmpty()) {
				int region = queue.remove();
				for(int j = 0; j < list.get(region).size(); j++) {
					if(!check[list.get(region).get(j)] && visited[list.get(region).get(j)]) {
						check[list.get(region).get(j)] = true;
						count++;
						queue.add(list.get(region).get(j));
					}
				}
			}
			if(flag)
				break;
		}
		if(count == Tcount) return true;
		else return false;
	}
	static public boolean isFValidate(boolean[] visited, int Fcount) {
		if(Fcount == 0 || Fcount == N) return false;
		int count = 0;
		boolean[] check = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		boolean flag = false;
		for(int i = 1; i <= N; i++) {
			if(!visited[i] && !check[i]) {
				flag = true;
				count++;
				check[i] = true;
				queue.add(i);
			}
			while(!queue.isEmpty()) {
				int region = queue.remove();
				for(int j = 0; j < list.get(region).size(); j++) {
					if(!check[list.get(region).get(j)] && !visited[list.get(region).get(j)]) {
						check[list.get(region).get(j)] = true;
						count++;
						queue.add(list.get(region).get(j));
					}
				}
			}
			if(flag)
				break;
		}
		if(count == Fcount) return true;
		else return false;
	}
	static public void findMin(boolean[] visited) {
		int Tnum = 0;
		int Fnum = 0;
		for(int i = 1; i <= N; i++) {
			if(visited[i]) {
				Tnum += population[i];
			} else {
				Fnum += population[i];
			}
		}
		int num = Math.abs(Tnum - Fnum);
		result = Math.min(result, num);
	}
}
