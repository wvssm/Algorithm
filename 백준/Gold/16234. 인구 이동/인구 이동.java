import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static Queue<int[]> q, q2;
	static int N, L, R, cnt, max, sum, index;
	static int [][]map;
	static boolean [][] vis;
	static int dx[] = new int[] {1, -1, 0, 0};
	static int dy[] = new int[] {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		//--------------솔루션 코드를 작성하세요.--------------------------------
		input();
		
		q = new ArrayDeque<>();
		q2 = new ArrayDeque<>();
		
		boolean isPeopleGo = false;
		int day = 0;
		
		while(true) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(vis[i][j]) continue;
					
					bfs(i,j);
					
					if(q2.size()>=2) {
						isPeopleGo = true;
						fillboard();
					} else {
						q2.poll();
					}
				}
			}
			
			if(!isPeopleGo) {
				break;
			}
			
			day++;
			isPeopleGo = false;
			vis = new boolean[N][N];
		}
		
		System.out.println(day);
	}
	
	static void bfs(int a, int b) {
		vis[a][b] = true;
		sum = map[a][b];
		q.add(new int[] {a,b});
		q2.add(new int[] {a,b});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;			
				if(vis[nx][ny] || L > Math.abs(map[x][y] - map[nx][ny]) ||  R < Math.abs(map[x][y] - map[nx][ny]) ) continue;
				
				vis[nx][ny] = true;
				sum += map[nx][ny];
				
				q2.add(new int[] {nx, ny});
				q.add(new int[] {nx, ny});
			}
		}
	}
	
	static void fillboard() {
		int val = sum / q2.size();
		while(!q2.isEmpty()) {
			int cur[] = q2.poll();
			int x = cur[0];
			int y = cur[1];
			
			map[x][y] = val;
		}
	}
	
	
	static void input() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		q = new ArrayDeque<>();
		
		map = new int[N][N];
		vis = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int j=0; j<N; j++) {
				 map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

}
