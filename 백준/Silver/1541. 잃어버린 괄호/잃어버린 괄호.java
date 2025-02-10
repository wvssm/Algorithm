import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String input = br.readLine();
        int plus = 0;
        int minus = 0;
        int sum = 0;
        int val = 0;
        boolean hasMinus = false;
        for(int i=0; i<input.length(); i++) {
        	if(input.charAt(i)=='-') {
        		if(hasMinus) {
        			sum += val * (-1);
        			val =0;
        		}
        		else{
        			sum += val;
        			val =0;
        			hasMinus = true;
        		}
        	
        	} else if(input.charAt(i)=='+') {
        		if(hasMinus) {
        			sum += val * (-1);
        			val =0;
        		}
	        	else {
	        		sum += val;
	        		val = 0;
	        	}
        	} else {
        		val = val *10 + input.charAt(i)-'0';
        	}
        }
        
        if(hasMinus) {
			sum += val * (-1);
		} else {
			sum += val;
		}
        
        bw.append(String.valueOf(sum));
        bw.flush();
        bw.close();
        
    }
}