import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int map[][];
    static int vis[][][];
    static int N, M, answer;
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    
    public static void main(String[] args) throws Exception {
    	input();
    	sol();
    }
    
    static void sol() {
    	vis = new int [2][N][M];
    	
    	bfs(0,0,0);
    	
    	
    	if(vis[0][N-1][M-1] == 0 && vis[1][N-1][M-1] == 0) {
    		answer = -1;
    	} else {
    		answer = Math.max(vis[0][N-1][M-1], vis[1][N-1][M-1]);
    	}
    	
    	System.out.println(answer);
    }
    
    static void bfs(int x, int y, int wall) {
    	vis[0][x][y] = 1;
    	
    	Queue<int[]> q = new ArrayDeque<>();
    	
    	q.add(new int[] {x, y, wall});
    	
    	while(!q.isEmpty()) {
    		int cur[] = q.poll();
    		
    		int cx = cur[0];
    		int cy = cur[1];
    		int cwall = cur[2];
    		if(cx == N-1 && cy == M-1) {
    			return;
    		}
    		
    		for(int i=0; i<4; i++) {
    			int nx = cx + dx[i];
    			int ny = cy + dy[i];
    			
    			if(nx < 0 || nx >= N || ny < 0 || ny >=M) continue;
    			
    			// 벽이 아닌 경우 (벽을 뚫은 경우 & 벽을 안뚫은 경우 둘다 포함해야함)
    			if(map[nx][ny] == 0 && vis[cwall][nx][ny] == 0) {
    				vis[cwall][nx][ny] = vis[cwall][cx][cy] + 1;
    				q.add(new int[] {nx, ny, cwall});
    			}
    			
    			// 벽인 경우
    			else if(map[nx][ny] == 1 && vis[1][nx][ny] == 0 && cwall == 0) {
    				vis[1][nx][ny] = vis[cwall][cx][cy] + 1;
    				q.add(new int[] {nx, ny, 1});
    			}
    		}
    	}
    }
    
    static void input() throws Exception {
    	br = new BufferedReader(new InputStreamReader(System.in));
    	st = new StringTokenizer(br.readLine().trim());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	map = new int[N][M];
    	
    	for(int i=0; i<N; i++) {
    		String input = br.readLine().trim();
    		for(int j=0; j<M; j++) {
    			map[i][j] = input.charAt(j) - '0';
    		}
    	}
    }
}
