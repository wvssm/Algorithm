import java.util.*;
import java.io.*;

/*
 * month[i] > 0 인 경우에만 재귀 돌림
 * 1일
 * 1달
 * 3달
 * N >= 12이면 멈춤
 */
class Solution
{
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int day, oneMonth, threeMonth, year, minCost;
    static int month[];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String args[]) throws Exception {
    	br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        int T;
        T = Integer.parseInt(st.nextToken());
  
        for(int test_case = 1; test_case <= T; test_case++)
        {
            input();
            
            minCost = year;
            
            dfs(0, 0);
              
            sb.append("#").append(test_case).append(" ").append(minCost).append("\n");
        }
        System.out.println(sb.toString());
    }
    
    static void dfs(int depth, int cost) {
    	if(depth >= 12) {
    		if(minCost > cost) {
    			minCost = cost;
    		}
    		return;
    	}
    	
    	if(month[depth]>0) {
    		dfs(depth+1, cost + month[depth] * day);
    		  
        	dfs(depth+1, cost + oneMonth);
        	
        	dfs(depth+3, cost + threeMonth);
    	} else {
    		dfs(depth+1, cost);
    	}
    }
      
    
    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        day = Integer.parseInt(st.nextToken());
        oneMonth = Integer.parseInt(st.nextToken());
        threeMonth = Integer.parseInt(st.nextToken());
        year = Integer.parseInt(st.nextToken());
        
        month = new int[12];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<12; i++) {
        	month[i] = Integer.parseInt(st.nextToken());
        }
    }
}