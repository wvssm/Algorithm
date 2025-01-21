import java.io.*;
import java.util.*;

class Main{	
	static int[][] map;
	static boolean [] visited;
	static int cnt = 0;
	static int n = 0;
	
	public static void main(String args[])throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		st = new StringTokenizer(br.readLine());
		int line = Integer.parseInt(st.nextToken());
		
		// 입력받기 
		for(int i=0; i<line; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		bfs(1);
		
		bw.append(String.valueOf(cnt));
		bw.flush();
		bw.close();
	}
	
	static void bfs(int num) {
		Queue<Integer> q = new LinkedList<>();
		
		visited[num] = true;
		q.add(num);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i=1; i<=n; i++) {
				if(map[cur][i] == 1 && visited[i]==false) {
					cnt++;
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}
}
