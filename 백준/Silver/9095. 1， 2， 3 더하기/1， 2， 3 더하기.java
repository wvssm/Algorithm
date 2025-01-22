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
		
		int dp[] = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i=4; i<11; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			int input = Integer.parseInt(br.readLine());
			bw.append(String.valueOf(dp[input]));
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
	}
}
