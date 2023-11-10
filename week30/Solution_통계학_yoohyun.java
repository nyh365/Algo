import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num];
		
		for(int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		f1(arr);
		f2(arr);
		f3(arr);
		f4(arr);
		
		
	}
	public static void f1(int[] arr) {
		double sum = 0;
		for(int i = 0; i < arr.length; i++)
			sum += arr[i];
		System.out.println(Math.round(sum / arr.length));
		
	}
	public static void f2(int[] arr) {
		Arrays.sort(arr);
		System.out.println(arr[arr.length / 2]);
	}
	public static void f3(int[] arr) {
		int count = 1;
		boolean flag = false;
		int max = Integer.MIN_VALUE;
		int current = arr[0];
		int result = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(current == arr[i]) {
				count++;
			}
			else {
				if(max < count) {
					max = count;
					result = arr[i - 1];
					flag = false;
				}
				else if(max == count) {
					if(!flag) {
						flag = true;
						result = arr[i - 1];
					}
				}
				current = arr[i];
				count = 1;
			}
		}
		if(arr.length != 1) {
			if(max < count) {
				max = count;
				result = arr[arr.length -1];
				flag = false;
			}
			else if(max == count) {
				if(!flag) {
					flag = true;
					result = arr[arr.length -1];
				}
			}
		}
		
		System.out.println(result);
	}
	public static void f4(int[] arr) {
		System.out.println(arr[arr.length - 1] - arr[0]);
	}
}
