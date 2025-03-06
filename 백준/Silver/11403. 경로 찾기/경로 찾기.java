import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int N, input;
	static List<Integer>[] edges;
	static int vis[][];
	
	public static void main(String[] args) throws IOException {
		input();
		
		vis = new int[N][N];
		
		for(int i=0; i<N; i++) {
			dfs(i, i);
		}
		
		print();
	}
	
	static void dfs(int start, int parent) {	
		for(int edge : edges[start]) {
			
			if(vis[parent][edge] == 1) {
				continue;
			}
			
			vis[parent][edge] = 1;
			dfs(edge, parent);
		}
	}
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		
		edges = new ArrayList[N];
		
		for(int i=0; i<N; i++) {
			edges[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				input = Integer.parseInt(st.nextToken());
				if(input == 1) {
					edges[i].add(j);
				}
			}
		}
	}
	
	static void print() {
		sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(vis[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}
}
