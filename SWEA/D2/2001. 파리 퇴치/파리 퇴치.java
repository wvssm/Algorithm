//package test;

import java.util.*;
import java.io.*;


class Solution{
	static int T;
	static int N, M, max, result;
	static int [][]map;
	static int [][]dp;
	static String str;
	static StringTokenizer st;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1; test_case <= T; test_case++){
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N+1][N+1];
			dp = new int[N+1][N+1];
			
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + map[i][j];
				}
			}
			
			max = 0;
			result = 0;
			
			for(int i=1; i<=N-M+1; i++) {
				for(int j=1; j<=N-M+1; j++) {
					result = count(i,j);
					if(max < result) {
						max = result;
					}
				}
			}
			
			
			

			bw.append("#" + test_case + " " + max + "\n");
		}
			
		
		bw.flush();
		bw.close();
	}
	
	static int count(int x, int y) {
		int x1 = x;
		int y1 = y;
		int x2 = x+M-1;
		int y2 = y+M-1;
		
		return dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];
	}
}