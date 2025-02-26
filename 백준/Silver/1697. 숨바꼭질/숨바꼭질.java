import java.io.*;
import java.util.*;

// nCr

class Main {
	static int N, K, answer;
	static boolean[] vis;
	static int dx[] = {-1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		vis = new boolean[100001];
		
		bfs(N,0);
		
		System.out.println(answer);
	}
	
	static void bfs(int start, int depth) {
		Queue<int []> q = new LinkedList<>();
		
		q.add(new int[] {start, depth});
		vis[start] = true;
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			
			if(cur[0] == K) {
				answer = cur[1];
				return;
			}
			
			for(int i=0; i<3; i++) {
				int nx = 0;
				
				if(i<=1) {
					nx = cur[0] + dx[i];
				}
				else {
					nx = cur[0]*2;
				}
				
				if(nx < 0 || nx > 100000 || vis[nx]) continue;
				vis[nx] = true;
				q.add(new int[] {nx, cur[1] + 1});
			}
		}
		
	}
}