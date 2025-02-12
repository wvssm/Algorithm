import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	
    	int []arr = new int [n];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	Arrays.sort(arr);
    	
    	st = new StringTokenizer(br.readLine());
    	int x = Integer.parseInt(st.nextToken());
    	
    	int start = 0;
    	int end = n-1;
    	int count = 0;
    	
    	while(start < end) {
    		if(arr[start]+arr[end] < x) {
    			start++;
    		} else if(arr[start]+arr[end] > x) {
    			end--;
    		} else {
    			start++;
    			count++;
    		}
    	}
    	
    	bw.append(String.valueOf(count));
    	bw.flush();
    	bw.close();
    	
    }
}