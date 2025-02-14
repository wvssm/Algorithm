import java.io.*;
import java.util.*;

class Main {
	static int n, count;
	static int []arr;
	static boolean []visited;
	static int []nums;
	static BufferedWriter bw;
	
    public static void main(String args[]) throws IOException {    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    	StringBuilder sb = new StringBuilder();
//    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(br.readLine());
    	
    	arr = new int[n];
    	for(int i=1; i<=n; i++) {
    		arr[i-1] = i;
    	}
    	nums = new int[n];
    	visited = new boolean[n];
    	
    	perm(0);
    	
    	bw.flush();
    	bw.close();
    	
    }
    
    static void perm(int depth) throws IOException {
    	if(depth == n) {
    		for(int i=0; i<n; i++) {
    			bw.append(nums[i] + " ");
    		}
    		bw.newLine();
    		return;
    	}
    	
    	for(int i=0; i<n; i++) {
    		if(visited[i] == false) {
    			visited[i] = true;
    			nums[depth] = arr[i];
    			perm(depth+1);
    			nums[depth] = 0;
    			visited[i] = false;
    		}
    	}
    }
}