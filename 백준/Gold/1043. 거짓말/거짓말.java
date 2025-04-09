import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int cnt;
	static int parent[];
	static int rank[];
	static int truePersons[];
	static int N, M, truePersonNum;
	static int party[][];
	static int partyPerson[];
	
	
	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		
		input();
		
		make();
		
		for(int i=1; i<truePersonNum; i++) {
			union(truePersons[0], truePersons[i]);
		}
		
		
		for(int i=0; i<M; i++) {
			for(int j=1; j<partyPerson[i]; j++) {
				union(party[i][0], party[i][j]);
			}
		}
		
		Set<Integer> set = new HashSet<>();
		
		if(truePersonNum > 0) {
			int trueRoot = find(truePersons[0]);
			
			for(int i=1; i<=N; i++) {
				if(find(i) != trueRoot) {
					set.add(i);
				}
			}
			
			
			boolean sign = true;
			
			for(int i=0; i<M; i++) {
				sign = true;
				for(int j=0; j<partyPerson[i]; j++) {
					if(!set.contains(party[i][j])){
						sign = false;
						break;
					}
				}
				if(sign) {
					cnt++;
				}
			}
		} else {
			cnt = M;
		}
		
		
		System.out.println(cnt);
	}
	
	static void make() {
	    parent = new int[N+1];
	    rank = new int[N+1];
	    for (int i = 1; i <= N; i++) {
	        parent[i] = i;
	    }
	}
	
	static int find(int a) {
		if(a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) {
			return false;
		}
		
		if(rank[aRoot] > rank[bRoot]) {
			parent[bRoot] = aRoot;
		} else if(rank[aRoot] < rank[bRoot]) {
			parent[aRoot] = bRoot;
		} else {
			parent[bRoot] = aRoot;
			rank[aRoot]++;
		}

		return true;
	}
	
	
	static void input() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		party = new int[51][51];
		partyPerson = new int[51];
		
		st = new StringTokenizer(br.readLine().trim());
	    truePersonNum = Integer.parseInt(st.nextToken());
		
		truePersons = new int[truePersonNum];
		for(int i=0; i<truePersonNum; i++) {
			truePersons[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			partyPerson[i] = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<partyPerson[i]; j++) {
				party[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
