//package test;

import java.util.*;
import java.io.*;


class Solution{
	static int T;
	static int N, L, max;
	static int [][]arr;
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
			
			arr = new int[N][2];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			max = 0;
			combi(0,0,0,0);
			
			bw.append("#" + test_case + " " + max + "\n");
		}
			
		
		bw.flush();
		bw.close();
	}
	
	static void combi(int depth, int start, int cal, int like) {
		if(cal <= L && max < like) {
			max = like;
		}
		
		if(cal >= L || depth >= N ) {
			return;
		}
		
		for(int i=start; i<N; i++) {
			combi(depth+1, i+1, cal + arr[i][1], like + arr[i][0]);
		}
	}
}