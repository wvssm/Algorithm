import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int R, C, count;
	static int max = Integer.MIN_VALUE;
	static String P;
	static char[][] map;
	static boolean[][] vis;
	static Set<Character> set;
	
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	
	static boolean isHead, isError;

	public static void main(String[] args) throws IOException {
		input();
		
		solution();
		
		System.out.println(max);
	}
	
	static void solution() {
		vis = new boolean[R][C];
		set = new HashSet<>();
		
		vis[0][0] = true;
		set.add(map[0][0]);

		dfs(0,0);
		
	}
	
	static void dfs(int x, int y) {
		if(set.size() > max) {
			max = set.size();
		}
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
			if(vis[nx][ny] || set.contains(map[nx][ny])) continue;
			
			set.add(map[nx][ny]);
			vis[nx][ny] = true;
			dfs(nx, ny);
			set.remove(map[nx][ny]);
			vis[nx][ny] = false;
			
		}
		
	}
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine().trim());
			String input = st.nextToken();
			for(int j=0; j<C; j++) {
				map[i][j] = input.charAt(j);
			}
		}
	}
}
