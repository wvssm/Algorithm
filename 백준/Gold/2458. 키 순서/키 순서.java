

import java.util.*;
import java.io.*;

class Main
 {
	static int T, N, M, cnt;
	static boolean []vis;
	static int [][] bridge;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
			
			bridge = new int[N+1][N+1];
			
			for(int j=0; j<M; j++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				bridge[start][end]=1;
			}
			
			cnt = 0;
			for(int j=1; j<=N; j++) {
				vis = new boolean[N+1]; 
				bfs(j);
				
				for(int k=1; k<=N; k++) {
					if(bridge[k][j] == 1) {
						bfs2(k);
					}
				}
				
				if(check()) {
					cnt++;
				}
			}
			
			
		System.out.println(cnt);
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(start);
		vis[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i=1; i<=N; i++) {
				if(vis[i]==false && bridge[cur][i]==1) {
					vis[i] = true;
					q.add(i);
				}
			}
		}
	}
	
	
	static void bfs2(int start) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(start);
		vis[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i=1; i<=N; i++) {
				if(vis[i]==false && bridge[i][cur]==1) {
					vis[i] = true;
					q.add(i);
				}
			}
		}
	}
	
	static boolean check() {
		for(int i=1; i<=N; i++) {
			if(!vis[i]) {
				return false;
			}
		}
		return true;
	}
	
}

