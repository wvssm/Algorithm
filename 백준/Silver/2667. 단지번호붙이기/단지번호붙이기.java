import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int N, M, houseCount;
	static int[][] map;
	static boolean[][] vis;
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	static List<Integer> houseCounts;
	
	public static void main(String[] args) throws Exception {	
		input();
		
		houseCounts = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(vis[i][j] || map[i][j]==0) continue;
				houseCount = 0;
				bfs(i,j);
				houseCounts.add(houseCount);

			}
		}
		
		print();
	}
	
	static void bfs(int sx, int sy) {
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {sx, sy});
		vis[sx][sy] = true;
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			houseCount++;
			
			for(int i=0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(map[nx][ny] == 0 || vis[nx][ny]) continue;
				vis[nx][ny] = true;
				q.add(new int[] {nx, ny});
			}
		}
		
	}
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		vis = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			
			for(int j=0; j<N; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
	}
	
	static void print() {
		Collections.sort(houseCounts);
		
		sb = new StringBuilder();
		
		sb.append(houseCounts.size()).append("\n");
		
		for(int houseCount : houseCounts) {
			sb.append(houseCount).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}