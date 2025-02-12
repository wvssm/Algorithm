import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	int []arr = new int[n];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int start = 0;
    	int end = 0;
    	int sum = 0;
    	int answer = 0;
    	
    	while(end <= n-1) {
    		if(sum <= m) {
    			sum += arr[end++];
    		}
    		if(sum > m) {
    			sum -= arr[start++];
    		}
    		if(sum == m) {
    			answer += 1;
    		}
    	}
    	
    	bw.append(String.valueOf(answer));
    	bw.flush();
    	bw.close();
    	
    }
}