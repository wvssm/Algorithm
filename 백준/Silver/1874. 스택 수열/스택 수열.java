import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringBuilder sb = new StringBuilder();
//    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	int []arr = new int[n];
    	
    	for(int i=0; i<n; i++) {
    		arr[i] = Integer.parseInt(br.readLine());
    	}
    	
    	int cur = 0;
    	Stack<Integer> st = new Stack<>();
    	
    	for(int i=0; i<n; i++) {
    		// 넣기
    		if(cur < arr[i]) {
    			for(int j=cur+1; j<=arr[i]; j++) {
    				st.add(j);
    				sb.append("+\n");
    			}
    			cur = arr[i];
    		}
    		
    		// 같으면 pop
    		if(!st.isEmpty() && arr[i] == st.peek()) {
    			st.pop();
    			sb.append("-\n");
    		} else {
    			sb.setLength(0);
    			sb.append("NO");
    			break;
    		}
    		
    	}

    	bw.append(sb.toString());
    	bw.flush();
    	bw.close();
    	
    }
}