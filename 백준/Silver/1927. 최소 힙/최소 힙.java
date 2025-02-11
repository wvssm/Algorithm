import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	PriorityQueue pq = new PriorityQueue<>();
    	
    	for(int i=0; i<n; i++) {
    		int input = Integer.parseInt(br.readLine());
    		
    		if(input == 0) {
    			if(pq.size()==0) {
    				bw.append("0\n");
    			} else {
    				bw.append(pq.poll()+"\n");
    			}
    		} else {
    			pq.add(input);
    		}
    	}
    	bw.flush();
    	bw.close();
    }
}