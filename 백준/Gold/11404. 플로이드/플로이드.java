import java.util.*;
import java.io.*;

// 양방향 아니였음
// A->B 직방이 하나가 아닐 수 있었음.... 
public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static final int INF = 987654321;
	
	static int N, M, count, answer;
	static int[][] map;
	static boolean[][] vis;
	
	public static void main(String[] args) throws IOException {
		input();
		
		floyd();
		
		print();
	}
	
	static void floyd() {
		for(int mid=1; mid<=N; mid++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(i==j) continue;
					
					map[i][j] = Math.min(map[i][j], map[i][mid] + map[mid][j]);
				}
			}
		}
	}
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];

		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) continue;
				map[i][j] = INF;
			}
		}

		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			map[start][end] = Math.min(map[start][end], cost);
		}
	}
	
	static void print() {
		sb = new StringBuilder();
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(map[i][j] == INF) {
					map[i][j]=0;
				}
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
}
