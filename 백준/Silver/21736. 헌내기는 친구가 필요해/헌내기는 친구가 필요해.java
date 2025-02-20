import java.util.*;
import java.io.*;

class Main
 {
	static int N, M, answer;
	static char [][]map;
	static boolean [][]vis;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int[] start;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력 받기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		vis = new boolean[N][M];
		start = new int[2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String row = st.nextToken();
			for(int j=0; j<M; j++) {
				map[i][j] = row.charAt(j);
				if(map[i][j]=='I') {
					start[0] = i;
					start[1] = j;
				}
			}
		}
		
		answer = 0;
		bfs(start);
		
		if(answer==0) {
			bw.append("TT");
		} else {
			bw.append(String.valueOf(answer));
		}
		bw.flush();
		bw.close();
	}
	
	static void bfs(int []start) {
		Queue<int[]> q = new LinkedList<>();
		q.add(start);
		vis[start[0]][start[1]] = true;
		
		while(!q.isEmpty()) {
			int []cur = q.poll();
			
			int x = cur[0];
			int y = cur[1];
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 'X' || vis[nx][ny] == true) {
					continue;
				}
				
				if(map[nx][ny] == 'P') {
					answer++;
				}
				
				vis[nx][ny] = true;
				q.add(new int[] {nx, ny});
			}
		}
	}
}

