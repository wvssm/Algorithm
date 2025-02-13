import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	long m = Integer.parseInt(st.nextToken());
    	
    	long []arr = new long[n];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	long min = 1l;
    	long max = 0l;
    	long mid = 0l;
    	long cnt = 0l;
    	
    	for(int i=0; i<n; i++) {
    		if(max < arr[i]) {
    			max = arr[i];
    		}
    	}
    	
    	while(min<=max) {
    		cnt = 0;
    		mid = (min + max)/2;
    		for(int i=0; i<n; i++) {
    			if(arr[i]-mid>0) {
    				cnt += (arr[i]-mid);
    			}
    		}
    		
    		if(cnt >= m) {
    			min = mid+1;
    		} else {
    			max = mid-1;
    		}
    	}

    	bw.append(String.valueOf(max));
    	bw.flush();
    	bw.close();
    	
    }
}