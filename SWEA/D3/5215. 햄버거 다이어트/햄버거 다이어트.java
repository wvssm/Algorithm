import java.util.*;
import java.io.*;


class Solution{
	static int T;
	static int N, L, max;
	static int [][]item;
	static int [][]dp;
	static StringTokenizer st;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1; test_case <= T; test_case++){
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			item = new int[N+1][2];
			dp = new int[N+1][L+1];
			
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				item[i][0] = Integer.parseInt(st.nextToken());
				item[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=L; j++) {
					if(item[i][1] > j) {
						dp[i][j] = dp[i-1][j];
					}else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - item[i][1]] + item[i][0]);
					}
				}
			}
			
			bw.append("#" + test_case + " " + dp[N][L] + "\n");
		}
			
		
		bw.flush();
		bw.close();
	}
}