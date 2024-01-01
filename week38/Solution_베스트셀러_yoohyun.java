import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Book> list = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			String title = br.readLine();
			
			int index = list.indexOf(new Book(title, 0));
			if(index >= 0) {
				Book b = list.get(index);
				b.setCount(b.getCount() + 1);
			}
			else {
				list.add(new Book(title, 0));
			}
			
		}
		
		Collections.sort(list);
		System.out.println(list.get(0).getTitle());
		
	}
	public static class Book implements Comparable<Book>{
		private String title;
		private int count;

		
		public Book(String title, int count) {
			super();
			this.title = title;
		}
		
		public String getTitle() {
			return title;
		}

		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((title == null) ? 0 : title.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Book other = (Book) obj;
			if (title == null) {
				if (other.title != null)
					return false;
			} else if (!title.equals(other.title))
				return false;
			return true;
		}

		@Override
		public int compareTo(Book o) {
			// TODO Auto-generated method stub
			return this.count > o.count ? -1 : (this.count == o.count ? title.compareTo(o.title) : 1);
		}
	}
}
