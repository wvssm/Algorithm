import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Stream;

class Main{
	public static void main(String args[]) throws IOException {
		HashMap<String, Integer> mem = new HashMap<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int cnt = 0;
		List<String> list = new ArrayList<>();
		
		String answer;
		
		for(int i=0; i<n; i++) {
			mem.put(br.readLine(), 1);
		}
		
		for(int i=0; i<m; i++) {
			answer = br.readLine();
			if(mem.containsKey(answer)) {
				list.add(answer);
				cnt++;
			}
		}
		
		MyComparator comparator = new MyComparator();
		Collections.sort(list, comparator);
		
		bw.append(String.valueOf(cnt)+"\n");
		for(String name : list) {
			bw.append(name);
			bw.newLine();
		}
		bw.flush();
		
	}
	
	static class MyComparator implements Comparator<String>{
		@Override
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}
	}
}