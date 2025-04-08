import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int arr[];
	static int c[];
	static int N;
	
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine().trim());
		arr = new int[N];
		c = new int[N]; // 각 길이를 LIS로 만족하는 가장 끝에 오는 값 
		
		st = new StringTokenizer(br.readLine().trim());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int size = 0;
		for(int i=0; i<N; i++) {
			// i 원소가 최소값으로 끝에 설 수 있는 위치
			int pos = Arrays.binarySearch(c, 0, size, arr[i]); // 들어갈 수 있는 upperbound 위치 찾음 
			
			// 못찾으면 -insertion point -1 (0 때문에 그럼, -0이 존재할 수 없으니까)
			if(pos >= 0) continue; // 찾는 값이 있다는 얘기는 값의 중복이 있다. 문제에 따라 다르게 처리
			
			int temp = Math.abs(pos) - 1;
			
			c[temp] = arr[i];
			
			if(temp == size) {
				size++;
			}
			
		}
		System.out.println(size);
	}
}
