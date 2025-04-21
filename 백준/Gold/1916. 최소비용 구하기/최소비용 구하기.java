import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static List<Node>[] graph;
	static int minCost[];
	static int V, E, START, END;
	static PriorityQueue<Node> pq; // 타입 넣어주기, 아니면 Object로 생각함
	
	static class Node{
		int dest;
		int cost;
		
		public Node(int dest, int cost) {
			super();
			this.dest = dest;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws Exception {
		input();
		
		pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
		minCost[START] = 0;
		pq.add(new Node(START, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.cost > minCost[cur.dest]) continue;
			
			minCost[cur.dest] = cur.cost;
			
			for(Node next : graph[cur.dest]) {
				int newCost = cur.cost + next.cost;
				if(newCost < minCost[next.dest]) {
					minCost[next.dest] = newCost;
					pq.add(new Node(next.dest, newCost));
				}
			}
			
		}
		
		System.out.println(minCost[END]);
		
	}
	
	static void input() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine().trim());
		E = Integer.parseInt(br.readLine().trim());
		
		graph = new List[V+1];
		
		for(int i=0; i<=V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		minCost = new int[V+1];
		Arrays.fill(minCost, Integer.MAX_VALUE);
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[from].add(new Node(to, cost));
		}
		
		st = new StringTokenizer(br.readLine().trim());
		START = Integer.parseInt(st.nextToken());
		END = Integer.parseInt(st.nextToken());
	}
}
