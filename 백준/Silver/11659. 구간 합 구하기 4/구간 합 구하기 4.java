import java.io.*;
import java.util.*;

class Main{	
	static int[][] map;
	static boolean [] visited;
	static int cnt = 0;
	static int n = 0;
	
	public static void main(String args[])throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int []arr = new int[n+1];
		arr[0] = 0;
		
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for(int i=1; i<=n; i++) {
			sum += Integer.parseInt(st.nextToken());
			arr[i] = sum;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int head = Integer.parseInt(st.nextToken());
			int tail = Integer.parseInt(st.nextToken());
			
			int answer = arr[tail] - arr[head-1];
			bw.append(String.valueOf(answer));
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
	}
}
