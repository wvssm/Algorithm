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
    	
    	// end가 끝까지 올 때 까지
    	while(start < n) {
    		// 합이 목표값 보다 크거나 같으면 start 포인터 ++
    		if(sum > m || end == n) {
    			sum -= arr[start++];
    		}
    		// 합이 목표값보다 작으면 end 포인터++
    		else {
    			sum += arr[end++];
    		}
    		
    		// 값이 같으면 answer +1
    		if(sum == m) {
    			answer += 1;
    		}
    	}
    	
    	bw.append(String.valueOf(answer));
    	bw.flush();
    	bw.close();
    	
    }
}