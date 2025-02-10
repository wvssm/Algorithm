import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int test_case = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<test_case; i++) {
        	st = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	int m = Integer.parseInt(st.nextToken());
        	
        	int []arr = new int[n];
        	
        	Queue<int[]> q = new LinkedList<>();
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<n; j++) {
        		int val = Integer.parseInt(st.nextToken());
        		q.add(new int[] {val,j});
        		arr[j] = val;
        	}
        	
        	Arrays.sort(arr);
        	int index = n-1;
        	int cnt = 0;
        	while(true) {
        		int num = q.peek()[0];
        		int pos = q.peek()[1];
        		
        		if(num == arr[index]) {
        			cnt++;
        			q.poll();
        			index--;
        			if(pos == m) {
        				bw.append(String.valueOf(cnt)+'\n');
        				break;
        			}
        		} else {
        			int[] small = q.poll();
        			q.add(small);
        		}
        	}
        }
        bw.flush();
        bw.close();
        
    }
}