import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static char map[][];
    static int dvis[][];
    static int vis[][];
    static int R, C, sx, sy, ex, ey, answer;
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static Queue<int[]> q;
    
    public static void main(String[] args) throws Exception {
    	input();
    	sol();
    }
    
    static void sol() {
    	vis[sx][sy] = 1;
    	q.add(new int[] {sx, sy});
    	
    	while(!q.isEmpty()) {
    		int[] cur = q.poll();
    		int cx = cur[0];
    		int cy = cur[1];
    		
    		if(cx == ex && cy == ey) break;
    		for(int i=0; i<4; i++) {
    			int nx = cx + dx[i];
    			int ny = cy + dy[i];
    			
    			if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
    			if(map[nx][ny] == 'X' || vis[nx][ny] > 0) continue;
    			if(map[cx][cy] == '*' && map[nx][ny] == 'D') continue;
    			
    			if(map[cx][cy] == '*') {
    				map[nx][ny] = '*';
    			} else if(map[cx][cy] == 'S') {
    				map[nx][ny] = 'S';
    			}
    			
    			vis[nx][ny] = vis[cx][cy]+1;
    			if(nx == ex && ny == ey) break;
    			q.add(new int[] {nx, ny});
    		}
    	}
    	
    	if(vis[ex][ey] == 0) {
    		System.out.println("KAKTUS");
    	} else {
    		System.out.println(vis[ex][ey]-1);
    	}    
    	
//    	for(int i=0; i<R; i++) {
//    		for(int j=0; j<C; j++) {
//    			System.out.print(map[i][j]);
//    		}
//    		System.out.println();
//    	}
//    	
//    	for(int i=0; i<R; i++) {
//    		for(int j=0; j<C; j++) {
//    			System.out.print(vis[i][j]);
//    		}
//    		System.out.println();
//    	}
    }
    
    static void input() throws Exception {
    	br = new BufferedReader(new InputStreamReader(System.in));
    	st = new StringTokenizer(br.readLine().trim());
    	
    	R = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	
    	map = new char[R][C];
    	vis = new int[R][C];
    	
    	q = new ArrayDeque<>();
    	
    	for(int i=0; i<R; i++) {
    		String input = br.readLine().trim();
    		for(int j=0; j<C; j++) {
    			map[i][j] = input.charAt(j);
    			if(map[i][j] == 'S') {
    				sx = i;
    				sy = j;
    			}
    			else if(map[i][j] == 'D') {
    				ex = i;
    				ey = j;
    			}
    			else if(map[i][j] == '*') {
    				q.add(new int[] {i, j});
    				vis[i][j] = 1;
    			}
    		}
    	}
    }
}
