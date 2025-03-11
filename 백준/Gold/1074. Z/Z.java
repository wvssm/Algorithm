import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int N, R, C, count, answer;
	static int[][] map;
	static boolean[][] vis;
	
	public static void main(String[] args) throws IOException {
		input();
		
		dfs(R, C, (int)Math.pow(2, N));
		
		System.out.println(count);
	}
	
	static void dfs(int r, int c, int size) {
		if(size == 1) {
			return;
		}
		
		if(r < size/2 && c < size/2) {
			dfs(r, c, size/2);
		
		} else if(r < size/2 && c >= size/2) {
			count += (size/2) * (size/2);
			dfs(r, c - (size/2), size/2); 
			
		} else if(r >= size/2 && c < size/2) {
			count += (size/2) * (size/2) * 2;
			dfs(r - (size/2), c, size/2); 
			
		} else {
			count += (size/2) * (size/2) * 3;
			dfs(r - (size/2), c - (size/2), size/2); 
		}
	}
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
	}
	
}
