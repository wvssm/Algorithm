import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	int []arr = new int [n];
    	Long sum = 0l;
    	Map<Integer, Integer> m = new HashMap<>();
    	
    	for(int i=0; i<n; i++) {
    		arr[i] = Integer.parseInt(br.readLine());
    		sum += (long)arr[i];
    		
    		if(m.containsKey(arr[i])) {
    			m.put(arr[i], m.get(arr[i])+1);
    		} else {
    			m.put(arr[i], 1);
    		}
    	}
    	
    	Arrays.sort(arr);
    	
    	// 산술 평균
    	long val1 = (long) Math.round((double) sum / n);
    	
    	// 중앙값
    	int val2 = arr[n/2];
    	
    	// 최빈 값
    	int max_count = -1;
    	
    	List<Integer> vals= new ArrayList<>();
    	
    	for(int num : m.keySet()) {
    		if(max_count < m.get(num)) {
    			max_count = m.get(num);
    		}
    	}
    	
    	for(int num : m.keySet()) {
    		if(max_count == m.get(num)) {
    			vals.add(num);
    		}
    	}
    	
    	Collections.sort(vals);
    	
    	int val3 = 0;
    	if(vals.size() == 1){
    		val3 = vals.get(0);
    	} else {
    		val3 = vals.get(1);
    	}
    	
    	// 범위
    	int val4 = arr[n-1] - arr[0];
    	
    	bw.append(String.valueOf(val1)+"\n");
    	bw.append(String.valueOf(val2)+"\n");
    	bw.append(String.valueOf(val3)+"\n");
    	bw.append(String.valueOf(val4));
    	bw.flush();
    	bw.close();
    }
}