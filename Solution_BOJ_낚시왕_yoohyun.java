import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {0,0,0,1,-1};
	static int[] dy = {0,-1,1,0,0};
	static List<Shark> list;
	static int result, R, C;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));	
		}
		result = 0;
		// 낚시왕이 오른쪽으로 한칸씩 이동
		for(int j = 1; j <= C; j++) {
			// 낚시왕과 같은 열에 있고 땅에 가까운 물고기를 찾는다.
			find(j);
			
			// 물고기 이동
			fishMove();
			fishEat();
		}
		System.out.println(result);
	}
	static public void fishMove() {
		for(int i = 0; i < list.size(); i++) {
			int dis = list.get(i).v;
			int divR = 2 * R - 2;
			int divC = 2 * C - 2;
			if(list.get(i).v != 0) {
				switch(list.get(i).d) {
				case 1:
//					dis = ;
//					dis += (dis/(R * 2) -1) * 2- 1;
//					if((dis / R) % 2 == 1) {
//						list.get(i).setD(1);
//						list.get(i).setY(R-((dis + 1) % R));
//					}
//					else {
//						list.get(i).setD(2);
//						list.get(i).setY((dis + 1) % R);
//					}
//					dis = R-list.get(i).y + R + list.get(i).v;
					if(divR != 0)
						dis %= divR;
					if(dis <= list.get(i).y - 1) {
						list.get(i).setY(list.get(i).y - dis);
					}
					else if(dis > list.get(i).y - 1 && dis < list.get(i).y - 1 + R) {
						list.get(i).setD(2);
						list.get(i).setY(dis - (list.get(i).y - 1) + 1);
					} else {
						list.get(i).setY(list.get(i).y + divR - dis);
					}
					break;
				case 2:
//					dis = list.get(i).y + list.get(i).v;
//					dis += (dis/(R * 2) -1) * 2- 1;
//					if((dis / R) % 2 == 1) {
//						list.get(i).setD(1);
//						list.get(i).setY(R-((dis + 1) % R));
//					}
//					else {
//						list.get(i).setD(2);
//						list.get(i).setY((dis + 1) % R);
//					}
//					dis = list.get(i).y + list.get(i).v - 1;
					if(divR != 0)
						dis %= divR;
					if(dis <= R - list.get(i).y) {
						list.get(i).setY(list.get(i).y + dis);
					}
					else if(dis > R - list.get(i).y && dis < R - list.get(i).y + R) {
						list.get(i).setD(1);
						list.get(i).setY(R - (dis - (R-list.get(i).y)));
					}
					else {
						list.get(i).setY(list.get(i).y - (divR - dis));
					}
					break;
				case 3:
//					dis = C-list.get(i).x + C + list.get(i).v;
					if(divC != 0)
						dis %= divC;
					if(dis <= C - list.get(i).x) {
						list.get(i).setX(list.get(i).x + dis);
					}
					else if(dis > C - list.get(i).x && dis < C - list.get(i).x + C) {
						list.get(i).setD(4);
						list.get(i).setX(C - (dis - (C-list.get(i).x)));
					}
					else {
						list.get(i).setX(list.get(i).x - (divC - dis));
					}
					break;
				case 4:
//					dis = list.get(i).x + list.get(i).v -1;
					if(divC != 0)
						dis %= divC;
					if(dis <= list.get(i).x - 1) {
						list.get(i).setX(list.get(i).x - dis);
					}
					else if(dis > list.get(i).x - 1 && dis < list.get(i).x - 1 + C) {
						list.get(i).setD(3);
						list.get(i).setX(dis - (list.get(i).x - 1) + 1);
					} else {
						list.get(i).setX(list.get(i).x + divC - dis);
					}
					break;
				}
			}
		}
	}
	static public void fishEat() {
		Collections.sort(list);
		for(int i = list.size() - 1; i > 0; i--) {
			if(list.get(i).x == list.get(i - 1).x) {
				if(list.get(i).y == list.get(i - 1).y) {
					if(list.get(i).size > list.get(i - 1).size) {
						list.remove(i - 1);
					}
					else {
						list.remove(i);
					}
				}
			}
		}
	}
	static public void find(int col) {
		Collections.sort(list);
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).x == col) {
				result += list.get(i).size;
				list.remove(i);
				return;
			}
		}
	}
	static public class Shark implements Comparable<Shark>{
		int x, y;
		int v, d;
		int size;
		
		public Shark(int y, int x, int v, int d, int size) {
			super();
			this.x = x;
			this.y = y;
			this.v = v;
			this.d = d;
			this.size = size;
		}
		
		public void setX(int x) {
			this.x = x;
		}
		public void setY(int y) {
			this.y = y;
		}

		public void setD(int d) {
			this.d = d;
		}

		@Override
		public int compareTo(Shark o) {
			if(this.x < o.x) return -1;
			else if(this.x == o.x) {
				if(this.y < o.y) return -1;
				else if(this.y == o.y) return 0;
				else return 1;
			}
			else return 1;
		}
	}
}
