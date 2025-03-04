import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int N;
	static boolean[][] vis;
	static int max, nongdo, max_nongdo, count;
	static int[][] map;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		max_nongdo = -1;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(max_nongdo < map[i][j]) {
					max_nongdo = map[i][j];
				}
			}
		}
		
		max = Integer.MIN_VALUE;
		for(int i=0; i<=max_nongdo; i++) {
			nongdo = i;
			vis = new boolean[N][N];
			count = 0;
			
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					if(vis[j][k] || map[j][k] <= nongdo) {
						continue;
					}
					bfs(j,k);
					count++;
				}
			}
			
			if(max < count) {
				max = count;
			}
		}
		
		System.out.println(max);
	}
	
	static void bfs(int sx, int sy) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {sx, sy});
		vis[sx][sy] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			int x = cur[0];
			int y = cur[1];
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}
				
				if(vis[nx][ny] || map[nx][ny] <= nongdo) {
					continue;
				}
				
				vis[nx][ny] = true;
				q.add(new int[] {nx, ny});
			}
		}
	}

}
