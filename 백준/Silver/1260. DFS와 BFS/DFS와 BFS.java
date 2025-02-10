import java.io.*;
import java.util.*;

class Main{		
	static int [][] node;
	static boolean []vis;
	static int n;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String args[])throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		node = new int[n+1][n+1];
		vis = new boolean[n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			node[x][y] = 1;
			node[y][x] = 1;
		}
		
		
		dfs(v);
		
		Arrays.fill(vis, false);
		bw.append("\n");
		
		bfs(v);
		
		
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int start) throws IOException {
		vis[start] = true;
		bw.append(String.valueOf(start)+" ");
		
		for(int i=1; i<=n; i++) {
			if(vis[i]==false && node[start][i]==1) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int start) throws IOException {
		
		Queue<Integer> q = new LinkedList<>();
		
		vis[start] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			bw.append(String.valueOf(cur)+" ");
			
			for(int i=1; i<=n; i++) {
				if(!vis[i] && node[cur][i]==1) {
					vis[i] = true;
					q.add(i);
				}
			}
		}
	}
}
