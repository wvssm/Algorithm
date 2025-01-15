import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Stream;

class Main{
	static int[] parent = new int[1000001];
	
	
	public static int find(int a) {
		if(parent[a]!=a) {
			parent[a] = find(parent[a]);
		}
		return parent[a];
	}
	
	public static boolean union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		
		if(parentA == parentB) {
			return false;
		}
		
		if(parentA <= parentB) {
			parent[parentB] = parentA;
		} else {
			parent[parentA] = parentB;
		}
		
		return true;
	}
	
	public static void main(String args[]) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int sign  = 0;
		int a = 0;
		int b = 0;
		
		// parent 배열 초기화 
		for(int i=1; i<=n; i++) {
			parent[i] = i;
		}
		
		// 각 관계 파악
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine()); 
			sign = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			if(sign==0) {
				Main.union(a, b);
			}
			
			if(sign==1) {
				if(find(a)==find(b)) {
					bw.append("YES");
					bw.newLine();
				} else {
					bw.append("NO");
					bw.newLine();
				}
			}
		}
		
		bw.flush();
		
	}
}