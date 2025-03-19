import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static Queue<int[]> q;
	static int N, M, cnt, max;
	static int [][]matrix;
	static boolean [][] vis;
	static int dx[] = new int[] {1, -1, 0, 0};
	static int dy[] = new int[] {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		//--------------솔루션 코드를 작성하세요.--------------------------------
		input();
		
		bfs();
		
		if(isGrow()) {
			System.out.println(max);
		} else {
			System.out.println(-1);
		}
	}
	
	static void bfs() {
		max = Integer.MIN_VALUE;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int cnt = cur[2];
			
			max = Math.max(max, cnt);
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(vis[nx][ny] || matrix[nx][ny] != 0) continue;
				
				vis[nx][ny] = true;
				q.add(new int[] {nx, ny, cnt + 1});
			}
		}
	}
	
	static boolean isGrow() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!vis[i][j] && matrix[i][j]!=-1) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void input() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		q = new ArrayDeque<>();
		
		matrix = new int[N][M];
		vis = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int j=0; j<M; j++) {
				 matrix[i][j] = Integer.parseInt(st.nextToken());
				 
				 if(matrix[i][j] == 1) {
					 q.add(new int[]{i, j, 0});
					 vis[i][j] = true;
				 }
			}
		}
	}

}
