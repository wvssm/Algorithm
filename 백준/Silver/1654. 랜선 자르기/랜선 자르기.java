import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int k = Integer.parseInt(st.nextToken());
    	int n = Integer.parseInt(st.nextToken());
    	
    	long []arr = new long[k];

    	long min_val = 1l;
    	long max_val = 0l;
    	long mid_val = 0l;
    	
    	for(int i=0; i<k; i++) {
    		st = new StringTokenizer(br.readLine());
    		arr[i] = Long.parseLong(st.nextToken());
    		if(max_val < arr[i]) {
    			max_val = arr[i];
    		}
    	}
    	

    	
    	while(min_val <= max_val) { // 최솟값이 최댓값과 같아질 때 까지
    		// 중간 값 구하기
    		mid_val = (min_val + max_val)/2;
    		
    		// 현재 랜선 개수 구하기
    		long cnt = 0l;
    		for(int i=0; i<k; i++) {
    			cnt += arr[i]/mid_val;
    		}
    		

    		// 랜선개수가 우리가 원하는 것 보다 작거나 같다면 -> 길이 단축
    		if(cnt < (long)n) {
    			max_val = mid_val - 1;
    		} else { // 랜선 개수가 우리가 원하는 것보다 크다면 -> 길이 길게
    			min_val = mid_val + 1;
    		}
    	}
    	
    	bw.append(String.valueOf(max_val));
    	bw.flush();
    	bw.close();
    	
    }
}