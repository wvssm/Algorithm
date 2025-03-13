import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int V, E, K, count;
	static List<Node>[] graph;
	static int[] minCost;
	
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	
	static boolean isHead, isError;

	static class Node{
		int dest;
		int cost;
		
		Node(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
	}
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		sb = new StringBuilder();
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(br.readLine().trim());

		graph = new List[V+1];
		
		for(int i=1; i<=V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new Node(v,w));
		}
				
		minCost = new int[V+1];
		Arrays.fill(minCost, Integer.MAX_VALUE);
		
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
		minCost[K] = 0;
		pq.offer(new Node(K,0));
		
		while(!pq.isEmpty()) {
			// 최단거리 노드 구해옴
			Node cur = pq.poll();
			
			if(cur.cost > minCost[cur.dest]) {
				continue;
			}
			
			// 최단 거리 노드 기준으로 거리 업데이트 
			for(Node next : graph[cur.dest]) {
				int newCost = cur.cost + next.cost;
				if(newCost < minCost[next.dest]) {
					minCost[next.dest] = newCost;
					pq.offer(new Node(next.dest, newCost));
				}
			}
		}
		
		for(int i=1; i<=V; i++) {
			if(minCost[i]==Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
			} else {
				sb.append(minCost[i]).append("\n");
			}
		}
		
		System.out.print(sb.toString());
		
	}
	
	

}
